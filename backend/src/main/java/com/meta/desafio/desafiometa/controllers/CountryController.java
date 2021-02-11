package com.meta.desafio.desafiometa.controllers;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import com.meta.desafio.desafiometa.models.Country;
import com.meta.desafio.desafiometa.models.CountryData;
import com.meta.desafio.desafiometa.services.IndicatorService;
import com.meta.desafio.desafiometa.services.XMLService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/country")
public class CountryController {
  private XMLService xmlService;
  private IndicatorService indicatorService;

  @Autowired
  public CountryController(XMLService xmlService, IndicatorService indicatorService) {
    this.xmlService = xmlService;
    this.indicatorService = indicatorService;
  }

  @GetMapping(path = "/codes")
  public ResponseEntity<List<Country>> getAllCodes()
      throws IOException, InterruptedException, ParserConfigurationException, SAXException {
    var response = xmlService.getListOfCountries();
    return new ResponseEntity<List<Country>>(response, HttpStatus.CREATED);
  }

  @GetMapping(path = "/indicators/{code}")
  public ResponseEntity<List<CountryData>> getCountryData(@PathVariable String code)
      throws IOException, InterruptedException {
    code = code.trim().toUpperCase();
    if (code.length() != 3) {
      return new ResponseEntity<List<CountryData>>(HttpStatus.BAD_REQUEST);
    }
    var response = indicatorService.getCountryData(code);
    return new ResponseEntity<List<CountryData>>(response, HttpStatus.OK);
  }
}