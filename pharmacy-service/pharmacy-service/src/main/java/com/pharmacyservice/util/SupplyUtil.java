package com.pharmacyservice.util;

import java.util.ArrayList;
import java.util.List;

import com.pharmacyservice.model.Supply;
import com.pharmacyservice.model.SupplyWrapper;


public class SupplyUtil {
	
	/**
	 * Converts {@literal List<Supply>} to {@literal List<SupplyWrapper>}
	 * 
	 * @param list of type Supply
	 * @return list of type SupplyWrapper
	 */
	public static List<SupplyWrapper> convertSupplyListToSupplyWrapperList(List<Supply> list){
		List<SupplyWrapper> supplyList = new ArrayList<>();
		for(Supply s : list) {
			supplyList.add(new SupplyWrapper(
				s.getSupplyId(), s.getMedicineName(), s.getQuantity(), s.getDate()
				)
			);
		}
		
		return supplyList;
	}
}
