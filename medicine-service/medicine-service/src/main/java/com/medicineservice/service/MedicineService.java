package com.medicineservice.service;

import java.util.List;

import com.medicineservice.model.Medicine;
import com.medicineservice.model.MedicineStockDto;


public interface MedicineService {
	
	/** Insert or update new entity({@link Medicine}) in the database
	 * 
	 * 	@param medicine must not be {@literal null}
	 *  @return the entity after inserting or updating. Entity will
	 *  never be {@literal null}. 
	 * */
	public Medicine insertOrUpdateMedicine(Medicine medicine);
	
	/**
	 *  Retrieves the {@link Medicine} details based on medicine id
	 *   
	 * 	@param medicineId must not be {@literal null}
	 *  @return the entity with the given id. If the id is not found
	 *  then {@literal null} is returned.
	 */
	public Medicine getMedicineById(String medicineId);
	
	/**
	 * Retrieves all the entities({@link Medicine}(s)) from the database.
	 * 
	 * @return a list of {@link Medicine}.
	 */
	public List<Medicine> getAllMedicines();
	
	/**
	 * Delete the particular {@link Medicine} from database
	 * based on the medicine id
	 * 
	 * @param medicineId must not be {@literal null}
	 */
	public void deleteMedicineById(String medicineId);
	
	/**
	 * Retrieves the list of {@link Medicine} names based on targetAilment
	 * 
	 * @param targetAilment must not be {@literal null}
	 * @return list of {@link Medicine} names
	 */
	public List<String> getMedicineByAilment(String targetAilment);
	
	/**
	 * Update the stock of the {@link Medicine} based on the medicine name.
	 * 
	 * @param medDto must not be {@literal null}
	 * @return 1 in case of successful update.
	 * 		   0 when the requested medDto.quantity > medicine.stockAmount
	 * 	       -1 if the medicine name is not found in the database.	
	 */
	public int updateStock(MedicineStockDto medDto);
	
	
}
