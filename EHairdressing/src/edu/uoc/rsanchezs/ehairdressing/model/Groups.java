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
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Groups
 *
 */
@Entity
@NamedQuery(name = "Groups.findById", query = "SELECT g FROM Groups g WHERE g.id=:id")
public class Groups implements Serializable {
	
	public static final String FIND_BY_ID = "Groups.findById";

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private String name;
	private String description;
	private List<User> users = new ArrayList<User>();
	

	public Groups() {
		super();
	}


	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy=SEQUENCE)
	@Column(name = "GROUP_ID")
	public Long getId() {
		return id;
	}


	/**
	 * @return the name
	 */
	@Column(name = "GROUP_NAME")
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
	@ManyToMany(cascade = PERSIST)
	@JoinTable(name = "USERS_GROUPS", joinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID"))
	public List<User> getUsers() {
		return users;
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
	public void setUsers(List<User> users) {
		this.users = users;
	}   
	
	/**
	 * Add a user into the group
	 * @param user
	 */
	public void add(User user){
		users.add(user);
		user.getGroups().add(this);
	}
	
	/**
	 * Removes a user from the group
	 * @param user
	 */
	public void remove(User user){
		users.remove(user);
		user.getGroups().remove(this);
	}
   
}
