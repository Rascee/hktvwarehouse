package com.hktv.warehouse.warehouse.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @OneToMany(mappedBy = "product")
    private List<Stock> stocks;
}
