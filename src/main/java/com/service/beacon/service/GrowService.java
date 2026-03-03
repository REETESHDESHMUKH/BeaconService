package com.service.beacon.service;

import com.service.beacon.dto.response.PortfolioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class GrowService {
    @Value("${grow.api.base-url}")
    private String growApiBaseUrl;

    @Value("${GROW_API_TOKEN}")
    private String growApiToken;

    private WebClient getClient() {
        return WebClient.builder()
                .baseUrl(growApiBaseUrl)
                .defaultHeader("Authorization", "Bearer " + growApiToken)
                .defaultHeader("Accept", "application/json")
                .defaultHeader("X-API-VERSION", "1")
                .build();
    }

    public PortfolioResponse getPortfolio() {
        return getClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/holdings/user")
                        .build())
                .retrieve()
                .bodyToMono(PortfolioResponse.class)
                .block();
    }
}
