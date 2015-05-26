package edu.uoc.rsanchezs.ehairdressing.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.NormalScope;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import edu.uoc.rsanchezs.ehairdressing.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Appointment
 *
 */
@Entity
@IdClass(AppointmentPK.class)
@NamedQueries({
	@NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a"),
})
public class Appointment implements Serializable {
	
	public static final String FIND_ALL = "Appointment.findAll";

	private static final long serialVersionUID = 1L;
	
	private String title;
	private Date startDate;
	private Date endDate;
	private Customer owner;
	
	private transient List<Service> services;
	
	public Appointment() {
		super();
	} 

	/**
	 * @param title
	 * @param startDate
	 * @param endDate
	 * @param owner
	 */
	public Appointment(String title, Date startDate, Date endDate,
			Customer customer) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.owner = customer;
	}

	/**
	 * @param title
	 * @param startDate
	 * @param endDate
	 */
	public Appointment(String title, Date startDate, Date endDate) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return the startDate
	 */
	@Id
	@Temporal(TIMESTAMP)
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the title
	 */
	
	public String getTitle() {
		return title;
	}

	/**
	 * @return the endDate
	 */
	@Temporal(TIMESTAMP)
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the owner
	 */
	@ManyToOne
	@Id
	@JoinColumn(name = "OWNER_ID", referencedColumnName = "USER_ID")
	public Customer getCustomer() {
		return owner;
	}

	/**
	 * @return the services
	 */
	public List<Service> getServices() {
		return services;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setCustomer(Customer customer) {
		this.owner = customer;
	}

	/**
	 * @param services the services to set
	 */
	public void setServices(List<Service> services) {
		this.services = services;
	}
	
}
