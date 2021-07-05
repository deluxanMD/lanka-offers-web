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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(schema = "lankaoffers", name = "categoryPreferences")
public class CategoryPreference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Create relationship with PublicGuest //
	@ManyToOne
	@JoinColumn(name = "guest_id", nullable = false)
	private PublicGuest publicGuest;
	
	// Create relationship with Category //
	@ManyToOne
	@JoinColumn(name = "postcategory_id", nullable = false)
	private PostCategory postCategory;
	
	@NotNull(message = "Order is mandatory")
	private int prefOrder;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public CategoryPreference() {
		super();
	}
	
	public CategoryPreference(Long id, PublicGuest publicGuest, PostCategory postCategory, int prefOrder, 
			Date createdAt, Date updatedAt, Date deletedAt) {
		
		super();
		this.id = id;
		this.publicGuest = publicGuest;
		this.postCategory = postCategory;
		this.prefOrder = prefOrder;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public CategoryPreference(PublicGuest publicGuest, PostCategory postCategory, int prefOrder, 
			Date createdAt, Date updatedAt, Date deletedAt) {
		
		super();
		this.publicGuest = publicGuest;
		this.postCategory = postCategory;
		this.prefOrder = prefOrder;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	//GETTERS AND SETTERS============================================================
	
	public PublicGuest getPublicGuest() {
		return publicGuest;
	}

	public void setPublicGuest(PublicGuest publicGuest) {
		this.publicGuest = publicGuest;
	}

	public PostCategory getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(PostCategory postCategory) {
		this.postCategory = postCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPrefOrder() {
		return prefOrder;
	}

	public void setPrefOrder(int prefOrder) {
		this.prefOrder = prefOrder;
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
