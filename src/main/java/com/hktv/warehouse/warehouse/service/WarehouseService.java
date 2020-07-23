package com.hktv.warehouse.warehouse.service;

import com.hktv.warehouse.warehouse.dto.request.CreateStockRequest;
import com.hktv.warehouse.warehouse.model.Product;
import com.hktv.warehouse.warehouse.model.Stock;
import com.hktv.warehouse.warehouse.model.Warehouse;
import org.springframework.lang.Nullable;

import java.util.List;

public interface WarehouseService {
    List<Stock> fetchStocks(@Nullable List<String> productCodes);

    void createProducts(List<Product> products);

    void createWarehouse(Warehouse warehouse);

    void createStocks(List<CreateStockRequest> requests);

    Warehouse getWarehouse(String warehouseCode);

    Product getProduct(String productId);

    List<Warehouse> fetchWarehouse();
}
