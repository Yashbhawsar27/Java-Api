package com.cetpa.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.models.Doctor;
import com.cetpa.models.Patient;
import com.cetpa.services.PatientService;


@RestController
@RequestMapping("patient")
public class PatientController 
{
	@Autowired private PatientService patientService;
	
	@PostMapping("add")
	public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient)
	{
		patientService.savePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}
	@GetMapping("doctor-list")
	public ResponseEntity<List<Doctor>> getDoctorList(@RequestParam int pid)
	{
		List<Doctor> docList=patientService.getList(pid);
		return ResponseEntity.ok(docList);
	}
}
