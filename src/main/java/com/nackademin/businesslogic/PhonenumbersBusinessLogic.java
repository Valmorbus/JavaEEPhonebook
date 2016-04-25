/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nackademin.businesslogic;

import com.nackademin.dao.PhonebookDAO;
import com.nackademin.entities.Phonenumbers;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author borgs_000
 */
@Stateless
public class PhonenumbersBusinessLogic {

     @Inject
    PhonebookDAO pb; 
     
      public void createPhonenumber(String number, int id ){
        Phonenumbers pn = new Phonenumbers(number, id);
        pb.savePhonenumber(pn);
    }
    public void deletePhonenumber(Phonenumbers pn){
        pb.deletePhonenumbers(pn);
    }
       public List<Phonenumbers> showAllPhonenumbers(){
        return pb.findAllPhonenumbers();
    }
   
    
}
