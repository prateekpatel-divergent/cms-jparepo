package com.divergentsl.cmsjap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergentsl.cmsjap.dao.DoctorDao;
import com.divergentsl.cmsjap.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorDao doctorDao;
	
	@Transactional
	@Override
	public void add(String name, String speciality, String contactno, int fee, String degree) {
		Doctor doctor = new Doctor();

		doctor.setName(name);
		doctor.setSpeciality(speciality);
		doctor.setContactno(contactno);
		doctor.setFee(fee);
		doctor.setDegree(degree);
		
		doctorDao.add(doctor);
	}

	@Transactional
	@Override
	public boolean remove(int id) {
		Doctor doctor = this.searchById(id);
		if (doctor != null) {
			this.doctorDao.remove(doctor);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public Doctor searchById(int id) {
		return doctorDao.searchById(id);
	}

	@Transactional
	@Override
	public List<Doctor> listAll() {
		return this.doctorDao.listAll();
	}

}
