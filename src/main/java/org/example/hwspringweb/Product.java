package org.example.hwspringweb;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ColumnDefault("0")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany
    private List<Product0rder> productOrder;

    public Product() {}

    public Product( String name, Double price, Category category, List<Product0rder> productOrder) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.productOrder = productOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product0rder> getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(List<Product0rder> productOrder) {
        this.productOrder = productOrder;
    }
}
