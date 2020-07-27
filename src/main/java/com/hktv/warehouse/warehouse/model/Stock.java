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
    @JsonIgnore
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "productCode", column = @Column(name = "product_code")),
            @AttributeOverride(name = "warehouseCode", column = @Column(name = "warehouse_code"))
    })
    private StockPK stockPK;
    private Long quantity;

    @MapsId("productCode")
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "product_code")
    @JsonIgnore
    private Product product;

    @MapsId("warehouseCode")
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "warehouse_code")
    @JsonIgnore
    private Warehouse warehouse;
}
