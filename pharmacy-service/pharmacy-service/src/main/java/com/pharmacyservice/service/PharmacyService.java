package com.pharmacyservice.service;

import java.util.List;

import com.pharmacyservice.model.Order;
import com.pharmacyservice.model.OrderWrapper;
import com.pharmacyservice.model.Pharmacy;
import com.pharmacyservice.model.PharmacyWrapper;
import com.pharmacyservice.model.Supply;


public interface PharmacyService {
	
	/**
	 * Returns all the {@link Pharmacy}(s) from the table
	 * 
	 * @return a list of {@link PharmacyWrapper}
	 */
	public List<PharmacyWrapper> getAllPharmacies();
	
	/**
	 * Returns the {@link Pharmacy} details based on the pharmacyId.
	 * 
	 * @param pharmaId must not be {@literal null}
	 * @return the {@link Pharmacy} details({@link PharmacyWrapper}) of type with the given id. 
	 * If the id is not found
	 *  then {@literal null} is returned.
	 */
	public PharmacyWrapper getPharmacyById(String pharmaId);
	
	/**
	 * Create new {@link Order} in the database.
	 * 
	 * @param order must not be {@literal null}
	 * @return {@literal true} if the order has been successfully created and 
	 * 			{@literal false} if order has not been created.
	 */
	public boolean placeOrder(Order order);
	
	/**
	 * Insert new {@link Pharmacy} details in the database and returns the same
	 * after insertion.
	 * 
	 * @param pharmacy must not be {@literal null}
	 * @return {@literal true} if the insertion is complete, 
	 * 			otherwise {@literal false}
	 */
	public boolean addPharmacy(Pharmacy pharmacy);
	
	/**
	 * Returns all {@link Order}(s) with specific information in the {@link OrderWrapper} format.
	 * 
	 * @return a list of type {@link OrderWrapper}.
	 */
	public List<OrderWrapper> getAllOrders();
	
	/**
	 * Retrieves all the {@link Order}(s) in the {@link OrderWrapper}
	 * format based on the parameter pharmaId
	 * 
	 * @param pharmaId must not be {@literal null}
	 * @return list of {@link OrderWrapper}
	 */
	public List<OrderWrapper> getAllOrdersByPharmaId(String pharmaId);
	
	/**
	 * Updates the {@link Pharmacy} in the database.
	 *
	 * @param pharmacy must not be {@literal null}
	 * @return true if the {@link Pharmacy} details is updated successfully.
	 * 			false if the {@link Pharmacy} is not found.
	 */
	public boolean updatePharmacy(Pharmacy pharmacy);
	
	/**
	 * Checks the medicine stock from MEDICINE-SERVICE
	 * and allot medicine accordingly.
	 * 
	 * @param supply must not be {@literal null}
	 * @return true if medicine allocation is successful
	 * 		   false otherwise.
	 */
	public boolean addSupply(Supply supply);
}
