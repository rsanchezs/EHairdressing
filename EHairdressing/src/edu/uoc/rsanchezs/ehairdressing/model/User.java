package edu.uoc.rsanchezs.ehairdressing.model;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import static javax.persistence.InheritanceType.JOINED;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy = JOINED)
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String password;
	private String username;
	
	private List<Groups> groups = new ArrayList<Groups>();


	public User() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name = "USER_ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@ManyToMany(mappedBy = "users", cascade = { PERSIST, MERGE, REMOVE })
	public List<Groups> getGroups() {
		return groups;
	}
	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}
	
	
   
}
