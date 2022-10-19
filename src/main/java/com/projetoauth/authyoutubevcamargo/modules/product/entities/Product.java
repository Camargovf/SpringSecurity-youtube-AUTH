package com.projetoauth.authyoutubevcamargo.modules.product.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    private String description;

    private String sku;

}