package com.bespin.dcos.decorator.service;

import com.bespin.dcos.decorator.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Project : design-pattern Class : com.bespin.dcos.decorator.service.FullTextSearchIndexService
 * Version : 2020.01.30 v0.0.1 Created by taehyoung.yim on 2020-01-30. *** 저작권 주의 ***
 */
@Slf4j
@Service
public class FullTextSearchIndexService {

  public void index(Product product) {
    log.info("## Complete to create a index for the product, {}", product.getName());
  }
}
