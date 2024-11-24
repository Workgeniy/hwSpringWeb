package org.example.hwspringweb;

import java.util.List;

public interface ShopService {

    Category findCategoryByName(String categoryName);

    List<Product> findProductsByName(String categoryName);
    List<Product> findProductsByPrice(Double price);

    Order findOrderByNumber(Long number);
}
