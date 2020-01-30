package com.bespin.dcos.decorator.service;

import com.bespin.dcos.decorator.domain.Product;

/**
 * Project : design-pattern Class : com.bespin.dcos.decorator.service.ProductService Version :
 * 2020.01.30 v0.0.1 Created by taehyoung.yim on 2020-01-30. *** 저작권 주의 ***
 */
public interface ProductService {

  Product createProduct(String name, String description);
}
