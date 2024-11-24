package org.example.hwspringweb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Repository
@Transactional
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ProductRepositiry productRepositiry;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Override
    public Category findCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public List<Product> findProductsByName(String categoryName) {
        return productRepositiry.findByName(categoryName);
    }

    @Override
    public List<Product> findProductsByPrice(Double price) {
        return productRepositiry.findByPrice(price);
    }

    @Override
    public Order findOrderByNumber(Long number) {
        return orderRepository.findByNumber(number);
    }
}
