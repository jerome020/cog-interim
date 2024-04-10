package com.medicineservice.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Component
@Entity
@Scope("prototype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Medicine {
	
	@Id
	private String medicineId;
	
	@NotBlank(message = "Name should not be blank")
	private String name;
	private String composition;
	
	@NotBlank(message = "Target ailment should not be blank")
	private String targetAilment;
	private int stockAmount;
	private String description;	
	
}
