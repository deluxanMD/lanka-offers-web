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
@Table(schema = "lankaoffers", name = "posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Create relationship with Company //
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	// Create relationship with PostCategory //
	@ManyToOne
	@JoinColumn(name = "postcategory_id", nullable = false)
	private PostCategory postCategory;
	
//	// Create relationship with PostComment //
//	@OneToMany(mappedBy = "post")
//	private PostComment postComment;
	
//	// Create relationship with PostLike //
//	@OneToMany(mappedBy = "post")
//	private PostLike postLike;
	
//	// Create relationship with PostRating //
//	@OneToMany(mappedBy = "post")
//	private PostRating postRating;
	
//	// Create relationship with PostReport //
//	@OneToMany(mappedBy = "post")
//	private PostReport postReport;
	
//	// Create relationship with PostShare //
//	@OneToMany(mappedBy = "post")
//	private PostShare postShare;
	
//	// Create relationship with PostTag //
//	@OneToMany(mappedBy = "post")
//	private PostTag postTag;
	
//	// Create relationship with PostView //
//	@OneToMany(mappedBy = "post")
//	private PostView postView;
	
//	// Create relationship with PostWish //
//	@OneToMany(mappedBy = "post")
//	private PostWish postWish;
	
	@NotNull(message = "Title is mandatory")
	private String title;

	@NotNull(message = "Short Description is mandatory")
	private String shortDescription;
	
	@NotNull(message = "Long Description is mandatory")
	private String longDescription;
	
	@NotNull
	private double sellingPrice;
	
	@NotNull
	private double discountPercent;
	
	@NotNull
	private double discountAmount;
	
	@NotNull(message = "Image1 is mandatory")
	private String image1;
	
	@Nullable
	private String image2;
	
	@Nullable
	private String image3;
	
	@Nullable
	private String video;
	
	@Nullable
	private String type;
	
	@Nullable
	private String htmlString;
	
	@Nullable
	private String url;
	
	@NotNull(message = "Status is mandatory")
	private String status;
	
	@NotNull(message = "Approved-On is mandatory")
	private Date approvedOn;
	
	@NotNull(message = "Post expiry date is mandatory")
	private Date postExpiryDate;
	
	@NotNull(message = "Offer start date is mandatory")
	private Date offerStartDate;
	
	@NotNull(message = "Offer valid until is mandatory")
	private Date offerValidUntil;
	
	@NotNull(message = "Coins Spent valid until is mandatory")
	private double coinsSpent;
	
	@NotNull(message = "Current Balance valid until is mandatory")
	private double currentBalance;
	
	@Nullable
	private String adminNote;
	
	@Nullable
	private boolean flag;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date updatedAt;
	
	@Nullable
	private Date deletedAt;
	
	//CONSTRUCTORS =============================================================================
	
	public Post() {
		super();
	}
	
	public Post(Long id, Company company, PostCategory postCategory, String title, String shortDescription, String longDescription, 
			double sellingPrice, double discountPercent, double discountAmount, String image1, String image2,  String image3, String video, 
			String type, String htmlString, String url, String status, Date approvedOn, Date postExpiryDate, 
			Date offerStartDate, Date offerValidUntil, String adminNote, boolean flag, Date createdAt, Date updatedAt, Date deletedAt ) 
	{	
		super();
		this.id = id;
		this.company = company;
		this.postCategory = postCategory;
		this.title = title;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.sellingPrice = sellingPrice;
		this.discountPercent = discountPercent;
		this.discountAmount = discountAmount;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.video = video;
		this.type = type;
		this.htmlString = htmlString;
		this.url = url;
		this.status = status;
		this.approvedOn = approvedOn;
		this.postExpiryDate = postExpiryDate;
		this.offerStartDate = offerStartDate;
		this.offerValidUntil = offerValidUntil;
		this.adminNote = adminNote;
		this.flag = flag;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}
	
	public Post(Company company,PostCategory postCategory, String title, String shortDescription, String longDescription, 
			double sellingPrice, double discountPercent, double discountAmount, String image1, String image2,  String image3, String video, 
			String type, String htmlString, String url, String status, Date approvedOn, Date postExpiryDate, 
			Date offerStartDate, Date offerValidUntil, String adminNote, boolean flag, Date createdAt, Date updatedAt, Date deletedAt ) 
	{	
		super();
		this.company = company;
		this.postCategory = postCategory;
		this.title = title;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.sellingPrice = sellingPrice;
		this.discountPercent = discountPercent;
		this.discountAmount = discountAmount;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.video = video;
		this.type = type;
		this.htmlString = htmlString;
		this.url = url;
		this.status = status;
		this.approvedOn = approvedOn;
		this.postExpiryDate = postExpiryDate;
		this.offerStartDate = offerStartDate;
		this.offerValidUntil = offerValidUntil;
		this.adminNote = adminNote;
		this.flag = flag;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public PostCategory getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(PostCategory postCategory) {
		this.postCategory = postCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHtmlString() {
		return htmlString;
	}

	public void setHtmlString(String htmlString) {
		this.htmlString = htmlString;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	public Date getPostExpiryDate() {
		return postExpiryDate;
	}

	public void setPostExpiryDate(Date postExpiryDate) {
		this.postExpiryDate = postExpiryDate;
	}

	public Date getOfferStartDate() {
		return offerStartDate;
	}

	public void setOfferStartDate(Date offerStartDate) {
		this.offerStartDate = offerStartDate;
	}

	public Date getOfferValidUntil() {
		return offerValidUntil;
	}

	public void setOfferValidUntil(Date offerValidUntil) {
		this.offerValidUntil = offerValidUntil;
	}

	public double getCoinsSpent() {
		return coinsSpent;
	}

	public void setCoinsSpent(double coinsSpent) {
		this.coinsSpent = coinsSpent;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAdminNote() {
		return adminNote;
	}

	public void setAdminNote(String adminNote) {
		this.adminNote = adminNote;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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
