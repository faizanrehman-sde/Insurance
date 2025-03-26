package com.asus.Insurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.asus.Insurance.Entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
