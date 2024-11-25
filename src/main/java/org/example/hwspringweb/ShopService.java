package org.example.hwspringweb;

import java.util.List;

public interface ShopService {

    List<Product> findProductByName(String name);
    List<Product> findProductByPrise(Double prise);

    void saveDB(String name, Double prise);
    void saveDB(Product product);

    List<Product> getAllProducts();

    void saveUserToDB(UserDto user);
    UserDto findByEmail(String email);
}
