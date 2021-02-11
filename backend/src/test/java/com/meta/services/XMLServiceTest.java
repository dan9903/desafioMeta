package com.meta.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import com.meta.desafio.desafiometa.services.XMLService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

@SpringBootTest(classes = XMLService.class)
public class XMLServiceTest {
  @Autowired
  private XMLService service;

  @Test
  void sizeOfCountriesList() throws ParserConfigurationException, SAXException, IOException, InterruptedException {
    assertEquals(50, service.getListOfCountries().size());
  }

  @Test
  void containsBRAonCountries() throws ParserConfigurationException, SAXException, IOException, InterruptedException {
    var countries = service.getListOfCountries();
    var brazil = countries.stream().filter(country -> "BRA".equals(country.getId())).findAny().orElse(null);
    assertTrue(brazil != null);
  }

  @Test
  void totalOfCountries() throws IOException, InterruptedException, ParserConfigurationException, SAXException {
    assertEquals(297, service.getCounty().getTotal());
  }

}