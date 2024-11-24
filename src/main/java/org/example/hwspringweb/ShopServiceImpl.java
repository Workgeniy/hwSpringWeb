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

    @Override
    public List<Product> findProductByName(String name) {
        return productRepositiry.findByName(name);
    }

    @Override
    public List<Product> findProductByPrise(Double price) {
        return productRepositiry.findByPrice(price);
    }

    @Override
    public void saveDB(String name, Double prise) {
        Product product = new Product(name, prise);
        productRepositiry.save(product);
    }

    @Override
    public void saveDB(Product product) {
        productRepositiry.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepositiry.findAll();
    }
}
