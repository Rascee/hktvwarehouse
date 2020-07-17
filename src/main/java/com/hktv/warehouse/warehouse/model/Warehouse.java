package com.hktv.warehouse.warehouse.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "warehouse")
@Builder
public class Warehouse {
    @Id
    private String code;
    private String name;
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "warehouse")
    private List<Stock> stocks;
}
