package com.hktv.warehouse.warehouse.repository;

import com.hktv.warehouse.warehouse.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, String> {
}
