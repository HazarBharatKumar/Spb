package org.arpit.java2blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
	@Entity
	@Table(name="PATIENT")
	public class Patient{

		@Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		int id;

		@Column(name="patientName")
		String patientName; 

		@Column(name="emailid")
		String emailid;
		
		@Column(name="city")
		String city;
		
		@Column(name="age")
		String age;
		
		@Column(name="gender")
		String gender;
		
		@Column(name="mobileno")
		long mobileno;
		
		public Patient() {
			super();
		}
		

		public Patient(int id, String patientName, String emailid, String city, String age, String gender, long mobileno) {
			super();
			this.id = id;
			this.patientName = patientName;
			this.emailid = emailid;
			this.city = city;
			this.age = age;
			this.gender = gender;
			this.mobileno = mobileno;
		
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPatientName() {
			return patientName;
		}

		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}

		public String getEmailid() {
			return emailid;
		}

		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}
		
		public long getMobileno() {
			return mobileno;
		}
		
		public void setMobileno(long mobileno) {
			this.mobileno = mobileno;
		}
		
}
