package com.asus.Insurance;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.asus.Insurance.Dto.PurchaseDto;
import com.asus.Insurance.Entity.Insurance;
import com.asus.Insurance.Entity.Purchase;
import com.asus.Insurance.Repository.InsuranceRepository;
import com.asus.Insurance.Repository.PurchaseRepository;
import com.asus.Insurance.ServiceImp.PurchaseServiceImp;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PurchaseServiceImpTest {
	

 
	    @Mock
	     private ModelMapper modelMapper;       
	
	    @Mock
	    private InsuranceRepository insuranceRepo;

	    @Mock
	    private PurchaseRepository purchaseRepo;

	    @InjectMocks
	    private PurchaseServiceImp purchaseService;

	    private Insurance insurance;

	    @BeforeEach
	    void setup() {
	        // Mock Insurance Data
	        insurance = new Insurance();
	        insurance.setInsuranceId(1L);;
	        insurance.setName("Health Insurance");
	    }

	    /**  Test Case 1: Successfully purchase insurance */
	    @Test
	    void testPurchaseInsurance_Success() {
	        // Given: Insurance exists in DB
	        when(insuranceRepo.findById(1L)).thenReturn(Optional.of(insurance));
	        when(purchaseRepo.save(any(Purchase.class))).thenAnswer(invocation -> invocation.getArgument(0));

	        
	        // Mocking ModelMapper behavior
	        PurchaseDto mockDto = new PurchaseDto();
	        mockDto.setInsuranceName("Health Insurance");
	        mockDto.setPayment(insurance.getPrice());
	        mockDto.setStatus("Successfully purchased !!");
	        mockDto.setRecieptId("Tx-12345678");

	        when(modelMapper.map(any(Purchase.class), eq(PurchaseDto.class))).thenReturn(mockDto);
	        
	        
	        
	        
	        // When: Calling purchaseInsurance method
	        PurchaseDto result = purchaseService.purchaseInsurance(100L, 1L);
            
	        System.out.println("Test Passed! Purchase Receipt: " + result);

	        // Then: Verify values in response
	        assertNotNull(result);
	        assertEquals("Health Insurance", result.getInsuranceName());
	        assertEquals(insurance.getPrice(), result.getPayment());
	        assertEquals("Successfully purchased !!", result.getStatus());
	        assertTrue(result.getRecieptId().startsWith("Tx-"));

	        // Verify repository calls
	        verify(insuranceRepo, times(1)).findById(1L);
	        verify(purchaseRepo, times(1)).save(any(Purchase.class));
	    }

	    /**  Test Case 2: Insurance not found, should throw exception */
	    @Test
	    void testPurchaseInsurance_InsuranceNotFound() {
	        // Given: No insurance found
	        when(insuranceRepo.findById(2L)).thenReturn(Optional.empty());

	        // When & Then: Exception should be thrown
	        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
	            purchaseService.purchaseInsurance(100L, 2L);
	        });

	        assertEquals("Insurance not found with this Id", exception.getMessage());

	        // Verify repository calls
	        verify(insuranceRepo, times(1)).findById(2L);
	        verify(purchaseRepo, never()).save(any(Purchase.class));
	    }
	}



