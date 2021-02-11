package com.meta.desafio.desafiometa.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.meta.desafio.desafiometa.models.Countries;
import com.meta.desafio.desafiometa.models.Country;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class XMLService {
  private String codesURL = "http://api.worldbank.org/v2/country";

  public List<Country> getListOfCountries()
      throws ParserConfigurationException, SAXException, IOException, InterruptedException {

    var doc = generateDocument();
    NodeList nodeList = doc.getElementsByTagName("wb:country");
    List<Country> countryList = new ArrayList<>();
    for (int i = 0; i < nodeList.getLength(); i++) {

      var attribute = nodeList.item(i).getAttributes();
      var child = nodeList.item(i).getChildNodes();
      Country country = new Country(child.item(3).getTextContent(), attribute.getNamedItem("id").getTextContent());
      countryList.add(country);
    }

    return countryList;
  }

  public Countries getCounty() throws IOException, InterruptedException, ParserConfigurationException, SAXException {
    var doc = generateDocument();
    var namedNodeMaps = doc.getElementsByTagName("wb:countries").item(0).getAttributes();
    var countries = new Countries(namedNodeMaps.getNamedItem("per_page").getTextContent(),
        namedNodeMaps.getNamedItem("total").getTextContent(), namedNodeMaps.getNamedItem("pages").getTextContent(),
        namedNodeMaps.getNamedItem("page").getTextContent());
    return countries;
  }

  private Document generateDocument()
      throws IOException, InterruptedException, ParserConfigurationException, SAXException {
    var xml = connectWBXML();
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
    doc.getDocumentElement().normalize();
    return doc;
  }

  private String connectWBXML() throws IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
        .proxy(ProxySelector.getDefault()).build();

    HttpRequest mainRequest = HttpRequest.newBuilder().uri(URI.create(codesURL)).build();

    return httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString()).body();
  }
}
