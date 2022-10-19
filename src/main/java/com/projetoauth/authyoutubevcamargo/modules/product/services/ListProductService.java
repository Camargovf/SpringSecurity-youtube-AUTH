package com.projetoauth.authyoutubevcamargo.modules.product.services;

import com.projetoauth.authyoutubevcamargo.modules.product.ProductRepository;
import com.projetoauth.authyoutubevcamargo.modules.product.entities.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ListProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listAll() {
        log.info("Listando todos os produtos");
        return productRepository.findAll();

    }
}
