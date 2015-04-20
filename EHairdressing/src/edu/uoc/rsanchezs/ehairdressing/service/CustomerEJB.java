package edu.uoc.rsanchezs.ehairdressing.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

import edu.uoc.rsanchezs.ehairdressing.model.Customer;
import static edu.uoc.rsanchezs.ehairdressing.model.User.FIND_ALL;

/**
 * Session Bean implementation class CustomerEJB
 */
@Stateless(mappedName = "customerService")
@LocalBean
public class CustomerEJB extends AbstractService<Customer> implements Serializable{
	
    /**
     * Default constructor. 
     */
    public CustomerEJB() {
    	super(Customer.class);
    }
    
    
    public Customer createCustomer(@NotNull Customer customer){
    	em.persist(customer);
    	return customer;
    }
    
    public Customer updateCustomer(@NotNull Customer customer)
    {
       em.merge(customer);
       return customer;
    }

    public void removeCustomer(@NotNull Customer customer)
    {
       em.remove(em.merge(customer));
    }
    
    public List<Customer> findAllCustomers(){
    	TypedQuery<Customer> customers= em.createNamedQuery(FIND_ALL, Customer.class);
    	return customers.getResultList();
    }

}
