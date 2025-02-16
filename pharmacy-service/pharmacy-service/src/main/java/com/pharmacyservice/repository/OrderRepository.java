package com.pharmacyservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacyservice.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	public List<Order> findAllByPharmacyPharmaId(String pharmaId);
}
