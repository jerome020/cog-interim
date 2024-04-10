package com.medicineservice.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@Scope("prototype")
@NoArgsConstructor
public class MedicineStockDto {
	private String name;
	private int quantity;
}
