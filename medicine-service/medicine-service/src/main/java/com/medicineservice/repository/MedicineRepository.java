package com.medicineservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicineservice.model.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, String> {
	
	/**
	 * Retrieves the list of medicine name from the database
	 * based on the targetAilment
	 * @param targetAilment must not be {@literal null}
	 * @return guaranteed to return not {@literal null} list of medicines.
	 * 			The list size can be zero based on the targetAilment.
	 */
	@Query("select m.name from Medicine m where m.targetAilment=?1")
	List<String> findByTargetAilment(String targetAilment);

}
