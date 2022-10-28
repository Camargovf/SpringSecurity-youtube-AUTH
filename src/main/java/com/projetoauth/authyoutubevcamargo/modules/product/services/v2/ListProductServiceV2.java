package com.projetoauth.authyoutubevcamargo.modules.product.services.v2;

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
@Component("GetProductService-v2")
public class ListProductServiceV2 implements ListProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> listAll() {
            log.info("list all products");
            return productRepository.findAll();
    }
}
