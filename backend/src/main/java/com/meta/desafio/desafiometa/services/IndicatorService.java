package com.meta.desafio.desafiometa.services;

import static com.meta.desafio.desafiometa.utils.Utils.retrieveWebPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.meta.desafio.desafiometa.models.Country;
import com.meta.desafio.desafiometa.models.CountryData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class IndicatorService {

  private String indicatorsURL = "http://api.worldbank.org/v2/country/{code}/indicator/SI.POV.DDAY?format=json";

  public List<CountryData> getCountryData(String code) throws IOException, InterruptedException {
    indicatorsURL = indicatorsURL.replace("{code}", code);
    return generateCountryIndicators();
  }

  public JSONObject getPageData(String code) throws JSONException, IOException, InterruptedException {
    indicatorsURL = indicatorsURL.replace("{code}", code);
    var pageData = parseJSON().getJSONObject(0);
    return pageData;
  }

  private JSONArray parseJSON() throws IOException, InterruptedException {
    var webContent = retrieveWebPage(indicatorsURL);
    return new JSONArray(webContent);
  }

  private List<CountryData> generateCountryIndicators() throws IOException, InterruptedException {
    var indicators = parseJSON().getJSONArray(1);
    List<CountryData> response = new ArrayList<CountryData>();
    CountryData countryData;
    JSONObject current;
    JSONObject indicator;
    JSONObject country;

    for (int i = 0; i < indicators.length(); i++) {
      current = indicators.getJSONObject(i);
      indicator = (JSONObject) current.get("indicator");
      country = (JSONObject) current.get("country");
      countryData = new CountryData(indicator.get("id").toString(), indicator.get("value").toString(),
          Integer.parseInt(current.get("date").toString()),
          new Country(country.get("value").toString(), country.get("id").toString()), current.get("unit").toString(),
          current.get("countryiso3code").toString(), current.get("decimal").toString(), current.get("value").toString(),
          current.get("obs_status").toString());
      response.add(countryData);
    }
    return response;
  }

}
