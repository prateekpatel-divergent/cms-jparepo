package com.divergentsl.cmsjap.dao;

import java.util.List;

import com.divergentsl.cmsjap.entity.Drug;

public interface DrugDao {

	void add(Drug drug);

	public List<Drug> listAll();
	
	void remove(Drug drug);
	
	void update(Drug drug);

	Drug searchById(int id);
}
