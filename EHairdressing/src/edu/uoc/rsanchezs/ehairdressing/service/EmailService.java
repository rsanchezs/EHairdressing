package edu.uoc.rsanchezs.ehairdressing.service;


import static edu.uoc.rsanchezs.ehairdressing.model.Email.FIND_ALL;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import edu.uoc.rsanchezs.ehairdressing.model.Email;

/**
 * Session Bean implementation class EmailService
 */

@Named
@Stateless
@LocalBean
public class EmailService extends AbstractService<Email> implements Serializable{
	
    
	private static final long serialVersionUID = 4385913416969452748L;

	/**
     * Default constructor. 
     */
    public EmailService() {
    	super(Email.class);
    }
    
	/**
     * Method that create an Email in the system. 
     * @param Email to persist
     * @return Email persisted
     */
    public @NotNull Email createEmail(@NotNull Email email){
    	em.persist(email);
    	return email;
    }
    
    
    /**
     * Method that update an Email in the system.
     * @param Email to update
     * @return Email updated
     */
    public @NotNull Email updateEmail(@NotNull Email email)
    {
       em.merge(email);
       return email;
    }
    /**
     * Method that remove an Email in the system.
     * @param Email The Email removed
     */
    public void removeEmail(@NotNull Email email)
    {
       em.remove(em.merge(email));
    }
    
    /**
     * Method that returns all the mails saved in the system.
     * @return list of emails
     */
    public List<Email> findAllEmails(){
    	
    	return findWithNamedQuery(FIND_ALL);
    }
    
}
