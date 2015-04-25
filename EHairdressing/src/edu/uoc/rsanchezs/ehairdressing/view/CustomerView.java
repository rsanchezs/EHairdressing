package edu.uoc.rsanchezs.ehairdressing.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.uoc.rsanchezs.ehairdressing.model.Customer;
import edu.uoc.rsanchezs.ehairdressing.service.CustomerService;


@Named
@RequestScoped
public class CustomerView extends AbstractBean implements Serializable {
	
	
	private static final long serialVersionUID = 1488471499773712565L;

	@Inject
	private CustomerService customerService;
	
	private Customer customer = new Customer();
	private List<Customer> customers = new ArrayList<Customer>();
	
	
	/**
	 * 
	 */
	public CustomerView() {
		super();
	}
	
	@PostConstruct
	public void init() {
		customers = customerService.findAllCustomers();
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}


	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	/**
	 * @return the customerList
	 */
	public List<Customer> getCustomers() {
		return customers;
	}




	/**
	 * @param customerList the customerList to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String doCreateCustomer() {
		
		customerService.createCustomer(customer);
		
		return "";
	}
	
	public String doDeleteCustomer() {
		customerService.remove(customer);
		return "customers?faces-redirect=true";
	}
	
	
	public String doUpdateCustomer() {
		
		customerService.merge(customer);
		
		return "";
	}
	
	


}
