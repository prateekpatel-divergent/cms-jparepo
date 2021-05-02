package com.divergentsl.cmsjap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prescription")
public class PrescriptionAndNotes {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "prescription")
	private String prescription;
	
	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "doctor_Id", nullable = false)
	private Doctor doctorId;

	@ManyToOne
	@JoinColumn(name = "patient_Id")
	private Patient patientid;
}
