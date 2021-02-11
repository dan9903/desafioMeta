package com.meta.desafio.desafiometa.models;

public class Country {
  private String name;
  private String id;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Country(String name, String id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    return this.name == ((Country) o).getName() && this.id == ((Country) o).getId();
  }
}