package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Patient;

public interface PatientDao {

	public List<Patient> getAllPatients() ;

	public Patient getPatient(int id) ;

	public Patient addPatient(Patient patient);

	public void updatePatient(Patient patient) ;

	public void deletePatient(int id) ;
}
