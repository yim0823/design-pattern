package com.bespin.dcos.decorator;

import com.bespin.dcos.decorator.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Project : design-pattern Class : com.bespin.dcos.decorator.DecoratorApplication Version :
 * 2020.01.30 v0.0.1 Created by taehyoung.yim on 2020-01-30. *** 저작권 주의 ***
 */
@SpringBootApplication
public class DecoratorApplication implements CommandLineRunner {

  private ProductService basicProduct;
  private ProductService elasticsearch;

  @Autowired
  public DecoratorApplication(
      @Qualifier("basic") ProductService basicProduct,
      @Qualifier("elasticsearch") ProductService elasticsearch) {
    this.basicProduct = basicProduct;
    this.elasticsearch = elasticsearch;
  }

  public static void main(String[] args) {
    SpringApplication.run(DecoratorApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    basicProduct.createProduct("storage", "This is typical storage for saving data.");
    elasticsearch.createProduct("elk", "This is distributed indexing storage.");
  }

}
