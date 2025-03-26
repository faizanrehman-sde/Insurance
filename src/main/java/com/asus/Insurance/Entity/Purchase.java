package com.asus.Insurance.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Purchase { 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseId;
	
	
	private Long userId;                        // Assume user is authenticated
	
	private LocalDateTime purchasedDate;
	
	private String receiptId;
	
	private String price;
	
	private String status;
	
	@ManyToOne(cascade =  {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH},fetch = FetchType.LAZY)
	@JoinColumn(name = "InsuranceId")
	private Insurance insurance; 
	
	
	
	
	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Purchase(Long purchaseId,  Long userId, LocalDateTime purchasedDate, String receiptId, String price,
			String status, Insurance insurance) {
		super();
		this.purchaseId = purchaseId;
		this.userId = userId;
		this.purchasedDate = purchasedDate;
		this.receiptId = receiptId;
		this.price = price;
		this.status = status;
		this.insurance = insurance;
	}


	public Long getPurchaseId() {
		return purchaseId;
	}


	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public LocalDateTime getPurchasedDate() {
		return purchasedDate;
	}


	public void setPurchasedDate(LocalDateTime purchasedDate) {
		this.purchasedDate = purchasedDate;
	}


	public String getRecieptId() {
		return receiptId;
	}


	public void setReceiptId(String receiptId) {
		this.receiptId = receiptId;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Insurance getInsurance() {
		return insurance;
	}


	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	
	
    @PrePersist
	protected void onCreate() {
		this.purchasedDate=LocalDateTime.now();
	}
	
	


}
