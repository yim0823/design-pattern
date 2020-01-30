package com.bespin.dcos.decorator.service;

import com.bespin.dcos.decorator.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Project : design-pattern Class : com.bespin.dcos.decorator.service.ProductServiceImpl Version :
 * 2020.01.30 v0.0.1 Created by taehyoung.yim on 2020-01-30. *** 저작권 주의 ***
 */
@Slf4j
@Service("basic")
public class ProductServiceImpl implements ProductService {

  @Override
  public Product createProduct(String name, String description) {

    Product newProduct = Product.builder().name(name).description(description).build();
    save(newProduct);

    return newProduct;
  }

  private void save(Product product) {
    log.info("## Complete to save the product, {}", product.getName());
  }
}
