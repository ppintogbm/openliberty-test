package com.gbm.samples.api.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "persons")
public class Persons {
  
  private List<Person> persons;

  public Persons() { }


  public Persons(List<Person> persons) {
    this.persons = persons;
  }

  @XmlElement(name="person")
  public List<Person> getPersons() {
    return this.persons;
  }

  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }

  

}
