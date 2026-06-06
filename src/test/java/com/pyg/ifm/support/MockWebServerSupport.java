package com.pyg.ifm.support;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.springframework.test.context.DynamicPropertyRegistry;

import java.io.IOException;

public final class MockWebServerSupport {

    private MockWebServerSupport() {
    }

    public static MockWebServer start() throws IOException {
        MockWebServer server = new MockWebServer();
        server.start();
        return server;
    }

    public static void registerBaseUrl(DynamicPropertyRegistry registry, MockWebServer server) {
        registry.add("api.externa.base-url", () -> server.url("/").toString().replaceAll("/$", ""));
    }

    public static MockResponse jsonResponse(int status, String json) {
        return new MockResponse()
                .setResponseCode(status)
                .addHeader("Content-Type", "application/json")
                .setBody(json);
    }
}
