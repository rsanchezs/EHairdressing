package edu.uoc.rsanchezs.ehairdressing.model;

import edu.uoc.rsanchezs.ehairdressing.model.Customer;
import edu.uoc.rsanchezs.ehairdressing.model.Event;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Appointment
 *
 */
@Entity
@NamedQueries({
	
	@NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a "),
		
	@NamedQuery(name = "Appointment.findAppointmentByTitle", query = "SELECT a FROM Appointment  a WHERE a.title = :title") 
})
public class Appointment extends Event implements Serializable {
	
	

	public static final String FIND_ALL = "Appointment.findAll";
	public static final String FIND_BY_TITLE = "Appointment.findAppointmentByTitle";

	private static final long serialVersionUID = 1L;
	
	private Customer customer;
	private List<Service> services;


	public Appointment() {
		super();
	} 

	public Appointment(String title, Date startDate, Date endDate) {
		super(title,startDate,endDate);
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
