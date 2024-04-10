package com.pharmacyservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacyservice.model.Pharmacy;


@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String>{
	
}
