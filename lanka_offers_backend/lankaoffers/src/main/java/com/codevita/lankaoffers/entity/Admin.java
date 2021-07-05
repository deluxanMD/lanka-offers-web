package com.codevita.lankaoffers.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	//CONSTRUCTORS =============================================================================

	public Admin() {
		super();
	}

	public Admin(User user) {
		super();
		this.user = user;
	}

	public Admin(Long id, User user) {
		super();
		this.id = id;
		this.user = user;
	}
		
	//GETTERS AND SETTERS / Encapsulated Fields ============================================================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
