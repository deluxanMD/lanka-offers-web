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
@Table(schema = "lankaoffers", name = "activityLogs")
public class ActivityLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Create relationship with User //
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	// Create relationship with PublicGuest //
	@ManyToOne
	@JoinColumn(name = "guest_id", nullable = false)
	private PublicGuest publicGuest;
		
	// Create relationship with Company //
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	@NotNull
	private String actionType;
	
	@NotNull
	private String actionEntity;
	
	@NotNull
	private Long entityId;
	
	@Nullable
	private String description;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public ActivityLog() {
		super();
	}
	
	public ActivityLog(Long id, User user, PublicGuest publicGuest, Company company, String actionType,
			String actionEntity, Long entityId, String description, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.id = id;
		this.user = user;
		this.publicGuest = publicGuest;
		this.company = company;
		this.actionType = actionType;
		this.actionEntity = actionEntity;
		this.entityId = entityId;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public ActivityLog(User user, PublicGuest publicGuest, Company company, String actionType,
			String actionEntity, Long entityId, String description, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.user = user;
		this.publicGuest = publicGuest;
		this.company = company;
		this.actionType = actionType;
		this.actionEntity = actionEntity;
		this.entityId = entityId;
		this.description = description;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PublicGuest getPublicGuest() {
		return publicGuest;
	}

	public void setPublicGuest(PublicGuest publicGuest) {
		this.publicGuest = publicGuest;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionEntity() {
		return actionEntity;
	}

	public void setActionEntity(String actionEntity) {
		this.actionEntity = actionEntity;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
