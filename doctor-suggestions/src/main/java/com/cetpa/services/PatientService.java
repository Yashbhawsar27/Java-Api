package com.cetpa.services;

import java.util.List;

import com.cetpa.models.Doctor;
import com.cetpa.models.Patient;

public interface PatientService 
{
	void savePatient(Patient patient);
	List<Doctor> getList(int pid);
}
