package edu.uoc.rsanchezs.ehairdressing.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Group
 *
 */
@Entity
public class Groups implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	@ManyToMany
	@JoinTable(name = "group_user", 
	joinColumns = @JoinColumn(name = "group_fk", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "user_fk", referencedColumnName = "id"))
	private List<User> users;
	

	public Groups() {
		super();
	}   
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
