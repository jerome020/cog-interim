package com.doctorservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DoctorWrapper {
	private int doctorId;
	private String name;
	private String phoneNumber;
	private String email;
	private String specialization;
	private String clinicLocation;
}
