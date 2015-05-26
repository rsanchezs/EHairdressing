package edu.uoc.rsanchezs.ehairdressing.service;


import static edu.uoc.rsanchezs.ehairdressing.model.Email.FIND_ALL;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.validation.constraints.NotNull;

import edu.uoc.rsanchezs.ehairdressing.model.Email;
import edu.uoc.rsanchezs.ehairdressing.util.Loggable;

/**
 * Session Bean implementation class EmailService
 */

@Named
@Stateless
@LocalBean
@Loggable
public class EmailService extends AbstractService<Email> implements Serializable{
	
    
	private static final long serialVersionUID = 4385913416969452748L;
	
	@Resource(name="mail/EHairdressingMail")
	private Session session;
	
	@Inject
	private Logger logger;

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
    
    /**
     * Sends an Internet email 
     * @param email The email to send
     * @param addresses Array addresses to send the message to
     */
    public void sendEmail(Email email, Address[] addresses) {
    	Date sendDate = new Date();
    	email.setSendDate(sendDate);
    	Message msg = new MimeMessage(session);
   
    	try {
    		msg.setSubject(email.getSubject());
    		msg.setRecipients(RecipientType.TO, addresses);
    		msg.setText(email.getBody());
    		msg.setContent(email.getBody(),"text/html; charset=utf-8" );
    		Transport.send(msg);
    		
    	} catch (MessagingException e) {
    		logger.log(Level.SEVERE,"Error envio email" , e);
    	} 
    	
    	updateEmail(email);
    }
    
    /**
     * Sends an birthday email
     * @param email The email to send
     * @param addresses Array addresses to send the message to
     */
    public void sendBithdayEmail(String email) {
    	
    	Message msg = new MimeMessage(session);
    	String subject = "!Feliz Cumpleaños¡";
    	String body = "Los años pasan y cada vez estas mejor, feliz cumpleaños y que sigas mejorando";
    	try {
    		Address address = new InternetAddress(email);
    		msg.setSubject(subject);
    		msg.setRecipient(RecipientType.TO, address);
    		msg.setText(body);
    		msg.setContent(body,"text/html; charset=utf-8" );
    		Transport.send(msg);
    		
    	} catch (MessagingException e) {
    		logger.log(Level.SEVERE,"Error envio email" , e);
    	} 
    }
    
}
