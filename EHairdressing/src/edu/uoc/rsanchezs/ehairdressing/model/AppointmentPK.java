package edu.uoc.rsanchezs.ehairdressing.model;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;

/**
 * Entity implementation class for Entity: AppointmentPK
 *
 */


public class AppointmentPK implements Serializable {

	private Date startDate;
	private Long owner;


	private static final long serialVersionUID = 1L;

	public AppointmentPK() {
		super();
	} 

	/**
	 * @param startDate
	 * @param owner
	 */
	public AppointmentPK(Date startDate, Long customerId) {
		super();
		this.startDate = startDate;
		this.owner = customerId;
	}

	@Temporal(TIMESTAMP)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the owner
	 */
	public Long getCustomer() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setCustomer(Long customerId) {
		this.owner = customerId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((owner == null) ? 0 : owner.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AppointmentPK other = (AppointmentPK) obj;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
	

}
