/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.businesslogic;

import com.nackademin.dao.PhonebookDAO;
import com.nackademin.entities.Person;
import com.nackademin.entities.Phonenumbers;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author borgs_000
 */
@Stateless
public class PersonBusinessLogic {

    @Inject
    PhonebookDAO pb; 
    
    public void createPerson(String firstname, String lastname){
        Person person = new Person(firstname, lastname );
        pb.savePerson(person);
    }
    public void deletePerson(Person person){
        pb.deletePerson(person);
    }
       public List<Person> showAllPersons(){
        return pb.findAllPersons();
    }
    
   
    
}
