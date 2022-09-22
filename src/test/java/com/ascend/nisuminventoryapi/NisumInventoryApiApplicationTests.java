package com.ascend.nisuminventoryapi;
import com.ascend.components.repositories.ProductsRepository;
import com.ascend.components.services.ProductsService;
import com.ascend.components.services.ProductsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class NisumInventoryApiApplicationTests {

  @Test
  void contextLoads() {
  }
  @Autowired
  private ProductsServiceImpl service;

  @MockBean
  private ProductsRepository repository;

//@Test
//  public void getProductsTest(){
//    when(repository.findAll()).thenReturn(Stream.of(new Product("100000000001", "Shark Bites", "Assorted Gummy Sharks", "Betty Crockers", "Snacks", 3.99, "https://m.media-amazon.com/images/I/51Xlrk8SOaL.jpg", 49, 5, 10),new Product("Egg",142)).collect(Collectors.toList()));
//    assertEquals(2,service.getAll().size());
//  }
}
