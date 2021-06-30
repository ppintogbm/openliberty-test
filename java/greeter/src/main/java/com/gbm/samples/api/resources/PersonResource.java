package com.gbm.samples.api.resources;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gbm.samples.api.dao.PersonDAO;
import com.gbm.samples.api.model.Person;
import com.gbm.samples.api.model.Persons;


@RequestScoped
@Path("persons")
public class PersonResource {

  @Inject
  private PersonDAO personDao;
  
  @GET
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public Persons getAllPersons(){
    return personDao.readAll();
  }

  @GET
  @Path("/{id}")
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  public Person getPerson(@PathParam(value = "id") Long id){
    return personDao.readPerson(id);
  }

  @POST
  @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  @Transactional
  public Person addPerson(Person person){
    return personDao.creatPerson(person);
  }

}
