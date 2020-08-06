package com.hktv.warehouse.warehouse.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StockPK implements Serializable {
    private String productCode;
    private String warehouseCode;
}
