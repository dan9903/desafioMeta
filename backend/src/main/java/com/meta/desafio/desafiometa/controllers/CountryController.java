package com.meta.desafio.desafiometa.controllers;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import com.meta.desafio.desafiometa.models.Country;
import com.meta.desafio.desafiometa.models.CountryData;
import com.meta.desafio.desafiometa.services.XMLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

  @Autowired
  private XMLService xmlService;

  @GetMapping(path = "/codes")
  public ResponseEntity<List<Country>> getAllCodes()
      throws IOException, InterruptedException, ParserConfigurationException, SAXException {
    var response = xmlService.getListOfCountries();
    return new ResponseEntity<List<Country>>(response, HttpStatus.CREATED);
  }

  @GetMapping(path = "/indicators/{id}")
  public ResponseEntity<CountryData> getCountryData(@PathVariable String id) {

    return null;
  }
}