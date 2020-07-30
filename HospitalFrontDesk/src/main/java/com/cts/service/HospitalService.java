package com.cts.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Hospital;
import com.cts.repository.HospitalRepository;
import com.cts.repository.PatientRepository;
@Service
@Transactional
public class HospitalService {
	@Autowired
	HospitalRepository  repository;
	@Autowired
	PatientRepository prepository;
	public List<Hospital> getAlldetails(){
		return (List<Hospital>) repository.findAll();
	}
	
	public Hospital createhospitadetails(Hospital hospitalDetails) {
		return repository.save(hospitalDetails);
	}
	
	public int getBedsByHospitalName(String hospitalName) {
		Hospital hosp=repository.findBedsByHospitalName(hospitalName);
		List<String> list1 = getAllPatient(hosp.getHid()); //notdis
		for (String object : list1) {
			if(object.matches("discharged")) {
				hosp.setNumberofbeds(hosp.getNumberofbeds()+1);
			}
		}
		return hosp.getNumberofbeds();

	}

	private List<String> getAllPatient(int hid) {
		// TODO Auto-generated method stub
		return prepository.findAll(hid);
	}
}
