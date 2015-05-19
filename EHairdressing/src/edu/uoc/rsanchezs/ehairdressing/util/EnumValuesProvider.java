package edu.uoc.rsanchezs.ehairdressing.util;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import edu.uoc.rsanchezs.ehairdressing.model.Gender;

/**
 * Session Bean implementation class EnumValuesProvider
 */
@Named
@RequestScoped
public class EnumValuesProvider implements Serializable{

   
	private static final long serialVersionUID = -3151962490920803221L;

	/**
     * Default constructor. 
     */
    public EnumValuesProvider() {
       
    }
    
    public Gender[] getGenders() {
    	
    	return Gender.values();
    }

}
