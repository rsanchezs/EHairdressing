package edu.uoc.rsanchezs.ehairdressing.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.math.BigDecimal;
import java.time.Duration;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.GenerationType.TABLE;
import static javax.persistence.TemporalType.TIME;

/**
 * Entity implementation class for Entity: Service
 *
 */
@Entity

public class Service implements Serializable {

	
	private Long id;
	private String name;
	private BigDecimal price;
	private Long duration;
	private static final long serialVersionUID = 1L;

	public Service() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = TABLE)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}   
	
	public Long getDuration() {
		return this.duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}
   
}
