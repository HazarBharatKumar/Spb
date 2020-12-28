package org.arpit.java2blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.arpit.java2blog.dao.PatientDao;
import org.arpit.java2blog.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("patientService")
public class PatientService {

	@Autowired
	PatientDao patientDao;

	@Transactional
	public List<Patient> getAllPatients() {
		return patientDao.getAllPatients();
	}

	@Transactional
	public Patient getPatient(int id) {
		return patientDao.getPatient(id);
	}

	@Transactional
	public void addPatient(Patient patient) {
		
		patientDao.addPatient(patient);
	}
	

	@Transactional
	public void updatePatient(Patient patient) {
		patientDao.updatePatient(patient);

	}

	@Transactional
	public void deletePatient(int id) {
		patientDao.deletePatient(id);
	}
}

