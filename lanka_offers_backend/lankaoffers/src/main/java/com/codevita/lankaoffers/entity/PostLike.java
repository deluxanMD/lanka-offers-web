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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(schema = "lankaoffers", name = "postLikes")
public class PostLike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Create relationship with Post //
	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;
	
	// Create relationship with PublicGuest //
	@ManyToOne
	@JoinColumn(name = "guest_id", nullable = false)
	private PublicGuest publicGuest;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public PostLike() {
		super();
	}
	
	public PostLike(Long id, Post post, PublicGuest publicGuest, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.id =id;
		this.post = post;
		this.publicGuest = publicGuest;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public PostLike(Post post, PublicGuest publicGuest, Date createdAt, Date updatedAt, Date deletedAt) {
		super();
		this.post = post;
		this.publicGuest = publicGuest;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public PublicGuest getPublicGuest() {
		return publicGuest;
	}

	public void setPublicGuest(PublicGuest publicGuest) {
		this.publicGuest = publicGuest;
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
