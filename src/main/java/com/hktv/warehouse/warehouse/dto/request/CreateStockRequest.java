package com.hktv.warehouse.warehouse.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateStockRequest {
    private String productCode;
    private String warehouseCode;
    private BigDecimal quantity;
}
