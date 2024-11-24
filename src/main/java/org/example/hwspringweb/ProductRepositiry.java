package org.example.hwspringweb;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepositiry extends CrudRepository<Product, Long> {

    public List<Product> findByName(String name);

    public List<Product> findByPrice (Double price);
}
