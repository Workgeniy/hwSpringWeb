package org.example.hwspringweb;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name="Buy")
public class Wallet {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable=false)
    String purpose;

    @ColumnDefault("0")
    Double quantity;



    public Wallet(String p, Double q) {
        this.purpose = p;
        this.quantity = q;
    }

    public Wallet() {

    }

    public String getPurpose() {
        return purpose;
    }

    public Double getQuantity() {
        return quantity;
    }

    public boolean isIncome() {
        return quantity > 0;
    }
}