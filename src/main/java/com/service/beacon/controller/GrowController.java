package com.service.beacon.controller;

import com.service.beacon.dto.response.PortfolioResponse;
import com.service.beacon.service.GrowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2/grow")
@Slf4j
@RequiredArgsConstructor
public class GrowController {
    private final GrowService growService;

    @GetMapping("/portfolio")
    public ResponseEntity<PortfolioResponse> getHoldings() {
        try {
            log.info("Fetching portfolio from Grow API");
            PortfolioResponse portfolioResponse = growService.getPortfolio();
            return ResponseEntity.ok(portfolioResponse);
        } catch (Exception e) {
            log.error("Error fetching portfolio from Grow API", e);
            return ResponseEntity
                    .status(500)
                    .body(null);
        }
    }
}
