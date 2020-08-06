package com.hktv.warehouse.warehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "warehouse")
@Builder
public class Warehouse {
    @Id
    private String code;
    private String name;
    private String address;

    @OneToMany(mappedBy = "warehouse")
    @JsonIgnore
    private List<Stock> stocks;
}
