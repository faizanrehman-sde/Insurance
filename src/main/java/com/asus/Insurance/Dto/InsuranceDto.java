package com.asus.Insurance.Dto;

import com.asus.Insurance.enums.Type;

import jakarta.validation.constraints.NotBlank;

/**
 * Represents an insurance policy's data during API requests/responses.
 * Used for creating/updating policies and transferring policy details between layers.
 */
public class InsuranceDto {
	
	/** Unique insurance identifier (auto-generated when persisted) */
    private Long insuranceId;
    
    /** 
     * Human-readable insurance name (e.g., "Senior Health Plan") 
     * @apiNote Required field with non-blank validation
     */
    @NotBlank(message= "Enter a valid insurance name !!")
	private String name;
	
    /** 
     * Category of insurance (e.g., "Health", "Auto") 
     * @apiNote Expected to match predefined policy types in the system
     */
	@NotBlank(message="Enter a valid insurance type !!")
	private String type;
	
	/** 
     * Coverage details as free-text (e.g., "Dental and vision included") 
     * @apiNote Stored as string for flexibility - no format validation
     */
	@NotBlank(message="Enter a valid value !!")
	private String coverage;
	
    /** 
     * Premium amount as a string (e.g., "$150/month" or "150") 
     * @warning No currency/format validation - parsing required in service layer
     */
	@NotBlank(message ="Enter a valid value !!")
	private String  premium;
	
	/** 
     * Minimum eligible age (inclusive) - stored as string to support ranges like "18-30" 
     * @example "18", "21-65"
     */
	@NotBlank(message = "Enter a valid value !!")
	private String minAge;
	
	 /** 
     * Maximum eligible age (inclusive) - same format as minAge 
     * @example "65", "no limit"
     */
	@NotBlank(message = "Enter a valid value !!")
	private String maxAge;
	
	/** 
     * Gender category this insurance applies to (optional filter) 
     * @see Type Enum for valid values (e.g., MALE, FEMALE, OTHER)
     */
	private Type gender;
	
	  /** 
     * Display price (may include currency symbols or special formatting) 
     * @example "$199.99", "Contact for pricing"
     */
	private String price;

	

	public InsuranceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public InsuranceDto(Long insuranceId, @NotBlank(message = "Enter a valid insurance name !!") String name,
			@NotBlank(message = "Enter a valid insurance type !!") String type,
			@NotBlank(message = "Enter a valid value !!") String coverage,
			@NotBlank(message = "Enter a valid value !!") String premium,
			@NotBlank(message = "Enter a valid value !!") String minAge,
			@NotBlank(message = "Enter a valid value !!") String maxAge, Type gender, String price) {
		super();
		this.insuranceId = insuranceId;
		this.name = name;
		this.type = type;
		this.coverage = coverage;
		this.premium = premium;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.gender = gender;
		this.price = price;
	}

	public Long getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getMinAge() {
		return minAge;
	}

	public void setMinAge(String minAge) {
		this.minAge = minAge;
	}

	public String getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(String maxAge) {
		this.maxAge = maxAge;
	}

	public Type getGender() {
		return gender;
	}

	public void setGender(Type gender) {
		this.gender = gender;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	

}
