package com.aracely.jacinto.expenses.models;

import jakarta.persistence.*;

@Entity
@Table(name = "persons")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "address_id", referencedColumnName = "id")
  Address address;

  public Person() {}
  public Person(String firstName, String lastName, String email, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  public long getId() {return id;}
  public String getFirstName() {return firstName;}
  public void setFirstName(String firstName) {this.firstName = firstName;}
  public String getLastName() {return lastName;}
  public void setLastName(String lastName) {this.lastName = lastName;}
  public String getEmail() {return email;}
  public void setEmail(String email) {this.email = email;}
  public String getPhone() {return phone;}
  public void setPhone(String phone) {this.phone = phone;}
  public Address getAddress() {return address;}
  public void setAddress(Address address) {this.address = address;}
}
