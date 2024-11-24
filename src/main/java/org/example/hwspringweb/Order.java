package org.example.hwspringweb;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Long number;

    @OneToMany
    private List<Product0rder> products;

    public Order() {}

    public Order(Long number, List<Product0rder> products) {
        this.number = number;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<Product0rder> getProducts() {
        return products;
    }

    public void setProducts(List<Product0rder> products) {
        this.products = products;
    }
}
