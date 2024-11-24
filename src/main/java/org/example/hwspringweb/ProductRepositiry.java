package org.example.hwspringweb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositiry extends CrudRepository<Product, Long> {

    public List<Product> findByName(String name);

    public List<Product> findByPrice (Double prise);
}
