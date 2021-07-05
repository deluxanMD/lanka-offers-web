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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(schema = "lankaoffers", name = "postShares")
public class PostShare {
	
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
	
	@NotBlank(message = "Source is mandatory")
	private String source;
	
	@NotBlank(message = "Url is mandatory")
	private String url;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public PostShare() {
		super();
	}
	
	public PostShare(Long id, Post post, PublicGuest publicGuest, String source,
			String url, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.id = id;
		this.post = post;
		this.publicGuest = publicGuest;
		this.source = source;
		this.url = url;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public PostShare(Post post, PublicGuest publicGuest, String source,
			String url, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.post = post;
		this.publicGuest = publicGuest;
		this.source = source;
		this.url = url;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
