package com.pharmacyservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplyWrapper {
	private int supplyId;
	private String medicineName;
	private int quantity;
	private String date;
}
