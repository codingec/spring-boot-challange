package com.andres_silva.demo.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import java.util.Date;


@Entity
@Table(name = "items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_item")
    private Long id_item;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @Column(name="item_description", length =30)
    private String item_description;
    @Column(name="price")
    private BigDecimal price;

    @Column(name="expiration_date")
    @DateTimeFormat(iso=ISO.DATE)
    private Date expiration_date;

    public Item(){

    }

    public Item(String item_description, BigDecimal price,Date expiration_date){
        this.item_description = item_description;
        this.price = price;
        this.expiration_date = expiration_date;
    }

    public Long getId_item() {
        return id_item;
    }

    public void setId_item(Long id_item) {
        this.id_item = id_item;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getExpiration_date() {return expiration_date; }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }


}
