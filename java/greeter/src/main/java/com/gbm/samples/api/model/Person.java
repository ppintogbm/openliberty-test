package com.gbm.samples.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
  @NamedQuery(
    name = "listAll",
    query = "SELECT e FROM Person e"
  )
})
@XmlRootElement(name="person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String email;

  public Person() {}

  public Person(Long id, String username, String email) {
    this.id = id;
    this.username = username;
    this.email = email;
  }

  @XmlElement(name = "id", type = Long.class)
  public Long getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  
}
