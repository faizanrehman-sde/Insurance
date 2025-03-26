package com.asus.Insurance.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asus.Insurance.Dto.InsuranceDto;
import com.asus.Insurance.Entity.Insurance;
import com.asus.Insurance.Repository.InsuranceRepository;
import com.asus.Insurance.Service.InsuranceService;
import com.asus.Insurance.enums.Type;

/**
 * Handles insurance policy management logic, including CRUD operations and filtering.
 * Relies on ModelMapper for DTO-entity conversion, requiring consistent field names between classes.
 */
@Service
public class InsuranceServiceImp  implements InsuranceService  {

	 @Autowired
	 private InsuranceRepository insuranceRepo;	
	 
	 @Autowired
	 private ModelMapper modelMapper;
	
	 /**
	  * Creates a new insurance policy from validated DTO data.
	  * @param insuranceDto Validated policy details (enforced via @Valid in controller)
	  * @return Newly created policy as DTO
	
	  */
	@Override
	public InsuranceDto createInsurance(InsuranceDto insuranceDto) {
	       Insurance insurance = this.mapToInsurance(insuranceDto);
	       Insurance ins =  this.insuranceRepo.save(insurance);
		   return this.mapToInsuranceDto(ins);
	}
	
	/**
     * Retrieves all insurance policies in the system.
     * @return List of policy DTOs (empty list if none exist)
     */
	@Override
	public List<InsuranceDto> getAllInsurance() {
		List<Insurance> insurances=this.insuranceRepo.findAll();
		List<InsuranceDto> insuranceDto=insurances.stream().map(e->this.mapToInsuranceDto(e)).collect(Collectors.toList());
		return insuranceDto;
	}
	
	/**
     * Filters insurances by gender eligibility.
     * @param gender Valid value from Type enum (e.g., MALE)
     * @return Non-empty list of matching insurances
     * @throws RuntimeException (HTTP 500) if no policies match
     */
	@Override
	public List<InsuranceDto> getAllInsuranceByGender(Type gender) {
		List<Insurance> insurances= this.insuranceRepo.findByGender(gender);
		if(insurances.isEmpty()){
			throw new RuntimeException("No insurance found with given gender");
		}
		   return insurances.stream().map(e->this.mapToInsuranceDto(e)).collect(Collectors.toList());
		
	}
	
	/**
     * Filters insurance by age eligibility.
     * @param age Expected format: numeric string (e.g., "35") 
     * @return Non-empty list of matching policies
     * @throws RuntimeException (HTTP 500) if no policies match
     * @implNote Repository method 'findInsuranceByAge' must parse age string
     */
	@Override
	public List<InsuranceDto> getAllInsuranceByAge(String age) {
		   List<Insurance> insurances=   this.insuranceRepo.findInsuranceByAge(age);
		   if(insurances.isEmpty()) {
			   throw new RuntimeException("No insurance found with this age");
		   }
		   return insurances.stream().map(e->this.mapToInsuranceDto(e)).collect(Collectors.toList());
	}

	
	
	
	
	

// --- Mapping Utilities ---
    
    /**
     * Converts DTO to entity using ModelMapper.
     * @assumes Field names in InsuranceDto and Insurance match exactly
     */
	private Insurance mapToInsurance(InsuranceDto insuranceDto) {
		   return this.modelMapper.map(insuranceDto, Insurance.class);
    }
	
	 /**
     * Converts entity to DTO using ModelMapper.
     * @assumes Field names in Insurance and InsuranceDto match exactly
     */
	private InsuranceDto mapToInsuranceDto (Insurance insurance) {
		return this.modelMapper.map(insurance, InsuranceDto.class);
	}

	
	
	
	

}
