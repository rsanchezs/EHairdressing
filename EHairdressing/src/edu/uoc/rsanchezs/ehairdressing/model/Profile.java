package edu.uoc.rsanchezs.ehairdressing.model;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Long;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Profile
 *
 */
@Entity
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Boolean offers;
	private Boolean email;
	private Boolean sms;
	private Boolean newsletter;
	

	public Profile() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Boolean getOffers() {
		return this.offers;
	}

	public void setOffers(Boolean offers) {
		this.offers = offers;
	}   
	public Boolean getEmail() {
		return this.email;
	}

	public void setEmail(Boolean email) {
		this.email = email;
	}   
	public Boolean getSms() {
		return this.sms;
	}

	public void setSms(Boolean sms) {
		this.sms = sms;
	}   
	public Boolean getNewsletter() {
		return this.newsletter;
	}

	public void setNewsletter(Boolean newsletter) {
		this.newsletter = newsletter;
	}
   
}
