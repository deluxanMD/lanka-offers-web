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
@Table(schema = "lankaoffers", name = "postReports")
public class PostReport {
	
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
	
	// Create relationship with User //
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@NotNull(message = "Reason Code is mandatory")
	private String reasonCode;
	
	@NotNull(message = "Comments is mandatory")
	private String comment;
	
	@NotNull(message = "Admin Comment is mandatory")
	private String adminComment;
	
	@NotNull(message = "Status is mandatory")
	private String status;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public PostReport() {
		super();
	}
	
	public PostReport(Long id, Post post, PublicGuest publicGuest, User user, String reasonCode, String comment, 
			String adminComment, String status, Date createdAt, Date updatedAt, Date deletedAt) 
	{
		super();
		this.id = id;
		this.post = post;
		this.publicGuest = publicGuest;
		this.user = user;
		this.reasonCode = reasonCode;
		this.comment = comment;
		this.adminComment = adminComment;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;	
	}
	
	public PostReport(Post post, PublicGuest publicGuest, User user, String reasonCode, String comment, 
			String adminComment, String status, Date createdAt, Date updatedAt, Date deletedAt) 
	{
		super();
		this.post = post;
		this.publicGuest = publicGuest;
		this.user = user;
		this.reasonCode = reasonCode;
		this.comment = comment;
		this.adminComment = adminComment;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
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
