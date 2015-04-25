package edu.uoc.rsanchezs.ehairdressing.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Group
 *
 */
@Entity
public class Groups implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String name;
	private String description;
	private List<Customer> customers = new ArrayList<Customer>();
	

	public Groups() {
		super();
	}


	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=AUTO)
	public Long getId() {
		return id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @return the customers
	 */
	@ManyToMany(cascade = { PERSIST, MERGE, REMOVE })
	@JoinTable(name = "group_user", 
	joinColumns = @JoinColumn(name = "group_fk", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "user_fk", referencedColumnName = "id"))
	public List<Customer> getUsers() {
		return customers;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @param customers the customers to set
	 */
	public void setUsers(List<Customer> customers) {
		this.customers = customers;
	}   
	
	
   
}
