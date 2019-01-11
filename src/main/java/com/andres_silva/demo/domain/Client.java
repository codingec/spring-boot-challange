package com.andres_silva.demo.domain;


import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;


@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    private Long id_client;

    @Column(name = "client_name", length =255)
    @NotEmpty(message = "*Please provide your name! This field can not be empty!")
    private String client_name;
    @Column(name = "region", length =255)
    @NotEmpty(message = "*Please provide your region! This field can not be empty!")
    private String region;


    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
