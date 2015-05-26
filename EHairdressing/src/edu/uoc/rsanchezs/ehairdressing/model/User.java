package edu.uoc.rsanchezs.ehairdressing.model;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.InheritanceType.JOINED;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;

import edu.uoc.rsanchezs.ehairdressing.constraints.Email;
import edu.uoc.rsanchezs.ehairdressing.constraints.Login;
import edu.uoc.rsanchezs.ehairdressing.constraints.NotEmpty;
import edu.uoc.rsanchezs.ehairdressing.util.PersistGroup;

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
	@Login(groups=PersistGroup.class)
	@NotEmpty(groups=PersistGroup.class)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@NotEmpty(groups=PersistGroup.class)
	@Email(groups=PersistGroup.class)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@ManyToMany(mappedBy = "users", cascade = PERSIST)
	public List<Groups> getGroups() {
		return groups;
	}
	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}
	
	/**
	 * Add the user into a group
	 * @param group
	 */
	public void add(Groups group){
		groups.add(group);
		group.getUsers().add(this);
	}
	
	/**
	 * Removes a user from the group
	 * @param group
	 */
	public void remove(Groups group){
		groups.remove(group);
		group.getUsers().remove(this);
	}
	
	/**
	 * Override hasCode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	/**
	 * Override equals method.
	 * Two users are equals if its id and username are equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
   
}
