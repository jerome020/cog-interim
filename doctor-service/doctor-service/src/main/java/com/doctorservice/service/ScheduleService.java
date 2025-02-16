package com.doctorservice.service;

import java.util.List;

import com.doctorservice.model.MedicalRepresentative;
import com.doctorservice.model.Schedule;
import com.doctorservice.model.ScheduleWrapper;


public interface ScheduleService {
	
	/**
	 * Returns all the schedules for a particular {@link Doctor}
	 * based on doctorId
	 * 
	 * @param doctorId must not be {@literal null}
	 * @return list of {@link ScheduleWrapper}
	 */
	public List<ScheduleWrapper> getScheduleByDoctorId(int doctorId);
	
	/**
	 * Insert new {@link Schedule} into the database
	 * 
	 * @param schedule must not be {@literal null}
	 * @return {@link Schedule} entity
	 */
	public Schedule addSchedule(Schedule schedule);
	
	/**
	 * Returns all the schedules for a particular date
	 * 
	 * @param date must not be {@literal null}
	 * @return list of {@link ScheduleWrapper}
	 */
	public List<ScheduleWrapper> getScheduleByDate(String date);
	
	/**
	 * Returns all the schedules for a particular {@link MedicalRepresentative}
	 * based on id
	 * 
	 * @param mrId must not be {@literal null}
	 * @return list of {@link ScheduleWrapper}
	 */
	public List<ScheduleWrapper> getScheduleByMrId(Integer mrId);

}
