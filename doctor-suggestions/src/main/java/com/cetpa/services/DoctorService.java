package com.cetpa.services;

import javax.validation.Valid;

import com.cetpa.models.Doctor;

public interface DoctorService  
{
	void saveDoctor(@Valid Doctor doctor);
	Doctor getDoctor(long did);
	void removeDoctor(long did);
}
