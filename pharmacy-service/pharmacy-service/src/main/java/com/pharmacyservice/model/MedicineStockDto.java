package com.pharmacyservice.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@Scope("prototype")
@NoArgsConstructor
@AllArgsConstructor
public class MedicineStockDto {
	private String name;
	private int quantity;
}

