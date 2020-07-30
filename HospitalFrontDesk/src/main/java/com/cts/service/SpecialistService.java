package com.cts.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Specialist;
import com.cts.repository.SpecialistRepository;
@Service
@Transactional
public class SpecialistService {
	@Autowired
	SpecialistRepository repository;
	
	public List<Specialist> getAlldetails(){
		return (List<Specialist>) repository.findAll();
	}
	
	public Specialist createspecilaistdetails(Specialist specialistDetails) {
		return repository.save(specialistDetails);
	}
	
	public List<Specialist> getSpecialistDetails(String hname,String type){
		return repository.findSpecDetails(hname,type);
	}
	public List<Specialist> IsSpecialistAvailable(String type,String availabletime,String availableday){
		return repository.getDetails(type,availabletime,availableday);
	}
}
