package com.divergentsl.cmsjap.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsjap.dao.PatientDao;
import com.divergentsl.cmsjap.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Transactional
	@Override
	public void add(String name, int age, int weight, String gender, int contactNumber, String address) {	
		
		Patient patient = new Patient();
		
		patient.setName(name);
		patient.setAge(age);
		patient.setWeight(weight);
		patient.setGender(gender);
		patient.setContactNumber(contactNumber);
		patient.setAddress(address);
		
		patientDao.add(patient);
		
	}

	@Transactional
	@Override
	public boolean remove(int id) {
		Patient patient = this.searchById(id);
		if (patient != null) {
			this.patientDao.remove(patient);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public Patient searchById(int id) {
		return patientDao.searchById(id);
	}

	@Transactional
	@Override
	public List<Patient> list() {
		return this.patientDao.listAll();
	}
}
