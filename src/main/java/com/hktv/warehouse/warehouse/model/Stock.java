package com.hktv.warehouse.warehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
@Builder
public class Stock {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "productCode", column = @Column(name = "product_code")),
            @AttributeOverride(name = "warehouseCode", column = @Column(name = "warehouse_code"))
    })
    private StockPK stockPK = new StockPK();
    private BigDecimal quantity;

    @MapsId("productCode")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "product_code")
    @JsonIgnore
    private Product product;

    @MapsId("warehouseCode")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "warehouse_code")
    @JsonIgnore
    private Warehouse warehouse;
}
