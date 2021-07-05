package com.codevita.lankaoffers.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(schema = "lankaoffers", name = "locations")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Name is mandatory")
	@Size(min = 3,max = 50 ,message = "Name must greater than 3 lower than 50")
	private String name;
	
	@Nullable
	private String description;
	
	@Column(precision=12, scale=8)
	@NotBlank(message = "Latitude is mandatory")
	private double coordinateLatitude;
	
	@Column(precision=12, scale=8)
	@NotBlank(message = "Longitude is mandatory")
	private double coordinateLongitude;
	
	@Nullable
	private String parentId;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public Location() {
		super();
	}
	
	public Location(Long id, String name, String description, double coordinateLatitude, 
			double coordinateLongitude, String parentId, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.parentId = parentId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public Location(String name, String description, double coordinateLatitude, 
			double coordinateLongitude, String parentId, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.name = name;
		this.description = description;
		this.coordinateLatitude = coordinateLatitude;
		this.coordinateLongitude = coordinateLongitude;
		this.parentId = parentId;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCoordinateLatitude() {
		return coordinateLatitude;
	}

	public void setCoordinateLatitude(double coordinateLatitude) {
		this.coordinateLatitude = coordinateLatitude;
	}

	public double getCoordinateLongitude() {
		return coordinateLongitude;
	}

	public void setCoordinateLongitude(double coordinateLongitude) {
		this.coordinateLongitude = coordinateLongitude;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
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
