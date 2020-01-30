package com.bespin.dcos.decorator.service.components;

import com.bespin.dcos.decorator.domain.Product;
import com.bespin.dcos.decorator.service.FullTextSearchIndexService;
import com.bespin.dcos.decorator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Project : design-pattern Class :
 * com.bespin.dcos.decorator.service.components.ProductServiceDecorator Version : 2020.01.30 v0.0.1
 * Created by taehyoung.yim on 2020-01-30. *** 저작권 주의 ***
 */
@Component("elasticsearch")
public class ProductServiceDecorator implements ProductService {

  private ProductService wrappedProductService;
  private FullTextSearchIndexService fullTextSearchIndexService;

  @Autowired
  public ProductServiceDecorator(
      @Qualifier("basic") ProductService wrappedProductService,
      FullTextSearchIndexService fullTextSearchIndexService) {
    this.wrappedProductService = wrappedProductService;
    this.fullTextSearchIndexService = fullTextSearchIndexService;
  }

  @Override
  public Product createProduct(String name, String description) {

    Product product = wrappedProductService.createProduct(name, description);
    fullTextSearchIndexService.index(product);

    return product;
  }
}
