package com.pyg.ifm.modules.cuentas.controller;

import com.pyg.ifm.support.MockWebServerSupport;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
class CuentasControllerIntegrationTest {

    private static MockWebServer mockWebServer;

    @Autowired
    private WebTestClient webTestClient;

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
    void apertura_retorna200CuandoUpstreamEsExitoso() {
        mockWebServer.enqueue(MockWebServerSupport.jsonResponse(
                200,
                """
                {"numeroCuenta":"999","tipoCuenta":"CORRIENTE","fechaApertura":"2026-06-02 12:00:00"}
                """
        ));

        webTestClient.post()
                .uri("/cuentas/apertura")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"idClienteRfc\":\"RFC123\"}")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.numeroCuenta").isEqualTo("999")
                .jsonPath("$.tipoCuenta").isEqualTo("CORRIENTE");
    }

    @Test
    void apertura_retorna400BusinessCuandoUpstreamRechaza() {
        mockWebServer.enqueue(MockWebServerSupport.jsonResponse(
                422,
                """
                {"error":"VALIDACION","detalle":"RFC invalido"}
                """
        ));

        webTestClient.post()
                .uri("/cuentas/apertura")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"idClienteRfc\":\"\"}")
                .exchange()
                .expectStatus().isEqualTo(422)
                .expectBody()
                .jsonPath("$.type").isEqualTo("BUSINESS")
                .jsonPath("$.status").isEqualTo(422)
                .jsonPath("$.upstreamBody").value(body -> body.toString().contains("VALIDACION"));
    }

    @Test
    void apertura_retorna502CuandoUpstreamFalla() {
        mockWebServer.enqueue(MockWebServerSupport.jsonResponse(
                500,
                """
                {"mensaje":"Error interno del core"}
                """
        ));

        webTestClient.post()
                .uri("/cuentas/apertura")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"idClienteRfc\":\"RFC123\"}")
                .exchange()
                .expectStatus().is5xxServerError()
                .expectBody()
                .jsonPath("$.type").isEqualTo("UPSTREAM")
                .jsonPath("$.message").exists();
    }
}
