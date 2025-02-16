package com.medicineservice.service.impl;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicineservice.model.Medicine;
import com.medicineservice.model.MedicineStockDto;
import com.medicineservice.repository.MedicineRepository;
import com.medicineservice.service.MedicineService;


@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
	MedicineRepository medRepo;
	
	/** Insert or update new entity({@link Medicine} in the database
	 * 
	 * 	@param medicine must not be {@literal null}
	 *  @return the entity after inserting or updating. Entity will
	 *  never be {@literal null}. 
	 * */
	@Override
	public Medicine insertOrUpdateMedicine(Medicine medicine) {
		Medicine res = medRepo.save(medicine);
		return res;
	}
	
	/**
	 *  Retrieves the medicine details based on medicine id
	 *   
	 * 	@param medicineId must not be {@literal null}
	 *  @return the entity with the given id. If the id is not found
	 *  then {@literal null} is returned.
	 */
	@Override
	public Medicine getMedicineById(String medicineId) {
		Optional<Medicine> res = medRepo.findById(medicineId);
		return res.orElse(null);
	}
	
	/**
	 * Retrieves all the entities(medicines) from the database.
	 * 
	 * @return a list of Medicine.
	 */
	@Override
	public List<Medicine> getAllMedicines(){
		return medRepo.findAll();
	}
	
	/**
	 * Delete the particular medicine from database
	 * based on the medicine id
	 * 
	 * @param medicineId must not be {@literal null}
	 */
	@Override
	public void deleteMedicineById(String medicineId) {
		medRepo.deleteById(medicineId);
	}
	
	/**
	 * Retrieves the list of medicine names based on targetAilment
	 * 
	 * @param targetAilment must not be {@literal null}
	 * @return list of medicine names
	 */
	@Override
	public List<String> getMedicineByAilment(String targetAilment) {
		return medRepo.findByTargetAilment(targetAilment);
	}
	
	
	/**
	 * Update the stock of the medicine based on the medicine name.
	 * 
	 * @param medDto must not be {@literal null}
	 * @return 1 in case of successful update.
	 * 		   0 when the requested medDto.quantity > medicine.stockAmount
	 * 	       -1 if the medicine name is not found in the database.	
	 */
	@Override
	public int updateStock(MedicineStockDto medDto) {
		
		List<Medicine> allMedicines = medRepo.findAll();
		
		for(Medicine m : allMedicines) {
			
			if(medDto.getName().equals(m.getName())) {
				
				int stockAmount = m.getStockAmount();
				
				int quantity = medDto.getQuantity();
				if(quantity > stockAmount) 
					return 0;
				m.setStockAmount(stockAmount-quantity);
				medRepo.save(m);
				return 1;
			}
		}
		return -1;
	}
}
