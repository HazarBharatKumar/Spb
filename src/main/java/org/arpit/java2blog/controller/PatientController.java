package org.arpit.java2blog.controller;

import java.util.List;

import org.arpit.java2blog.model.Patient;
import org.arpit.java2blog.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
	
	@Autowired
	PatientService patientservice;
	@RequestMapping(value = "/getAllPatients", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getAllPatients(Model model) {

		List<Patient> listOfPatients = patientservice.getAllPatients();
		model.addAttribute("patient", new Patient());
		model.addAttribute("listOfPatients", listOfPatients);
		return "patientDetails";
	}

	@RequestMapping(value = "/Register", method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage() {
		return "redirect:/getAllPatients";
	}
	
	@RequestMapping(value = "/getPatient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Patient getPatientById(@PathVariable int id) {
		return patientservice.getPatient(id);
	}

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addPatient(@ModelAttribute("patient") Patient patient) {	
		if(patient.getId()==0)
		{
			
			patientservice.addPatient(patient);
		}
		else
		{	
			patientservice.updatePatient(patient);
		}

		return "redirect:/getAllPatients";
	}

	@RequestMapping(value = "/updatePatient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updatePatient(@PathVariable("id") int id,Model model) {
		model.addAttribute("patient", this.patientservice.getPatient(id));
		model.addAttribute("listOfPatients", this.patientservice.getAllPatients());
		return "patientDetails";
	}

	@RequestMapping(value = "/deletePatient/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deletePatient(@PathVariable("id") int id) {
		patientservice.deletePatient(id);
		return "redirect:/getAllPatients";

	}	
}
