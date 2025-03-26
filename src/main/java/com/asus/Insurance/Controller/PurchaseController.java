package com.asus.Insurance.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asus.Insurance.Dto.PurchaseDto;
import com.asus.Insurance.Service.PurchaseService;


@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {
	
	  @Autowired
	  private PurchaseService purchaseService;
	  
	  /**
	     * Creates a purchase relationship between a user and an insurance.
	     * 
	     * @param userId Valid ID of an existing user account
	     * @param insuranceId Valid ID of an available insurance 
	     * @return Purchase confirmation(PurchaseDto) details with HTTP 200 status
	     * 
	     * @implNote 
	     * - Uses HTTP 200 (OK) instead of 201 (Created) because this endpoint 
	     *   associates existing resources rather than creating new ones
	     * - Ensure IDs correspond to valid entities (handled by service layer)
	     */
	  @PostMapping("/{userId}/{insuranceId}")
	  public ResponseEntity<PurchaseDto> purchaseInsurance( @PathVariable Long userId,
			                                                @PathVariable Long insuranceId ){
		  return new ResponseEntity<PurchaseDto>(this.purchaseService.purchaseInsurance(userId, insuranceId),HttpStatus.OK);
	  }

}
