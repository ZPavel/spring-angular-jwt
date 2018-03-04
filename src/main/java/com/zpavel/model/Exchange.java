package com.zpavel.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Currency sell;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Currency buy;
    private BigDecimal amount;
    private LocalDate created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getSell() {
        return sell;
    }

    public void setSell(Currency sell) {
        this.sell = sell;
    }

    public Currency getBuy() {
        return buy;
    }

    public void setBuy(Currency buy) {
        this.buy = buy;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
