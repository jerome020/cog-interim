package com.pharmacyservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pharmacyservice.model.MedicineStockDto;
import com.pharmacyservice.response.ApiResponse;


@FeignClient("MEDICINE-SERVICE")
public interface MedicineFeignClient {
	
	@GetMapping("/medicine/health")
	public String health();
	
	@PutMapping("/medicine/updateStock")
	public ResponseEntity<ApiResponse> updateStock(@RequestBody MedicineStockDto medDto);
}
