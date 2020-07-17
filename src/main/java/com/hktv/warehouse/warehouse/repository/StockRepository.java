package com.hktv.warehouse.warehouse.repository;

import com.hktv.warehouse.warehouse.model.Stock;
import com.hktv.warehouse.warehouse.model.StockPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, StockPK>, JpaSpecificationExecutor<Stock> {
    List<Stock> findAllByProductInAndWarehouseIn(List<String> productIds, List<String> warehouseIds);
}
