package com.doctorservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctorservice.model.MedicalRepresentative;

@Repository
public interface MrRepository extends JpaRepository<MedicalRepresentative, Integer> {
	
	Optional<MedicalRepresentative> findByEmail(String email);

	List<MedicalRepresentative> findAllByWorkLocation(String workLocation);
}
