package com.doctorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctorservice.model.Schedule;
import com.doctorservice.model.ScheduleWrapper;
import com.doctorservice.response.ApiResponse;
import com.doctorservice.service.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scService;
	
	@GetMapping("/health")
	public String checkHealth() {
		return "OK";
	}
	
	@GetMapping("/byDate/{date}")
	public ResponseEntity<?> getScheduleByDate(@PathVariable String date){
		return new ResponseEntity<List<ScheduleWrapper>>(
				scService.getScheduleByDate(date),
				HttpStatus.OK
			);
	}
	
	@GetMapping("/byDoctor/{doctorId}")
	public ResponseEntity<?> getScheduleByDoctorId(@PathVariable Integer doctorId){
		return new ResponseEntity<List<ScheduleWrapper>>(
				scService.getScheduleByDoctorId(doctorId),
				HttpStatus.OK
			);
	}
	
	@GetMapping("/byMr/{mrId}")
	public ResponseEntity<?> getScheduleByMrId(@PathVariable Integer mrId){
		return new ResponseEntity<List<ScheduleWrapper>>(
				scService.getScheduleByMrId(mrId),
				HttpStatus.OK
			);
	}
	
	@PostMapping("/addSchedule")
	public ResponseEntity<?> addSchedule(@RequestBody Schedule schedule){
		Schedule response = scService.addSchedule(schedule);
		if(response != null) {
			return new ResponseEntity<ApiResponse>(
					new ApiResponse(true, "Schedule added succesfully"),
					HttpStatus.CREATED
				);
		}
		return new ResponseEntity<ApiResponse>(
				new ApiResponse(false, "Error occurred!"),
				HttpStatus.BAD_GATEWAY
			);
	}
}
