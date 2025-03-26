package com.asus.Insurance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.asus.Insurance.Entity.Insurance;
import com.asus.Insurance.enums.Type;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
	
	List<Insurance> findByGender(Type gender);
	
	@Query("SELECT i FROM Insurance i WHERE :age BETWEEN i.minAge AND i.maxAge")
	List<Insurance> findInsuranceByAge(@Param("age") String age);

}
