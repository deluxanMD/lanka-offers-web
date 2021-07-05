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
@Table(schema = "lankaoffers", name = "postViews")
public class PostView {
	
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
	
	@Nullable
	private String ip;
	
	@NotNull(message = "Country is mandatory")
	private String country;
	
	@NotNull(message = "Region is mandatory")
	private String region;
	
	@NotNull(message = "Device is mandatory")
	private String device;
	
	@NotNull(message = "Session-Id is mandatory")
	private String sessionId;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public PostView() {
		super();
	}
	
	public PostView(Long id, Post post, PublicGuest publicGuest, String ip, String country, String region, 
			String device, String sessionId, Date createdAt, Date updatedAt, Date deletedAt) 
	{
		super();
		this.id = id;
		this.post = post;
		this.publicGuest = publicGuest;
		this.ip = ip;
		this.country = country;
		this.region = region;
		this.device = device;
		this.sessionId = sessionId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;	
	}
	
	public PostView(Post post, PublicGuest publicGuest, String ip, String country, String region, 
			String device, String sessionId, Date createdAt, Date updatedAt, Date deletedAt) 
	{
		super();
		this.post = post;
		this.publicGuest = publicGuest;
		this.ip = ip;
		this.country = country;
		this.region = region;
		this.device = device;
		this.sessionId = sessionId;
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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
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
