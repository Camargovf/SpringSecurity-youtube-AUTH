package com.projetoauth.authyoutubevcamargo.modules.product.services.v1;

import com.projetoauth.authyoutubevcamargo.modules.product.ProductRepository;
import com.projetoauth.authyoutubevcamargo.modules.product.entities.Product;
import com.projetoauth.authyoutubevcamargo.modules.product.services.ListProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Component("GetProductService-v1")
public class ListProductServiceV1 implements ListProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listAll() {
        log.info("Listando todos os produtos");
        return productRepository.findAll();

    }
}
