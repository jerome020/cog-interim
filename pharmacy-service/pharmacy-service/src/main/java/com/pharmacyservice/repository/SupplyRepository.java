package com.pharmacyservice.repository;

//import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pharmacyservice.model.Supply;


@Repository
public interface SupplyRepository extends JpaRepository<Supply, Integer>{

}
