package com.meta.desafio.desafiometa.models;

import java.util.List;

public class Countries {

  private String per_page;
  private List<Country> country;
  private String total;
  private String pages;
  private String page;

  public String getPer_page() {
    return per_page;
  }

  public void setPer_page(String per_page) {
    this.per_page = per_page;
  }

  public List<Country> getCountry() {
    return country;
  }

  public void setCountry(List<Country> country) {
    this.country = country;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getPages() {
    return pages;
  }

  public void setPages(String pages) {
    this.pages = pages;
  }

  public String getPage() {
    return page;
  }

  public void setPage(String page) {
    this.page = page;
  }

  @Override
  public String toString() {
    return "ClassPojo [per_page = " + per_page + ", total = " + total + ", pages = " + pages + ", page = " + page + "]";
  }

  public Countries(String per_page, String total, String pages, String page) {
    this.per_page = per_page;
    this.total = total;
    this.pages = pages;
    this.page = page;
  }
}