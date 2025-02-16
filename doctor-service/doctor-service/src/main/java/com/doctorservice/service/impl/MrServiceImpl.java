package com.doctorservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctorservice.model.MedicalRepresentative;
import com.doctorservice.model.MrWrapper;
import com.doctorservice.repository.MrRepository;
import com.doctorservice.service.MrService;
import com.doctorservice.util.MrUtil;

import jakarta.validation.Valid;


@Service
public class MrServiceImpl implements MrService {
	
	@Autowired
	private MrRepository mrRepo;
	
	@Override
	public MrWrapper createMr(MedicalRepresentative mr) {
		MedicalRepresentative newMr = mrRepo.save(mr);
		if(newMr == null) return null;
		return MrUtil.convertMedicalRepresentativeToMrWrapper(newMr);
	}
	
	@Override
	public MrWrapper getMrById(int id) {
		MedicalRepresentative mr = mrRepo.findById(id).orElse(null);
		if(mr == null) return null;
		return MrUtil.convertMedicalRepresentativeToMrWrapper(mr);
	}
	
	@Override
	public MrWrapper getMrByEmail(String email) {
		MedicalRepresentative mr = mrRepo.findByEmail(email).orElse(null);
		if(mr == null) return null;
		return MrUtil.convertMedicalRepresentativeToMrWrapper(mr);
	}
	
	@Override
	public List<MrWrapper> getAllMrs() {
		return MrUtil.convertMrListToMrWrapperList(mrRepo.findAll());
	}
	
	@Override
	public MrWrapper updateMr(@Valid MedicalRepresentative mr) {
		Optional<MedicalRepresentative> existingMr = mrRepo.findById(mr.getMrId());
		
		if(existingMr.isPresent()) {
			return MrUtil.convertMedicalRepresentativeToMrWrapper(mrRepo.save(mr));
		}
		return null;
	}
	
	@Override
	public List<MrWrapper> getAllMrsByLocation(String workLocation) {
		List<MedicalRepresentative> res = mrRepo.findAllByWorkLocation(workLocation);
		return MrUtil.convertMrListToMrWrapperList(res);
	}
}
