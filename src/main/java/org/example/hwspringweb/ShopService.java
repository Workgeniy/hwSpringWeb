package org.example.hwspringweb;

import java.util.List;

public interface ShopService {

    Category findCategoryByName(String categoryName);

    List<Product> findProductsByName(String categoryName);
    List<Product> findProductsByPrise(Double prise);

    Order findOrderByNumber(Long number);
}
