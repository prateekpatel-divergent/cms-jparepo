package com.divergentsl.cmsjap.service;

import java.util.List;
import com.divergentsl.cmsjap.entity.Patient;

public interface PatientService {

	public void add(String name, int age, int weight, String gender, int contactNumber, String address);

	public boolean remove(int id);

	public Patient searchById(int id);
	
	public List<Patient> list();
}
