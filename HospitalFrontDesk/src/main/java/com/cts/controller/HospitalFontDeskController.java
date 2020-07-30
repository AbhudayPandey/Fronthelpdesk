package com.cts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Hospital;
import com.cts.model.Patient;
import com.cts.model.Specialist;
import com.cts.service.HospitalService;
import com.cts.service.PatientService;
import com.cts.service.SpecialistService;

@RestController
public class HospitalFontDeskController {
	
	Logger logger = LoggerFactory.getLogger(HospitalFontDeskController.class);
	
	//Specialist
	@Autowired
	SpecialistService service;
	
	// 1. Get all Specialist details
	@GetMapping("/Specialistdetails")
	public List<Specialist> getAlldetails() {
	    return service.getAlldetails();
	}
	
	// 2. Add new Specialist details
	@PostMapping("/AddSpecialistdetails")
	public Specialist createspecilaistdetails(@RequestBody Specialist specialistDetails) {
	    return service.createspecilaistdetails(specialistDetails);
	}
	
	// 3. Get Specialist details by Hospital Name and Specialist Type
	@GetMapping("/Specialistdetails/{hname}/{type}")
	public ResponseEntity<List<Specialist>> getDetails(@PathVariable String hname,@PathVariable String type){
		List<Specialist> getSpecDetails= service.getSpecialistDetails(hname, type);
		if (getSpecDetails.isEmpty()) {
			throw new RuntimeException("failed");
		} else {
			logger.info("Response:Successfully Excuted..");
		}
		return new ResponseEntity<List<Specialist>>(getSpecDetails, HttpStatus.OK);
	}
	
	// 4. Check Specialist Availability
	//@Cacheable(value="specialist", key= "{#root.methodName,#availabletime,availableday}")
	@GetMapping("/Specialistdetails/{type}/{availabletime}/{availableday}")
	public ResponseEntity<List<Specialist>> getDetails(@PathVariable String type,@PathVariable String availabletime,@PathVariable String availableday){
		List<Specialist> CheckAvailability= service.IsSpecialistAvailable(type,availabletime,availableday);
		if (CheckAvailability.isEmpty()) {
			throw new RuntimeException("failed");
		} else {
			logger.info("Response:Successfully Excuted..");
		}
		return new ResponseEntity<List<Specialist>>(CheckAvailability, HttpStatus.OK);
	}

	
	
	
	
	//Patient
	@Autowired
	PatientService patientservice;
	
	// 1. Get all Patient details
	@Cacheable(value ="patient", key="{#root,methodName}")
	@GetMapping("/PatientDetails")
	public List<Patient> getpatientAlldetails() {
	    return patientservice.getAlldetails();
	}
	
	// 2. Add new Patient details
	@PostMapping("/AddPatientDetails")
	public Patient createpatientdetails(@RequestBody Patient patientDetails) {
	    return patientservice.createpatientdetails(patientDetails);
	}
	@Autowired 
	PatientService ser;
	@GetMapping("/BookAppointment/{pname}")
	public ResponseEntity<List<Object>> getpatientDetails(@PathVariable String pname){
		List<Object> getpatientDetails= ser.Byname(pname);
		return new ResponseEntity<List<Object>>(getpatientDetails, HttpStatus.OK);
	}
		
	
	//Hospital
	@Autowired
	HospitalService hospitalservice;
	
	// 1. Get all Hospital details
	@GetMapping("/HospitalDetails")
	public List<Hospital> gethospitalAlldetails() {
	    return hospitalservice.getAlldetails();
	}
	
	// 2. Add new Hospital details
	@PostMapping("/AddHospitalDetails")
	public Hospital createhospitadetails(@RequestBody Hospital hospitalDetails) {
	    return hospitalservice.createhospitadetails(hospitalDetails);
	}
	@GetMapping("/hospital/{hospitalName}")
	public int getBeds(@PathVariable String hospitalName){
		return hospitalservice.getBedsByHospitalName(hospitalName);
	}
}
