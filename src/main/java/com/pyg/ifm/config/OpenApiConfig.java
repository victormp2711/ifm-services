package com.pyg.ifm.config;

import com.pyg.ifm.exception.ApiErrorResponse;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apacuanaOpenAPI() {
        Schema<ApiErrorResponse> errorSchema = new Schema<>();
        errorSchema.setName("ApiErrorResponse");
        errorSchema.addProperties("timestamp", new Schema<>().type("string").format("date-time"));
        errorSchema.addProperties("status", new Schema<>().type("integer"));
        errorSchema.addProperties("error", new Schema<>().type("string"));
        errorSchema.addProperties("type", new Schema<>().type("string")
                .description("BUSINESS | UPSTREAM | CIRCUIT_OPEN"));
        errorSchema.addProperties("message", new Schema<>().type("string"));
        errorSchema.addProperties("path", new Schema<>().type("string"));
        errorSchema.addProperties("upstreamBody", new Schema<>().type("string"));

        Content errorContent = new Content()
                .addMediaType("application/json", new MediaType().schema(errorSchema));

        return new OpenAPI()
                .components(new Components()
                        .addSchemas("ApiErrorResponse", errorSchema)
                        .addResponses("BusinessError", new ApiResponse()
                                .description("Error de negocio propagado del servicio externo (4xx)")
                                .content(errorContent))
                        .addResponses("UpstreamError", new ApiResponse()
                                .description("Fallo del servicio externo (5xx, red o timeout)")
                                .content(errorContent))
                        .addResponses("CircuitOpen", new ApiResponse()
                                .description("Circuit breaker abierto; servicio externo no disponible")
                                .content(errorContent)))
                .info(new Info()
                        .title("IFM API")
                        .description("API base para integrar endpoints definidos en la colección Postman")
                        .version("v0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación Postman")
                        .url("https://documenter.getpostman.com/view/23335466/2sA3s7kUqs"));
    }
}





