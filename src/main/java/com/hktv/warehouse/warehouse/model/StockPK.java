package com.hktv.warehouse.warehouse.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class StockPK implements Serializable {
    private String productCode;
    private String warehouseCode;
}
