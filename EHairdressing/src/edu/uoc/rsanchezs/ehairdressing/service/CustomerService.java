package edu.uoc.rsanchezs.ehairdressing.service;



import static edu.uoc.rsanchezs.ehairdressing.model.Customer.FIND_ALL;
import static edu.uoc.rsanchezs.ehairdressing.model.Groups.FIND_BY_ID;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import edu.uoc.rsanchezs.ehairdressing.model.Customer;
import edu.uoc.rsanchezs.ehairdressing.model.Groups;
import edu.uoc.rsanchezs.ehairdressing.util.Loggable;

/**
 * Session Bean implementation class CustomerService
 */

@Named
@Stateless
@LocalBean
@Loggable
public class CustomerService extends AbstractService<Customer> implements Serializable{
	
    
	private static final long serialVersionUID = -8729008869101824890L;
	
	@Resource
	TimerService timerService;
	
	@Inject
	EmailService emailService;
	
	@Inject
	Logger logger;
	
	/**
     * Default constructor. 
     */
    public CustomerService() {
    	super(Customer.class);
    }
    
	/**
     * Method that create a Customer in the system. In addition
     * it creates a calendar timer based on the date of bith of
     * the customer. Thus, every year the container will trigger
     * the bean to create and send a birthday e-mail to the customer.
     * @param Customer to persist
     * @return Customer persisted
     */
    public @NotNull Customer createCustomer(@NotNull Customer customer){
    	TypedQuery<Groups> typedQuery = em.createNamedQuery(Groups.FIND_BY_ID, Groups.class);
    	typedQuery.setParameter("id", 1);
    	Groups group = typedQuery.getSingleResult();
    	customer.add(group);
    	em.persist(customer);
    	ScheduleExpression birthday = new ScheduleExpression().
    			dayOfMonth(customer.getBirthDay()).
    			month(customer.getBirthMonth());
    	
    	timerService.createCalendarTimer(birthday, new TimerConfig(customer, true));
    	return customer;
    }
    
    
    /**
     * With the create timer in the method createCustomer(), the container will invoke 
     * this method every year to create and send a e-mail to the customer.
     * @param timer
     */
    @Timeout
    public void sendBirthdayEmail(Timer timer)  {
    	Customer customer = (Customer)timer.getInfo();
    	emailService.sendBithdayEmail(customer.getUsername());	
    }
    
    /**
     * Method to save a Customer into the database
     * @param customer
     * @return
     */
    public @NotNull Customer saveCustomer(@NotNull Customer customer) {
    	TypedQuery<Groups> typedQuery = em.createNamedQuery(Groups.FIND_BY_ID, Groups.class);
    	typedQuery.setParameter("id", 1);
    	Groups group = typedQuery.getSingleResult();
    	customer.add(group);
    	em.persist(customer);
    	return customer;
    }
    
    /**
     * 
     * @param customer
     * @return
     */
    public @NotNull Customer updateCustomer(@NotNull Customer customer)
    {
       em.merge(customer);
       return customer;
    }
    /**
     * 
     * @param customer
     */
    public void removeCustomer(@NotNull Customer customer)
    {
		em.remove(em.merge(customer));

    }
    
    /**
     * 
     * @return
     */
    public List<Customer> findAllCustomers(){
    	//TypedQuery<Customer> customers= em.createNamedQuery(FIND_ALL, Customer.class);
    	return findWithNamedQuery(FIND_ALL);
    }
    
}
