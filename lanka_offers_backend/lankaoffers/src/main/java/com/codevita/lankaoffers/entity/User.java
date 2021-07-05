package com.codevita.lankaoffers.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(schema = "lankaoffers", name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	// Create relationship with ActivityLog //
//	@OneToMany(mappedBy = "user")
//	private ActivityLog activityLog;
	
//	// Create relationship with LoginHistory //
//	@OneToMany(mappedBy = "user")
//	private LoginHistory loginHistory;
	
//	// Create relationship with PostReport //
//	@OneToMany(mappedBy = "user")
//	private PostReport postReport;
	
	@NotNull
	@Size(min = 3,max = 20 ,message = "Name must greater than 3 lower than 20")
	private String name;
	
	@NotNull(message = "Contact Number is mandatory")
	private String contactNo;
	
	@NotNull
	private String role;
	
	@Nullable
	private String email;
	
	@NotNull
	private String password; 
	
	@Nullable
	private String resetToken;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	
	//CONSTRUCTORS ===============================================================================================
	
	public User() {
		super();
	}
	
	public User(Long id, String name, String contactNo, String role, 
			String email, String password, Date createdAt, Date updatedAt, Date deletedAt) 
	{
		super();
		this.id = id;
		this.name = name;
		this.contactNo = contactNo;
		this.role = role;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		
	}
	
	public User(String name, String contactNo, String role, 
			String email, String password, Date createdAt, Date updatedAt, Date deletedAt) 
	{
		super();
		this.name = name;
		this.contactNo = contactNo;
		this.role = role;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		
	}
	
	//GETTERS AND SETTERS=========================================================================

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

}
