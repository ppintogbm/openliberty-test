package com.gbm.samples.api.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.gbm.samples.api.model.Person;
import com.gbm.samples.api.model.Persons;

@RequestScoped
public class PersonDAO {
  
  @PersistenceContext(name = "jpa-unit")
  private EntityManager em;

  public Person creatPerson(Person person){
    em.persist(person);
    return person;
  }

  public Person readPerson(Long personId){
    return em.find(Person.class,personId);
  }


  public Persons readAll(){
    Query query = em.createNamedQuery("listAll");
    query.setMaxResults(10);
    Persons persons = new Persons((List<Person>)query.getResultList());
    return persons;
  }

}
