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
@Table(schema = "lankaoffers", name = "coinsPurchases")
public class CoinsPurchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Create relationship with Company //
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	// Create relationship with CoinsPackage //
	@ManyToOne
	@JoinColumn(name = "coinspackage_id", nullable = false)
	private CoinsPackage coinsPackage;
	
	@NotNull
	private double coinsCount;
	
	@NotNull
	private double coinsAmount;
	
	@NotNull(message = "Payment method is mandatory")
	private String paymentMethod;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public CoinsPurchase() {
		super();
	}
	
	public CoinsPurchase(Long id, Company company, CoinsPackage coinsPackage, double coinsCount, 
			double coinsAmount, String paymentMethod, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.id = id;
		this.company = company;
		this.coinsPackage = coinsPackage;
		this.coinsCount = coinsCount;
		this.coinsAmount = coinsAmount;
		this.paymentMethod = paymentMethod;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public CoinsPurchase(Company company, CoinsPackage coinsPackage, double coinsCount, 
			double coinsAmount, String paymentMethod, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.company = company;
		this.coinsPackage = coinsPackage;
		this.coinsCount = coinsCount;
		this.coinsAmount = coinsAmount;
		this.paymentMethod = paymentMethod;
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

	public CoinsPackage getCoinsPackage() {
		return coinsPackage;
	}

	public void setCoinsPackage(CoinsPackage coinsPackage) {
		this.coinsPackage = coinsPackage;
	}

	public double getCoinsCount() {
		return coinsCount;
	}

	public void setCoinsCount(double coinsCount) {
		this.coinsCount = coinsCount;
	}

	public double getCoinsAmount() {
		return coinsAmount;
	}

	public void setCoinsAmount(double coinsAmount) {
		this.coinsAmount = coinsAmount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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
