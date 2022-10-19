package com.projetoauth.authyoutubevcamargo.modules.product;

import com.projetoauth.authyoutubevcamargo.modules.product.entities.Product;
import com.projetoauth.authyoutubevcamargo.modules.product.services.ListProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ListProductService listProductService;

    @GetMapping
    public List<Product> list() {
        return listProductService.listAll();
    }

}