package edu.uoc.rsanchezs.ehairdressing.util;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import edu.uoc.rsanchezs.ehairdressing.model.Gender;

/**
 * Session Bean implementation class EnumValuesProvider
 */
@Named
@RequestScoped
public class EnumValuesProvider implements Serializable{

    /**
     * Default constructor. 
     */
    public EnumValuesProvider() {
       
    }
    
    public Gender[] getGenders() {
    	
    	return Gender.values();
    }

}
