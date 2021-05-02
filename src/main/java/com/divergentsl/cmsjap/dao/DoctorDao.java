package com.divergentsl.cmsjap.dao;

import java.util.List;

import com.divergentsl.cmsjap.entity.Doctor;

public interface DoctorDao {
	
	void add(Doctor doctor);

	public List<Doctor> listAll();
	
	void remove(Doctor doctor);
	
	void update(Doctor doctor);

	Doctor searchById(int id);
}
