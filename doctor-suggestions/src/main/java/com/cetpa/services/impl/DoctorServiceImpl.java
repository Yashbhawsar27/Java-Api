package com.cetpa.services.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.exceptions.DoctorNotFoundException;
import com.cetpa.models.Doctor;
import com.cetpa.repositories.DoctorRepository;
import com.cetpa.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService  
{
	@Autowired private DoctorRepository doctorRepository;

	public void saveDoctor(@Valid Doctor doctor) 
	{
		doctorRepository.save(doctor);
	}
	public Doctor getDoctor(long did) 
	{
		Doctor doctor=doctorRepository.findById(did).
				orElseThrow(()->new DoctorNotFoundException("Doctor with id "+did+" does not exist"));
		return doctor;
	}
	public void removeDoctor(long did) 
	{
		doctorRepository.deleteById(did);
	}
}
