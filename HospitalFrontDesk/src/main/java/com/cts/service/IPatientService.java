package com.cts.service;

import java.util.List;

import com.cts.model.Patient;

public interface IPatientService {
	public List<Patient> getAlldetails();
	public Patient createpatientdetails(Patient patientDetails);
	public List<Object> Byname(String pname);
}
