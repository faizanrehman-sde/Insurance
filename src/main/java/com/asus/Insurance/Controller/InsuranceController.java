package com.asus.Insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asus.Insurance.Dto.InsuranceDto;
import com.asus.Insurance.Service.InsuranceService;
import com.asus.Insurance.enums.Type;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/insurance")
public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;

	
	/**
	 * Creates a new insurance from validated request data.
	 * 
	 * @param insuranceDto Request body containing insurance details (e.g., name,
	 *                     type, coverage, premium, minAge, maxAge, gender, price)
	 * @return Newly created insurance(InsuranceDto) with HTTP 201 status
	 */
	@PostMapping("/create")
	public ResponseEntity<InsuranceDto> createInsurance(@Valid @RequestBody InsuranceDto insuranceDto) {
		return new ResponseEntity<InsuranceDto>(this.insuranceService.createInsurance(insuranceDto),HttpStatus.CREATED);
	}

	
	
	/**
	 * Retrieves all insurance insurance in the system.
	 * 
	 * @return List of insuranceDto with HTTP 200 status
	 */
	@GetMapping("/")
	public ResponseEntity<List<InsuranceDto>> getAllInsurance() {
		return new ResponseEntity<List<InsuranceDto>>(this.insuranceService.getAllInsurance(), HttpStatus.OK);
	}
	

	/**
	 * Filters insurance by gender category.
	 * 
	 * @param gender Valid values from {@link Type} enum (e.g., MALE, FEMALE, OTHER)
	 * @return List of  InsuranceDto with HTTP with 200 status
	 */
	@GetMapping("/byGender")
	public ResponseEntity<List<InsuranceDto>> getAllinsuranceByGender(@RequestParam Type gender) {
		return new ResponseEntity<List<InsuranceDto>>(this.insuranceService.getAllInsuranceByGender(gender),HttpStatus.OK);
	}

	
	/**
	 * Filters insurance by age.
	 * 
	 * @param age Expected format: numeric string (e.g., "35") Fetches all
	 *  insurances,if the age lies between minAge and maxAge
	 *  @return  List of  InsuranceDto with HTTP with 200 status
	 */
	@GetMapping("/byAge")
	public ResponseEntity<List<InsuranceDto>> getAllInsuranceByage(@RequestParam String age) {
		return new ResponseEntity<List<InsuranceDto>>(this.insuranceService.getAllInsuranceByAge(age), HttpStatus.OK);
	}
}
