package com.divergentsl.cmsjap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsjap.dao.LabTestDao;
import com.divergentsl.cmsjap.entity.LabTest;

@Service
public class LabTestServiceImpl implements LabTestService {

	@Autowired
	private LabTestDao labTestDao;

	@Transactional
	@Override
	public void add(String name, int rate, int patientId) {	
		
		LabTest labTest = new LabTest();
		
		labTest.setTest(name);
		labTest.setRate(rate);
		labTest.setPid(patientId);
		
		labTestDao.add(labTest);
		
	}

	@Transactional
	@Override
	public boolean remove(int id) {
		LabTest labTest = this.searchById(id);
		if (labTest != null) {
			this.labTestDao.remove(labTest);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public LabTest searchById(int id) {
		return labTestDao.searchById(id);
	}

	@Transactional
	@Override
	public List<LabTest> list() {
		return this.labTestDao.listAll();
	}
}
