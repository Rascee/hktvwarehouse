package com.hktv.warehouse.warehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
@Builder
public class Stock {
    @EmbeddedId
    @JsonIgnore
    private StockPK stockPK;
    private Long quantity;

//    @Column(name = "product_code", insertable = false, updatable = false)
//    private String productCode;
//
//    @Column(name = "warehouse_code", insertable = false, updatable = false)
//    private String warehouseCode;

    @MapsId("productCode")
    @ManyToOne
    @JsonIgnore
    private Product product;

    @MapsId("warehouseCode")
    @ManyToOne
    @JsonIgnore
    private Warehouse warehouse;
}
