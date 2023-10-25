package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.exceptions.PatientNotFoundException;
import com.cetpa.models.Doctor;
import com.cetpa.models.Patient;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.repositories.PatientRepository;
import com.cetpa.services.PatientService;
import com.cetpa.utility.Symptom;

@Service
public class PatientServiceImpl implements PatientService 
{
	@Autowired private PatientRepository patientRepository;
	@Autowired private DoctorRepository doctorRepository;
	
	public void savePatient(Patient patient) 
	{
		patientRepository.save(patient);
	}
	public List<Doctor> getList(int pid) 
	{
		Patient patient=patientRepository.findById(pid).orElseThrow(()->new PatientNotFoundException("Patient with id "+pid+" does not exist"));
		String city=patient.getCity();
		if(!city.equals("Noida") && !city.equals("Delhi") && !city.equals("Faridabad"))
		{
			throw new RuntimeException("We are still waiting to expand to your location");
		}
		String symptom=patient.getSymptom();
		String speciality=Symptom.map.get(symptom);
		List<Doctor> dlist=doctorRepository.findDoctorList(city,speciality);
		if(dlist.isEmpty())
		{
			throw new RuntimeException("There isn’t any doctor present at your location for your symptom");	
		}
		return dlist;
	}
}
