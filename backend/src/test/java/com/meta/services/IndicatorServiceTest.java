package com.meta.services;

import com.meta.desafio.desafiometa.services.IndicatorService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IndicatorServiceTest {

  @Autowired
  IndicatorService service;

  @Test
  void shouldBeReturnData() {
    assertTrue(!service.getIndicators("BRA").isEmpty());
  }

  void shouldBeOrderedByYear() {
    var indicator = service.getIndicators("BRA");
    if 
    assertTrue()
  }
}
