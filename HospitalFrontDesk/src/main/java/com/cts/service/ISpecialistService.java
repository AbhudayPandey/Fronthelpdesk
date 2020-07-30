package com.cts.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.cts.model.Specialist;

public interface ISpecialistService {
	public List<Specialist> getAlldetails();
	public Specialist createspecilaistdetails(Specialist specialistDetails);
	public List<Specialist> getSpecialistDetails(String hname,String type);
	public List<Specialist> IsSpecialistAvailable(String type,String availabletime,String availableday);
}
