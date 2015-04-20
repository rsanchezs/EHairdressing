package edu.uoc.rsanchezs.ehairdressing.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.DiscriminatorType.INTEGER;
import static javax.persistence.DiscriminatorType.CHAR;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import static javax.persistence.DiscriminatorType.STRING;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name="DISC",discriminatorType = CHAR)
@DiscriminatorValue("U")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL= "User.findAll";
	@Id 
	@GeneratedValue
	private Long id;

	private String password;

	private String username;
	
	@ManyToMany(mappedBy="users")
	private List<Groups> groups;

	public User() {
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

	/**
	 * @return the groups
	 */
	public List<Groups> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}
	
	

}