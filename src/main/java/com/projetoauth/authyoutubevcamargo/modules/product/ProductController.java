package com.projetoauth.authyoutubevcamargo.modules.product;

import com.projetoauth.authyoutubevcamargo.modules.product.entities.Product;
import com.projetoauth.authyoutubevcamargo.modules.product.services.v1.ListProductServiceV1;
import com.projetoauth.authyoutubevcamargo.modules.product.services.v2.ListProductServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Qualifier("GetProductService-v2")
    @Autowired
    ListProductServiceV2 listProductService;

    @GetMapping
    public List<Product> list() {
        return listProductService.listAll();
    }

}