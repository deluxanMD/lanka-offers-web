package com.codevita.lankaoffers.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(schema = "lankaoffers", name = "companies")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
//	// Create relationship with CoinsPurchase //
//	@OneToMany(mappedBy = "company")
//	private CoinsPurchase coinsPurchase;
	
//	// Create relationship with CompanyPreference //
//	@OneToMany(mappedBy = "company")
//	private CompanyPreference companyPref;

//	// Create relationship with BlockedCompany //
//	@OneToMany(mappedBy = "company")
//	private BlockedCompany blockedComp;

//	// Create relationship with CompanyCardInfo //
//	@OneToMany(mappedBy = "company")
//	private CompanyCardInfo companyCardInfo;
	
//	// Create relationship with CompanyRating //
//	@OneToMany(mappedBy = "company")
//	private CompanyRating companyRating;
	
//	// Create relationship with LoginHistory //
//	@OneToMany(mappedBy = "company")
//	private LoginHistory loginHistory;
	
//	// Create relationship with Post //
//	@OneToMany(mappedBy = "company")
//	private Post post;
	
	@NotNull
	@Size(min = 3,max = 20 ,message = "Name must greater than 3 lower than 20")
	private String companyName;
	
	@NotNull
	private String regNo;
	
	@NotNull
	private String logo;
	
	@NotNull(message = " Company Email is mandatory")
	private String email;

	@NotNull
	private String shortDescription;
	
	@Nullable
	private String longDescription;
	
	@NotNull(message = "Company Address is mandatory")
	private String address;
	
	@NotNull(message = "Company Contact Number is mandatory")
	private String contact1;
	
	@Nullable
	private String contact2;
	
	@Nullable
	private String url;
	
	@NotNull(message = "Location is mandatory")
	private String location;
	
	@NotNull
	@Size(min = 2,max = 25 ,message = "Category must greater than 2 lower than 25")
	private String category;
	
	//Image
	@NotNull(message = "Owner NIC is mandatory")
	private String ownerNIC;
	
	@NotNull(message = "Owner Address is mandatory")
	private String ownerAddress;
	
	@Nullable
	private String status;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =============================================================================
	
	public Company() {
		super();
	}
	
	public Company(Long id, User user, String companyName, String regNo, String logo, String email, String shortDescription, 
			String longDescription, String address, String contact1, String contact2, String url, String location, 
			String category, String ownerNIC, String ownerAddress, 
			String status, Date createdAt, Date updatedAt, Date deletedAt) 
	{	
		super();
		this.id = id;
		this.user = user;
		this.companyName = companyName;
		this.regNo = regNo;
		this.logo = logo;
		this.email = email;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.address = address;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.url = url;
		this.location = location;
		this.category = category;
		this.ownerNIC = ownerNIC;
		this.ownerAddress = ownerAddress;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public Company(User user, String companyName, String regNo, String logo, String email, String shortDescription, 
			String longDescription, String address, String contact1, String contact2, String url, String location, 
			String category, String ownerNIC, String ownerAddress, 
			String status, Date createdAt, Date updatedAt, Date deletedAt) 
	{	
		super();
		this.user = user;
		this.companyName = companyName;
		this.regNo = regNo;
		this.logo = logo;
		this.email = email;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.address = address;
		this.contact1 = contact1;
		this.contact2 = contact2;
		this.url = url;
		this.location = location;
		this.category = category;
		this.ownerNIC = ownerNIC;
		this.ownerAddress = ownerAddress;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	//GETTERS AND SETTERS============================================================

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact1() {
		return contact1;
	}

	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}

	public String getContact2() {
		return contact2;
	}

	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOwnerNIC() {
		return ownerNIC;
	}

	public void setOwnerNIC(String ownerNIC) {
		this.ownerNIC = ownerNIC;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
