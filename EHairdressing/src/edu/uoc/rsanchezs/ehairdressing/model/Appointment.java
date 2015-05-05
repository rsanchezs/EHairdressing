package edu.uoc.rsanchezs.ehairdressing.model;

import edu.uoc.rsanchezs.ehairdressing.model.Customer;
import edu.uoc.rsanchezs.ehairdressing.model.Event;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Appointment
 *
 */
@Entity
public class Appointment extends Event implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Customer customer;
	private List<Service> services;


	public Appointment() {
		super();
	}   
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@JoinTable(joinColumns = @JoinColumn(name = "Appointment_fk", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "services_fk", referencedColumnName = "id"))
	public List<Service> getServices() {
		return services;
	}
	
	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	
   
}
