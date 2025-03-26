package com.asus.Insurance.ServiceImp;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asus.Insurance.Dto.PurchaseDto;
import com.asus.Insurance.Entity.Insurance;
import com.asus.Insurance.Entity.Purchase;
import com.asus.Insurance.Repository.InsuranceRepository;
import com.asus.Insurance.Repository.PurchaseRepository;
import com.asus.Insurance.Service.PurchaseService;

/**
 * Handles insurance purchase transactions, linking users to insurance.
 * Generates simplified purchase records without actual payment processing.
 */
@Service
public class PurchaseServiceImp implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepo;
	
	@Autowired
	private InsuranceRepository insuranceRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	  /**
     * Creates a purchase record linking user to insurance policy.
     * 
     * @param userId Authenticated (Assumed)
     * @param insuranceId Existing insurance ID from database
     * @return Purchase confirmation DTO with insurance details
     * 
     * @throws RuntimeException (HTTP 500) if insurance not found
     * - Hardcoded success status ("Successfully purchased !!")
     * - UUID receipt truncated to 8 chars (collision risk: 1 in ~4 billion)
     */
	@Override
	public PurchaseDto purchaseInsurance(Long userId, Long insuranceId) {
	  Insurance insurance =this.insuranceRepo.findById(insuranceId).orElseThrow(()-> new RuntimeException("Insurance not found with this Id"));
	  Purchase purchase = new Purchase();
	  purchase.setInsurance(insurance);
	  purchase.setUserId(userId);
	  purchase.setPrice(insurance.getPrice());
	  purchase.setStatus("Successfully purchased !!");
	  purchase.setReceiptId("Tx-" + UUID.randomUUID().toString().substring(0, 8));	
	  this.purchaseRepo.save(purchase);
		return this.ConvertToPurchaseDto(purchase);  
	}
	
	
	
	
	
	 /**
     * Converts Purchase entity to DTO with additional policy details.
     * @note Manual field mapping supplements ModelMapper's automatic mapping
     */
	private PurchaseDto ConvertToPurchaseDto(Purchase purchase) {
		PurchaseDto purchaseDto= this.modelMapper.map(purchase, PurchaseDto.class);
		purchaseDto.setInsuranceName(purchase.getInsurance().getName());
		purchaseDto.setInsuranceType(purchase.getInsurance().getType());
		purchaseDto.setCoverage(purchase.getInsurance().getCoverage());
		purchaseDto.setPremium(purchase.getInsurance().getPremium());
		purchaseDto.setPayment(purchase.getPrice());
		return purchaseDto;
	}

}
