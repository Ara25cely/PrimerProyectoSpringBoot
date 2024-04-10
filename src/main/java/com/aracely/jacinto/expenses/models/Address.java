package com.aracely.jacinto.expenses.models;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String street;
  private int extNumber;
  private String postalCode;
  private String state;
  private String country;

  public Address() {}

  public Address(String street, int extNumber, String postalCode, String state, String country) {
    this.street = street;
    this.extNumber = extNumber;
    this.postalCode = postalCode;
    this.state = state;
    this.country = country;
  }

  public long getId() {return id;}
  public String getStreet() {return street;}
  public void setStreet(String street) {this.street = street;}
  public int getExtNumber() {return extNumber;}
  public void setExtNumber(int extNumber) {this.extNumber = extNumber;}
  public String getPostalCode() {return postalCode;}
  public void setPostalCode(String postalCode) {this.postalCode = postalCode;}
  public String getState() {return state;}
  public void setState(String state) {this.state = state;}
  public String getCountry() {return country;}
  public void setCountry(String country) {this.country = country;}}
