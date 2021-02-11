package com.meta.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import com.meta.desafio.desafiometa.services.IndicatorService;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = IndicatorService.class)
public class IndicatorServiceTest {

  @Autowired
  IndicatorService service;

  @Test
  void givenCountryCodeShouldnotBeEmptyBRA() throws IOException, InterruptedException {
    var code = "BRA";
    assertTrue(!service.getCountryData(code).isEmpty());
  }

  @Test
  void givenCountryCodeShouldnotBeEmptyARG() throws IOException, InterruptedException {
    var code = "ARG";
    assertTrue(!service.getCountryData(code).isEmpty());
  }

  @Test
  void shouldBeOrderedByYear() throws IOException, InterruptedException {
    var code = "BRA";
    var indicators = service.getCountryData(code);
    var ordered = true;
    var year = Integer.MAX_VALUE;

    for (var i = 0; i < indicators.size(); i++) {
      if (indicators.get(i).getYear() > year) {
        ordered = false;
        break;
      }
      year = indicators.get(i).getYear();
    }
    assertTrue(ordered);
  }

  @Test
  void givenCountryCodeShouldBePageData() throws JSONException, IOException, InterruptedException {
    var code = "BRA";
    var pageData = service.getPageData(code);
    assertEquals(61, Integer.parseInt(pageData.get("total").toString()));
  }

}
