package edu.uoc.rsanchezs.ehairdressing.model;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.NamedQueries;
import javax.persistence.Column;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Inheritance
@Entity
@NamedQueries({
		
	@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e WHERE e.dtype='Event'"),
		
	@NamedQuery(name = "Event.findEventByTitle", query = "SELECT e FROM Event e WHERE e.title = :title") 
})
public class Event implements Serializable {

	public static final String FIND_ALL = "Event.findAll";
	public static final String FIND_BY_TITLE = "Event.findEventByTitle";
	
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String dtype;
	private Date startDate;
	private Date endDate;
	

	public Event() {
		super();
		
			
	}   
	/**
	 * @param title
	 * @param startDate
	 * @param endDate
	 */
	public Event(String title, Date startDate, Date endDate) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	@Id    
	@GeneratedValue(strategy = SEQUENCE)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	@Temporal(TIMESTAMP)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}   
	@Temporal(TIMESTAMP)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the dtype
	 */
	@Column(insertable = true, updatable = true)
	public String getDtype() {
		return dtype;
	}
	/**
	 * @param dtype the dtype to set
	 */
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
   
	
}
