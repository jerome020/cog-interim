package com.doctorservice.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorservice.feign.MedicineFeignClient;
import com.doctorservice.model.Schedule;
import com.doctorservice.model.ScheduleWrapper;
import com.doctorservice.repository.ScheduleRepository;
import com.doctorservice.service.ScheduleService;
import com.doctorservice.util.ScheduleUtil;


@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleRepository scRepo;
	
	@Autowired
	private MedicineFeignClient medFeignClient;
	
	@Override
	public List<ScheduleWrapper> getScheduleByDoctorId(int doctorId) {
		List<Schedule> schedules = scRepo.findAllByDoctorDoctorId(doctorId);
		Map<String, String> medicineNames = 
				ScheduleUtil.extractMedicineNamesFromSchedule(schedules, medFeignClient);
		List<ScheduleWrapper> response = 
				ScheduleUtil.convertScheduleListToScheduleWrapperList(schedules, medicineNames);
		return response;
	}
	
	@Override
	public Schedule addSchedule(Schedule schedule) {
		return scRepo.save(schedule);
	}
	
	@Override
	public List<ScheduleWrapper> getScheduleByDate(String dateStr) {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		List<Schedule> schedules = scRepo.findAllByDate(date);
		Map<String, String> medicineNames = 
				ScheduleUtil.extractMedicineNamesFromSchedule(schedules, medFeignClient);
		List<ScheduleWrapper> response = 
				ScheduleUtil.convertScheduleListToScheduleWrapperList(schedules, medicineNames);
		return response;
	}
	
	@Override
	public List<ScheduleWrapper> getScheduleByMrId(Integer mrId) {
		List<Schedule> schedules = scRepo.findAllByMrMrId(mrId);
		Map<String, String> medicineNames = 
				ScheduleUtil.extractMedicineNamesFromSchedule(schedules, medFeignClient);
		List<ScheduleWrapper> response = 
				ScheduleUtil.convertScheduleListToScheduleWrapperList(schedules, medicineNames);
		return response;
	}

}
