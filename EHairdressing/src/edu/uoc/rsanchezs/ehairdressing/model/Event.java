package edu.uoc.rsanchezs.ehairdressing.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

import edu.uoc.rsanchezs.ehairdressing.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Event
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
	@NamedQuery(name = "Event.findEventByTitle", query = "SELECT e FROM Event e WHERE e.title = :title") 
})

public class Event implements Serializable {

	public static final String FIND_ALL = "Event.findAll";
	public static final String FIND_BY_TITLE = "Event.findEventByTitle";
	
	
	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private Date startDate;
	private Date endDate;
	

	public Event() {
		super();
		
			
	}   
	
	/**
	 * @param id
	 * @param title
	 * @param startDate
	 * @param endDate
	 */
	public Event(String id, String title, Date startDate, Date endDate) {

		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	
	@Id    
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [id=").append(id).append(", title=")
				.append(title).append(", startDate=").append(startDate)
				.append(", endDate=").append(endDate).append("]");	
		return builder.toString();
	}
	
	
	
}
