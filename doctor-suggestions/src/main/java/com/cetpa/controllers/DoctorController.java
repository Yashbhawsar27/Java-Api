package com.cetpa.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.models.Doctor;
import com.cetpa.services.DoctorService;

@RestController
@RequestMapping("doctor")
public class DoctorController 
{
	@Autowired private DoctorService doctorService;
	
	@PostMapping("add")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor)
	{
		doctorService.saveDoctor(doctor);
		return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
	}
	@DeleteMapping("delete")
	public ResponseEntity<Doctor> deleteDoctor(@RequestParam long did)
	{
		Doctor doctor=doctorService.getDoctor(did);
		doctorService.removeDoctor(did);
		return ResponseEntity.ok(doctor);
	}
}
