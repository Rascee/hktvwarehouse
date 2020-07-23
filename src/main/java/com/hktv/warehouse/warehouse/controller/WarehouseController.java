package com.hktv.warehouse.warehouse.controller;

import com.hktv.warehouse.warehouse.dto.request.CreateStockRequest;
import com.hktv.warehouse.warehouse.model.Product;
import com.hktv.warehouse.warehouse.model.Stock;
import com.hktv.warehouse.warehouse.model.Warehouse;
import com.hktv.warehouse.warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/warehouse")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;

    @GetMapping()
    public List<Warehouse> fetchWarehouse() {
        return warehouseService.fetchWarehouse();
    }

    /**
     * Retrieve stocks
     *
     * @param productCodes product code collections
     * @return stocks grouped by product code
     */
    @GetMapping("/stocks")
    public List<Stock> fetchStocks(@RequestParam(required = false) List<String> productCodes) {
        return warehouseService.fetchStocks(productCodes);
    }

    @PostMapping("/stocks")
    public void createStocks(@RequestBody List<CreateStockRequest> requests) {
        warehouseService.createStocks(requests);
    }

    @GetMapping("/{warehouseCode}")
    public Warehouse getWarehouse(@PathVariable String warehouseCode) {
        return warehouseService.getWarehouse(warehouseCode);
    }

    /**
     * Create warehouse
     * @param warehouse warehouse details
     */
    @PostMapping
    public void createWarehouse(@RequestBody Warehouse warehouse) {
        warehouseService.createWarehouse(warehouse);
    }

    /**
     * Create products by provides list of product
     * @param products product collection
     */
    @PostMapping("/products")
    public void createProducts(@RequestBody List<Product> products) {
        warehouseService.createProducts(products);
    }

    @GetMapping("product/{productId}")
    public Product getProduct(@PathVariable String productId) {
        return warehouseService.getProduct(productId);
    }
}
