/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.dao;

import com.nackademin.entities.Person;
import com.nackademin.entities.Phonenumbers;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author borgs_000
 */
@Stateless
public class PhonebookDAO {

   @PersistenceContext
    EntityManager em;
   
   
   public void savePerson(Person person){
       em.persist(person);
   }
   public void deletePerson(Person person){
       em.remove(person);
   }
   
   public void savePhonenumber(Phonenumbers pn){
       em.persist(pn);
   }
   public void deletePhonenumbers(Phonenumbers pn){
       em.remove(pn);
   }
    
   public Person findPersonById(int id){
       return em.find(Person.class, id);
   }
   
   public List<Person> findAllPersons(){
       TypedQuery<Person> q = em.createNamedQuery("Person.findAll", Person.class);
       return q.getResultList();
   }
   public List<Phonenumbers> findAllPhonenumbers(){
       TypedQuery<Phonenumbers> q = em.createNamedQuery("Phonenumbers.findAll", Phonenumbers.class);
       return q.getResultList();
   }
   
   
  
    
    
    
}
