package com.doctorservice.util;

import java.util.ArrayList;
import java.util.List;

import com.doctorservice.model.Doctor;
import com.doctorservice.model.DoctorWrapper;


public class DoctorUtil {

	public static List<DoctorWrapper> convertDoctorListToDoctorWrapperList(List<Doctor> doctors){
		
		List<DoctorWrapper> newList = new ArrayList<>();
		
		for(Doctor d : doctors) {
			newList.add(convertDoctorToDoctorWrapper(d));
		}
		return newList;
	}
	
	public static DoctorWrapper convertDoctorToDoctorWrapper(Doctor d) {
		return new DoctorWrapper(
				d.getDoctorId(),
				d.getName(),
				d.getPhoneNumber(),
				d.getEmail(),
				d.getSpecialization(),
				d.getClinicLocation()
		);
	}
}
