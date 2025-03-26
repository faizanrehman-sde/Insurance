package com.asus.Insurance.Service;

import com.asus.Insurance.Dto.PurchaseDto;

public interface PurchaseService {
	
	PurchaseDto purchaseInsurance(Long userId, Long insuranceId);

}
