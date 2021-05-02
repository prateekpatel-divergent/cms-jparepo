package com.divergentsl.cmsjap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergentsl.cmsjap.entity.Doctor;
import com.divergentsl.cmsjap.entity.Patient;

@Repository
public class DoctorDaoImpl implements DoctorDao{

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void add(Doctor doctor) {
		em.persist(doctor);
	}

	@Override
	public List<Doctor> listAll() {
		CriteriaQuery<Doctor> criteriaQuery = em.getCriteriaBuilder().createQuery(Doctor.class);
		@SuppressWarnings("unused")
		Root<Patient> root = criteriaQuery.from(Patient.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void remove(Doctor doctor) {
		em.remove(doctor);
	}

	@Override
	public void update(Doctor doctor) {
		em.persist(doctor);
	}

	@Override
	public Doctor searchById(int id) {
		return em.find(Doctor.class, id);
	}

}
