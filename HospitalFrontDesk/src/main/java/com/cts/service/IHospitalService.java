package com.cts.service;

import java.util.List;

import com.cts.model.Hospital;

public interface IHospitalService {
	public List<Hospital> getAlldetails();
	public Hospital createhospitadetails(Hospital hospitalDetails);
	public int getBedsByHospitalName(String hospitalName);
}
