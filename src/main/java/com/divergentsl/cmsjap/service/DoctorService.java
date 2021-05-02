package com.divergentsl.cmsjap.service;

import java.util.List;

import com.divergentsl.cmsjap.entity.Doctor;

public interface DoctorService {
	
	public void add(String name, String speciality, String contactno, int fee, String degree);

	public boolean remove(int id);

	public Doctor searchById(int id);
	
	public List<Doctor> listAll();
}
