package org.example.hwspringweb;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "productOrder")
public class Product0rder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer count;

    public Product0rder() {}

    public Product0rder(Product product, Order order, Integer count) {
        this.product = product;
        this.order = order;
        this.count = count;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
