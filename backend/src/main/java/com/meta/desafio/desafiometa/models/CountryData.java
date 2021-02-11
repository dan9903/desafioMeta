package com.meta.desafio.desafiometa.models;

public class CountryData {
  private String indicatorId;
  private String indicatorDescritption;
  private int year;
  private Country country;
  private String unit;
  private String countryiso3code;
  private String decimal;
  private String value;
  private String obs_status;

  public String getIndicatorId() {
    return indicatorId;
  }

  public void setIndicatorId(String indicatorId) {
    this.indicatorId = indicatorId;
  }

  public String getIndicatorDescription() {
    return indicatorDescritption;
  }

  public void setIndicatorDescription(String indicatorDescritption) {
    this.indicatorDescritption = indicatorDescritption;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getCountryiso3code() {
    return countryiso3code;
  }

  public void setCountryiso3code(String countryiso3code) {
    this.countryiso3code = countryiso3code;
  }

  public String getDecimal() {
    return decimal;
  }

  public void setDecimal(String decimal) {
    this.decimal = decimal;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getObs_status() {
    return obs_status;
  }

  public void setObs_status(String obs_status) {
    this.obs_status = obs_status;
  }

  public CountryData(String indicatorId, String indicatorDescritption, int year, Country country, String unit,
      String countryiso3code, String decimal, String value, String obs_status) {
    this.indicatorId = indicatorId;
    this.indicatorDescritption = indicatorDescritption;
    this.year = year;
    this.country = country;
    this.unit = unit;
    this.countryiso3code = countryiso3code;
    this.decimal = decimal;
    this.value = value;
    this.obs_status = obs_status;
  }
}