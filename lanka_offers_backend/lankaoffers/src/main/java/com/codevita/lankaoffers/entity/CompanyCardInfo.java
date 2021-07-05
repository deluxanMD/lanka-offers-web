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
@Table(schema = "lankaoffers", name = "companyCards")
public class CompanyCardInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Create relationship with Company //
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	@NotNull(message = "Card name is mandatory")
	private String cardName;
	
	@NotNull(message = "Card number is mandatory")
	private String cardNumber;
	
	@NotNull(message = "Card expiry is mandatory")
	private Date cardExpiry;
	
	@NotNull(message = "Card pin is mandatory")
	private String cardPin;
	
	@Nullable
	private boolean isDefault;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =================================================================================
	
	public CompanyCardInfo() {
		super();
	}
	
	public CompanyCardInfo(Long id, Company company, String cardName, String cardNumber, 
			Date cardExpiry, String cardPin, boolean isDefault, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.id =id;
		this.company = company;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cardPin = cardPin;
		this.isDefault = isDefault;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public CompanyCardInfo(Company company, String cardName, String cardNumber, Date cardExpiry, 
			String cardPin, boolean isDefault, Date createdAt, Date updatedAt, Date deletedAt)
	{
		super();
		this.company = company;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cardPin = cardPin;
		this.isDefault = isDefault;
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

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(Date cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getCardPin() {
		return cardPin;
	}

	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
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
