//package com.codevita.lankaoffers.entity;
//
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.lang.Nullable;
//
//@Entity
//@Table(schema = "lankaoffers", name = "categories")
//public class Category {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
////	// Create relationship with CategoryPreference //
////	@OneToMany(mappedBy = "category")
////	private CategoryPreference categoryPref;
//	
//	@NotNull(message = "Name is mandatory")
//	@Size(min = 3,max = 20 ,message = "Name must greater than 3 lower than 20")
//	private String name;
//	
//	@Nullable
//	private String logo;
//	
//	@Nullable
//	private String description;
//	
//	@CreationTimestamp
//	private Date createdAt;
//	
//	@UpdateTimestamp
//	private Date updatedAt;
//	
//	@Nullable
//	private Date deletedAt;
//	
//	//CONSTRUCTORS =================================================================================
//	
//	public Category() {
//		super();
//	}
//	
//	public Category(Long id, String name, String logo, String description, 
//			Date createdAt, Date updatedAt, Date deletedAt)
//	{
//		super();
//		this.id = id;
//		this.name = name;
//		this.logo = logo;
//		this.description = description;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		this.deletedAt = deletedAt;
//	}
//	
//	public Category(String name, String logo, String description, 
//			Date createdAt, Date updatedAt, Date deletedAt)
//	{
//		super();
//		this.name = name;
//		this.logo = logo;
//		this.description = description;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		this.deletedAt = deletedAt;
//	}
//	
//	//GETTERS AND SETTERS=========================================================================
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getLogo() {
//		return logo;
//	}
//
//	public void setLogo(String logo) {
//		this.logo = logo;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}
//
//	public Date getDeletedAt() {
//		return deletedAt;
//	}
//
//	public void setDeletedAt(Date deletedAt) {
//		this.deletedAt = deletedAt;
//	}	
//
//}
