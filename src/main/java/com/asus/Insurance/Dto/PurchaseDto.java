package com.asus.Insurance.Dto;

import java.time.LocalDateTime;

/**
 * Represents a purchase transaction record for insurance policies.
 * Used to confirm purchases and provide transaction summaries to users.
 */
public class PurchaseDto {
	

   
	private String receiptId;

	private LocalDateTime purchaseDate;
	
    /**
	* Assume user authenticated
	* for the time, provide random userId
	*/
	private Long userId; 
	
	private String insuranceId;
	
	private String insuranceName;
	
	private String insuranceType;
	
	private String coverage;
	
	private String premium;
	
	private String status;
	
	private String payment;

	

	public PurchaseDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PurchaseDto(String receiptId, LocalDateTime purchaseDate, Long userId, String insuranceId,
			String insuranceName, String insuranceType, String coverage, String premium, String status,
			String payment) {
		super();
		this.receiptId = receiptId;
		this.purchaseDate = purchaseDate;
		this.userId = userId;
		this.insuranceId = insuranceId;
		this.insuranceName = insuranceName;
		this.insuranceType = insuranceType;
		this.coverage = coverage;
		this.premium = premium;
		this.status = status;
		this.payment = payment;
	}



	public String getRecieptId() {
		return receiptId;
	}



	public void setRecieptId(String recieptId) {
		this.receiptId = recieptId;
	}



	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}



	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getInsuranceId() {
		return insuranceId;
	}



	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}



	public String getInsuranceName() {
		return insuranceName;
	}



	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}



	public String getInsuranceType() {
		return insuranceType;
	}



	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}



	public String getCoverage() {
		return coverage;
	}



	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}



	public String getPremium() {
		return premium;
	}



	public void setPremium(String premium) {
		this.premium = premium;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getPayment() {
		return payment;
	}



	public void setPayment(String payment) {
		this.payment = payment;
	}







	
}
