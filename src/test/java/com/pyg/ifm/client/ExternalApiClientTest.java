package com.pyg.ifm.client;

import com.pyg.ifm.exception.ApiErrorType;
import com.pyg.ifm.exception.BusinessApiException;
import com.pyg.ifm.exception.UpstreamApiException;
import com.pyg.ifm.modules.cuentas.model.AperturaCuentaResponse;
import com.pyg.ifm.support.MockWebServerSupport;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import reactor.test.StepVerifier;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ExternalApiClientTest {

    private static MockWebServer mockWebServer;

    @Autowired
    private ExternalApiClient externalApiClient;

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) throws IOException {
        mockWebServer = MockWebServerSupport.start();
        MockWebServerSupport.registerBaseUrl(registry, mockWebServer);
    }

    @AfterAll
    static void shutdown() throws IOException {
        if (mockWebServer != null) {
            mockWebServer.shutdown();
        }
    }

    @Test
    void post_retornaRespuestaCuandoUpstreamResponde200() {
        mockWebServer.enqueue(MockWebServerSupport.jsonResponse(
                200,
                """
                {"numeroCuenta":"123","tipoCuenta":"AHORRO","fechaApertura":"2026-06-02 10:00:00"}
                """
        ));

        StepVerifier.create(externalApiClient.post(
                        "/cuentas/apertura",
                        "{}",
                        AperturaCuentaResponse.class,
                        "test-cuentas-apertura-ok"
                ))
                .assertNext(response -> {
                    assertThat(response.getNumeroCuenta()).isEqualTo("123");
                    assertThat(response.getTipoCuenta()).isEqualTo("AHORRO");
                })
                .verifyComplete();
    }

    @Test
    void post_propagaBusinessApiExceptionEn4xx() {
        mockWebServer.enqueue(MockWebServerSupport.jsonResponse(
                400,
                """
                {"codigo":"CUENTA_INVALIDA","mensaje":"Producto no permitido"}
                """
        ));

        StepVerifier.create(externalApiClient.post(
                        "/cuentas/apertura",
                        "{}",
                        AperturaCuentaResponse.class,
                        "test-cuentas-apertura-4xx"
                ))
                .expectErrorSatisfies(error -> {
                    assertThat(error).isInstanceOf(BusinessApiException.class);
                    BusinessApiException business = (BusinessApiException) error;
                    assertThat(business.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
                    assertThat(business.getErrorType()).isEqualTo(ApiErrorType.BUSINESS);
                    assertThat(business.getUpstreamBody()).contains("CUENTA_INVALIDA");
                })
                .verify();
    }

    @Test
    void post_propagaUpstreamApiExceptionEn5xx() {
        mockWebServer.enqueue(MockWebServerSupport.jsonResponse(
                503,
                """
                {"mensaje":"Core no disponible"}
                """
        ));

        StepVerifier.create(externalApiClient.post(
                        "/cuentas/apertura",
                        "{}",
                        AperturaCuentaResponse.class,
                        "test-cuentas-apertura-5xx"
                ))
                .expectErrorSatisfies(error -> {
                    assertThat(error).isInstanceOf(UpstreamApiException.class);
                    UpstreamApiException upstream = (UpstreamApiException) error;
                    assertThat(upstream.getStatus()).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE);
                    assertThat(upstream.getErrorType()).isEqualTo(ApiErrorType.UPSTREAM);
                })
                .verify();
    }

    @Test
    void post_abreCircuitBreakerTrasFallosConsecutivos() {
        String circuitName = "test-cuentas-apertura-cb-open";
        mockWebServer.enqueue(MockWebServerSupport.jsonResponse(500, "{}"));
        mockWebServer.enqueue(MockWebServerSupport.jsonResponse(500, "{}"));

        StepVerifier.create(externalApiClient.post(
                        "/cuentas/apertura",
                        "{}",
                        AperturaCuentaResponse.class,
                        circuitName
                )).expectError(UpstreamApiException.class).verify();

        StepVerifier.create(externalApiClient.post(
                        "/cuentas/apertura",
                        "{}",
                        AperturaCuentaResponse.class,
                        circuitName
                )).expectError(UpstreamApiException.class).verify();

        int requestsBeforeCircuitOpen = mockWebServer.getRequestCount();

        StepVerifier.create(externalApiClient.post(
                        "/cuentas/apertura",
                        "{}",
                        AperturaCuentaResponse.class,
                        circuitName
                ))
                .expectErrorSatisfies(error -> {
                    assertThat(error).isInstanceOf(UpstreamApiException.class);
                    UpstreamApiException upstream = (UpstreamApiException) error;
                    assertThat(upstream.getErrorType()).isEqualTo(ApiErrorType.CIRCUIT_OPEN);
                    assertThat(upstream.getStatus()).isEqualTo(HttpStatus.SERVICE_UNAVAILABLE);
                })
                .verify();

        assertThat(mockWebServer.getRequestCount()).isEqualTo(requestsBeforeCircuitOpen);
    }
}
