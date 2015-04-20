package edu.uoc.rsanchezs.ehairdressing.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.uoc.rsanchezs.ehairdressing.model.Customer;
import edu.uoc.rsanchezs.ehairdressing.service.CustomerEJB;

@Named
@SessionScoped
public class CustomerView {
	
	@Inject
	private CustomerEJB customerEJB;
	
	private Customer selectedCustomer;
	private List<Customer> customers;
	
	@PostConstruct
	public void init() {
		customers=customerEJB.findAllCustomers();
	}
	/**
	 * @return the customerEJB
	 */
	public CustomerEJB getCustomerEJB() {
		return customerEJB;
	}
	/**
	 * @param customerEJB the customerEJB to set
	 */
	public void setCustomerEJB(CustomerEJB customerEJB) {
		this.customerEJB = customerEJB;
	}
	/**
	 * @return the selectedCustomer
	 */
	public Customer getSelectedCustomer() {
		return selectedCustomer;
	}
	/**
	 * @param selectedCustomer the selectedCustomer to set
	 */
	public void setSelectedCustomer(Customer selectedCustomer) {
		this.selectedCustomer = selectedCustomer;
	}
	/**
	 * @return the selectedCustomers
	 */
	public List<Customer> getSelectedCustomers() {
		return customers;
	}
	/**
	 * @param selectedCustomers the selectedCustomers to set
	 */
	public void setSelectedCustomers(List<Customer> selectedCustomers) {
		this.customers = selectedCustomers;
	}
	
	
	
	

}
