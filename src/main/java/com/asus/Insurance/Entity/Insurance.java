package com.asus.Insurance.Entity;

import com.asus.Insurance.enums.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Insurance {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long insuranceId;
	
    @NotBlank(message= "Enter a valid insurance name !!")
	private String name;
	
	@NotBlank(message="Enter a valid insurance type !!")
	private String type;
	
	@NotBlank(message="Enter a valid value !!")
	private String coverage;
	
	@NotBlank(message ="Enter a valid value !!")
	private String  premium;
	
	@NotBlank(message = "Enter a valid value !!")
	private String minAge;
	
	@NotBlank(message = "Enter a valid value !!")
	private String maxAge;
	
	
	@Enumerated(EnumType.STRING)
	private Type gender;
	
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	public Insurance(Long insuranceId, @NotBlank(message = "Enter a valid insurance name !!") String name,
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

	


}
