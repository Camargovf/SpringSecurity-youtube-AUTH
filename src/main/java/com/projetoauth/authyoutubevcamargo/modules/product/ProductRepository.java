package com.projetoauth.authyoutubevcamargo.modules.product;

import com.projetoauth.authyoutubevcamargo.modules.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
