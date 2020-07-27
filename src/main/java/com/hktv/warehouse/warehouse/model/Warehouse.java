package com.hktv.warehouse.warehouse.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @OneToMany(mappedBy = "warehouse", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Stock> stocks;
}
