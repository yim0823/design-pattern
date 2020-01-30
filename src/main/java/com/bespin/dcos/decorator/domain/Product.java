package com.bespin.dcos.decorator.domain;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Project : design-pattern Class : com.bespin.dcos.decorator.domain.Product Version : 2020.01.30
 * v0.0.1 Created by taehyoung.yim on 2020-01-30. *** 저작권 주의 ***
 */
@Getter
@Setter
public class Product {

  private String productId;
  private String name;
  private String description;

  @Builder
  public Product(String name, String description) {
    this.productId = UUID.randomUUID().toString();
    this.name = name;
    this.description = description;
  }
}
