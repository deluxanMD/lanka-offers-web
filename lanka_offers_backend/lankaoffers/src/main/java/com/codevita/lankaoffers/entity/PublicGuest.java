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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(schema = "lankaoffers", name = "publicGuests")
public class PublicGuest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
//	// Create relationship with CategoryPreference //
//	@OneToMany(mappedBy = "publicGuest")
//	private CategoryPreference categoryPref;
//	
//	// Create relationship with CompanyPreference //
//	@OneToMany(mappedBy = "publicGuest")
//	private CompanyPreference companyPref;
//	
//	// Create relationship with BlockedCompany //
//	@OneToMany(mappedBy = "publicGuest")
//	private BlockedCompany blockedComp;
	
//	// Create relationship with LoginHistory //
//	@OneToMany(mappedBy = "publicGuest")
//	private LoginHistory loginHistory;
	
//	// Create relationship with PostComment //
//	@OneToMany(mappedBy = "publicGuest")
//	private PostComment postComment;
	
//	// Create relationship with PostLike //
//	@OneToMany(mappedBy = "publicGuest")
//	private PostLike postLike;
	
//	// Create relationship with PostRating //
//	@OneToMany(mappedBy = "publicGuest")
//	private PostRating postRating;
		
//	// Create relationship with PostReport //
//	@OneToMany(mappedBy = "publicGuest")
//	private PostReport postReport;
	
//	// Create relationship with PostShare //
//	@OneToMany(mappedBy = "publicGuest")
//	private PostShare postShare;
	
//	// Create relationship with PostView //
//	@OneToMany(mappedBy = "publicGuest")
//	private PostView postView;
	
//	// Create relationship with PostWish //
//	@OneToMany(mappedBy = "publicGuest")
//	private PostWish postWish;
	
	@NotNull(message = "Public Guest NIC number is mandatory")
	private String publicNIC;
	
	@Nullable
	private String source;
	
	@Nullable
	private String sourceUrl;
	
	@Nullable
	private String dp;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =============================================================================
	
	public PublicGuest() {
		super();
	}
	
	public PublicGuest(Long id, User user, String publicNIC,String source, String sourceUrl,
			String dp, Date createdAt, Date updatedAt, Date deletedAt) {
		
		super();
		this.id = id;
		this.user = user;
		this.publicNIC = publicNIC;
		this.source = source;
		this.sourceUrl = sourceUrl;
		this.dp = dp;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public PublicGuest(User user, String publicNIC,String source, String sourceUrl,
			String dp, Date createdAt, Date updatedAt, Date deletedAt) {
		
		super();
		this.user = user;
		this.publicNIC = publicNIC;
		this.source = source;
		this.sourceUrl = sourceUrl;
		this.dp = dp;
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

	public String getPublicNIC() {
		return publicNIC;
	}

	public void setPublicNIC(String publicNIC) {
		this.publicNIC = publicNIC;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getDp() {
		return dp;
	}

	public void setDp(String dp) {
		this.dp = dp;
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
