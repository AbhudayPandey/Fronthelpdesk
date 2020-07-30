package com.cts.service;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Patient;
import com.cts.model.Specialist;
import com.cts.repository.PatientRepository;

@Service
@Transactional
public class PatientService {
	@Autowired
	PatientRepository repository;
	
	public List<Patient> getAlldetails(){
		return (List<Patient>) repository.findAll();
	}
	
	public Patient createpatientdetails(Patient patientDetails) {
		return repository.save(patientDetails);
	}
	
	
	public List<Object> Byname(String pname){
		return repository.findByName(pname);
	}
}
