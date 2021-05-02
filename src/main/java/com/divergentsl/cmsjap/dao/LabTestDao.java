package com.divergentsl.cmsjap.dao;

import java.util.List;

import com.divergentsl.cmsjap.entity.LabTest;


public interface LabTestDao {
	
	void add(LabTest labTest);

	public List<LabTest> listAll();
	
	void remove(LabTest labTest);
	
	void update(LabTest labTest);

	LabTest searchById(int id);
}
