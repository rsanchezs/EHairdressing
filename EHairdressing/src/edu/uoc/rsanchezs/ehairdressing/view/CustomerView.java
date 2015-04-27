package edu.uoc.rsanchezs.ehairdressing.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.uoc.rsanchezs.ehairdressing.model.Address;
import edu.uoc.rsanchezs.ehairdressing.model.Customer;
import edu.uoc.rsanchezs.ehairdressing.service.CustomerService;
import edu.uoc.rsanchezs.ehairdressing.util.Loggable;


@Named
@RequestScoped
@Loggable
public class CustomerView extends AbstractBean implements Serializable {
	
	
	private static final long serialVersionUID = 1488471499773712565L;

	@Inject
	private CustomerService customerService;
	
	
	private Customer customer = new Customer();
	private Customer selectedCustomer = new Customer();
	private Address address = new Address();
	private List<Customer> customers = new ArrayList<Customer>();
	
	
	
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

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	public String doCreateCustomer() {
		customerService.createCustomer(customer);
		return "/admin/customers/view?faces-redirect=true";
	}
	
	public String doDeleteCustomer() {
		customerService.remove(selectedCustomer);
		return "/admin/customers/view?faces-redirect=true";
	}
	
	
	public String doUpdateCustomer() {
		customerService.merge(selectedCustomer);
		return "/admin/customers/view?faces-redirect=true";
	}
	
	


}
