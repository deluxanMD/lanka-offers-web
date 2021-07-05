package com.codevita.lankaoffers.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(schema = "lankaoffers", name = "companyReviews")
public class CompanyRating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Create relationship with Company //
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	// Create relationship with PublicGuest //
	@ManyToOne
	@JoinColumn(name = "guest_id", nullable = false)
	private PublicGuest publicGuest;
	
	@NotBlank(message = "Rating is mandatory")
	private String rating;
	
	@NotNull(message = "Comment is mandatory")
	private String comment;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public CompanyRating() {
		super();
	}
	
	public CompanyRating(Long id, Company company, PublicGuest publicGuest, String rating,
			String comment, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.id = id;
		this.company = company;
		this.publicGuest = publicGuest;
		this.rating = rating;
		this.comment = comment;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public CompanyRating(Company company, PublicGuest publicGuest, String rating,
			String comment, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.company = company;
		this.publicGuest = publicGuest;
		this.rating = rating;
		this.comment = comment;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public PublicGuest getPublicGuest() {
		return publicGuest;
	}

	public void setPublicGuest(PublicGuest publicGuest) {
		this.publicGuest = publicGuest;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
