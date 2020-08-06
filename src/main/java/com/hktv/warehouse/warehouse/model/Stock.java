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
@IdClass(StockPK.class)
@AttributeOverrides({
        @AttributeOverride(name = "warehouseCode", column=@Column(name="warehouse_code")),
        @AttributeOverride(name = "productCode", column=@Column(name="product_code"))
})
public class Stock {
    @Id
    private String warehouseCode;

    @Id
    private String productCode;

    private Long quantity;

    @MapsId("productCode")
    @ManyToOne
    @JoinColumn(name = "product_code", referencedColumnName = "code")
    @JsonIgnore
    private Product product;

    @MapsId("warehouseCode")
    @ManyToOne
    @JoinColumn(name = "warehouse_code", referencedColumnName = "code")
    @JsonIgnore
    private Warehouse warehouse;
}
