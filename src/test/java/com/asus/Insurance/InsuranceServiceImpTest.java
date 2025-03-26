package com.asus.Insurance;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.asus.Insurance.Dto.InsuranceDto;
import com.asus.Insurance.Entity.Insurance;
import com.asus.Insurance.Repository.InsuranceRepository;
import com.asus.Insurance.ServiceImp.InsuranceServiceImp;
import com.asus.Insurance.enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class InsuranceServiceImpTest {

    @Mock
    private InsuranceRepository insuranceRepo;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private InsuranceServiceImp insuranceService;

    private Insurance insurance1;
    private Insurance insurance2;
    private InsuranceDto insuranceDto1;
    private InsuranceDto insuranceDto2;

    @BeforeEach
    void setUp() {
        // Sample Insurance Entities
        insurance1 = new Insurance(2L, "Plan B", "Life Insurance", "50", "20", "25", "60", Type.MALE, "100000");
        insurance2 = new Insurance(2L, "Plan B", "Life Insurance", "50", "20", "25", "60", Type.MALE, "100000");

        // Corresponding DTOs
        insuranceDto1 = new InsuranceDto(2L, "Plan B", "Life Insurance", "50", "20", "25", "60", Type.MALE, "100000");
        insuranceDto2 = new InsuranceDto(2L, "Plan B", "Life Insurance", "50", "20", "25", "60", Type.MALE, "100000");
    }

    // Test: Create Insurance
    @Test
    void testCreateInsurance() {
        when(modelMapper.map(insuranceDto1, Insurance.class)).thenReturn(insurance1);
        when(insuranceRepo.save(insurance1)).thenReturn(insurance1);
        when(modelMapper.map(insurance1, InsuranceDto.class)).thenReturn(insuranceDto1);

        InsuranceDto result = insuranceService.createInsurance(insuranceDto1);

        assertNotNull(result);
        assertEquals(insuranceDto1.getInsuranceId(), result.getInsuranceId());
        assertEquals(insuranceDto1.getName(), result.getName());

        verify(insuranceRepo, times(1)).save(insurance1);
    }

    //  Test: Get All Insurance
    @Test
    void testGetAllInsurance() {
        when(insuranceRepo.findAll()).thenReturn(Arrays.asList(insurance1, insurance2));
        when(modelMapper.map(insurance1, InsuranceDto.class)).thenReturn(insuranceDto1);
        when(modelMapper.map(insurance2, InsuranceDto.class)).thenReturn(insuranceDto2);

        List<InsuranceDto> result = insuranceService.getAllInsurance();

        assertEquals(2, result.size());
        verify(insuranceRepo, times(1)).findAll();
    }

    // Test: Get All Insurance by Gender (Valid Case)
    @Test
    void testGetAllInsuranceByGender_Valid() {
        when(insuranceRepo.findByGender(Type.MALE)).thenReturn(Arrays.asList(insurance1));
        when(modelMapper.map(insurance1, InsuranceDto.class)).thenReturn(insuranceDto1);

        List<InsuranceDto> result = insuranceService.getAllInsuranceByGender(Type.MALE);

        assertEquals(1, result.size());
        assertEquals(Type.MALE, result.get(0).getGender());

        verify(insuranceRepo, times(1)).findByGender(Type.MALE);
    }

    //  Test: Get All Insurance by Gender (No Results)
    @Test
    void testGetAllInsuranceByGender_NoResults() {
        when(insuranceRepo.findByGender(Type.MALE)).thenReturn(List.of());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            insuranceService.getAllInsuranceByGender(Type.MALE);
        });

        assertEquals("No insurance found with given gender", exception.getMessage());
        verify(insuranceRepo, times(1)).findByGender(Type.MALE);
    }

    //  Test: Get Insurance by Age (Valid Case)
    @Test
    void testGetAllInsuranceByAge_Valid() {
        when(insuranceRepo.findInsuranceByAge("25")).thenReturn(Arrays.asList(insurance2));
        when(modelMapper.map(insurance2, InsuranceDto.class)).thenReturn(insuranceDto2);

        List<InsuranceDto> result = insuranceService.getAllInsuranceByAge("25");

        assertEquals(1, result.size());
        assertEquals("Plan B", result.get(0).getName());

        verify(insuranceRepo, times(1)).findInsuranceByAge("25");
    }

    //  Test: Get Insurance by Age (No Results)
    @Test
    void testGetAllInsuranceByAge_NoResults() {
        when(insuranceRepo.findInsuranceByAge("25")).thenReturn(List.of());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            insuranceService.getAllInsuranceByAge("25");
        });

        assertEquals("No insurance found with this age", exception.getMessage());
        verify(insuranceRepo, times(1)).findInsuranceByAge("25");
    }
}
