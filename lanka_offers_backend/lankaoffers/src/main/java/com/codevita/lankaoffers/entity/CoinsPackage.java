package com.codevita.lankaoffers.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

@Entity
@Table(schema = "lankaoffers", name = "coinsPackages")
public class CoinsPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	// Create relationship with CompanyCardInfo //
//	@OneToMany(mappedBy = "coinsPackage")
//	private CoinsPurchase coinsPurchase;
	
	@NotNull(message = "packageName is mandatory")
	@Size(min = 2,max = 50 ,message = "Name must greater than 3 lower than 50")
	private String packageName;
	
	@NotNull(message = "Coins Count is mandatory")
	private int coinsCount;
	
	@NotNull(message = "Amount is mandatory")
	private double amount;
	
	@Nullable
	private String description;
	
	@NotNull(message = "Discount is mandatory")
	private double discount;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS ================================================================================
	
	public CoinsPackage() {
		super();	
	}
	
	public CoinsPackage(Long id, String packageName, int cointCount, 
			double amount, String description, double discount, 
			Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.id = id;
		this.packageName = packageName;
		this.coinsCount = cointCount;
		this.amount = amount;
		this.description = description;
		this.discount = discount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public CoinsPackage(String packageName, int cointCount, 
			double amount, String description, double discount , 
			Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.packageName = packageName;
		this.coinsCount = cointCount;
		this.amount = amount;
		this.description = description;
		this.discount = discount;
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

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getCoinsCount() {
		return coinsCount;
	}

	public void setCoinsCount(int coinsCount) {
		this.coinsCount = coinsCount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
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
