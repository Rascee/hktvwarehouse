package com.hktv.warehouse.warehouse.service.impl;

import com.hktv.warehouse.warehouse.dto.request.CreateStockRequest;
import com.hktv.warehouse.warehouse.model.Product;
import com.hktv.warehouse.warehouse.model.Stock;
import com.hktv.warehouse.warehouse.model.Warehouse;
import com.hktv.warehouse.warehouse.repository.ProductRepository;
import com.hktv.warehouse.warehouse.repository.StockRepository;
import com.hktv.warehouse.warehouse.repository.WarehouseRepository;
import com.hktv.warehouse.warehouse.service.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    @Override
    public List<Stock> fetchStocks(@Nullable List<String> productCodes) {
        Specification<Stock> stockSpecification = (Specification<Stock>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!CollectionUtils.isEmpty(productCodes)) {
                predicates.add(root.get("stockPK").get("productCode").in(productCodes));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return stockRepository.findAll(stockSpecification);
    }

    @Override
    public void createProducts(List<Product> products) {
        productRepository.saveAll(products);
    }

    @Override
    public void createWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Override
    public void createStocks(List<CreateStockRequest> requests) {
        List<Stock> stocks = requests.stream().map(request ->
                Stock.builder()
                        .warehouse(Warehouse.builder().code(request.getWarehouseCode()).build())
                        .product(Product.builder().code(request.getProductCode()).build())
                .quantity(request.getQuantity())
                .build()
        ).collect(Collectors.toList());

        stockRepository.saveAll(stocks);
    }

    @Override
    public Warehouse getWarehouse(String warehouseCode) {
        return warehouseRepository.findById(warehouseCode).get();
    }
}
