package com.hktv.warehouse.warehouse.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
@Builder
public class Product {
    @Id
    private String code;
    private String name;
    private double weight;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<Stock> stocks;


}
