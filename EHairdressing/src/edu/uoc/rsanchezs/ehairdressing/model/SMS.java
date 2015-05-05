package edu.uoc.rsanchezs.ehairdressing.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.TemporalType.TIME;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: SMS
 *
 */
@Entity
public class SMS implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String subject;
	private String administrativeNote;
	private String body;
	private Date creationDate = new Date();
	private Date sendDate;
	
	private List<String> tags = new ArrayList<String>();
	private List<Customer> customers = new ArrayList<Customer>();
	

	public SMS() {
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
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}   
	public String getAdministrativeNote() {
		return this.administrativeNote;
	}

	public void setAdministrativeNote(String administrativeNote) {
		this.administrativeNote = administrativeNote;
	}
	@ElementCollection
	@CollectionTable(name = "Tags")
	@Column(name = "Value")
	public List<String> getTags() {
		return this.tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}   
	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}   
	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Temporal(TIME)
	public Date getCreationDate() {
		return creationDate;
	}
	@Temporal(TIME)
	public Date getSendDate() {
		return sendDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	
   
}
