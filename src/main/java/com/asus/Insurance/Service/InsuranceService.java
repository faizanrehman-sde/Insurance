package com.asus.Insurance.Service;
import java.util.List;
import com.asus.Insurance.Dto.InsuranceDto;
import com.asus.Insurance.enums.Type;

public interface InsuranceService {
	
	
	InsuranceDto createInsurance(InsuranceDto insuranceDto);
	List<InsuranceDto> getAllInsurance();
	
	
	//Brownie points Api
	
	List<InsuranceDto> getAllInsuranceByGender(Type gender);
	
	List<InsuranceDto> getAllInsuranceByAge(String age);

}
