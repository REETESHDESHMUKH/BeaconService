package com.service.beacon.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PortfolioResponse {
    private String status;
    private Payload payload;

    @Data
    public static class Payload {
        private List<Holding> holdings;
    }

    @Data
    public static class Holding {
        private String isin;

        @JsonProperty("trading_symbol")
        private String tradingSymbol;

        private Integer quantity;

        @JsonProperty("average_price")
        private Double averagePrice;

        @JsonProperty("pledge_quantity")
        private Integer pledgeQuantity;

        @JsonProperty("demat_locked_quantity")
        private Integer dematLockedQuantity;

        @JsonProperty("groww_locked_quantity")
        private Double growwLockedQuantity;

        @JsonProperty("repledge_quantity")
        private Double repledgeQuantity;

        @JsonProperty("t1_quantity")
        private Integer t1Quantity;

        @JsonProperty("demat_free_quantity")
        private Integer dematFreeQuantity;

        @JsonProperty("corporate_action_additional_quantity")
        private Integer corporateActionAdditionalQuantity;

        @JsonProperty("active_demat_transfer_quantity")
        private Integer activeDematTransferQuantity;
    }
}
