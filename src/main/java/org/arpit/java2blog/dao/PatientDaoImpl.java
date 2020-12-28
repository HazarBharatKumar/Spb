package org.arpit.java2blog.dao;

	import java.util.List;
	import org.arpit.java2blog.model.Patient;
	import org.hibernate.Hibernate;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

	@Repository
	public class PatientDaoImpl implements PatientDao{

		@Autowired
		private SessionFactory sessionFactory;

		public void setSessionFactory(SessionFactory sf) {
			this.sessionFactory = sf;
		}

		public List<Patient> getAllPatients() {
			Session session = this.sessionFactory.getCurrentSession();
			List<Patient>  patientList = session.createQuery("from Patient").list();
			return patientList;
		}

		public Patient getPatient(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Patient patient = (Patient) session.get(Patient.class, id);
			return patient;
		}

		public Patient addPatient(Patient patient) {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(patient);
			return patient;
		}

		public void updatePatient(Patient patient) {
			Session session = this.sessionFactory.getCurrentSession();
			Hibernate.initialize(patient);
			session.update(patient);
		}

		public void deletePatient(int id) {
			Session session = this.sessionFactory.getCurrentSession();
			Patient p = (Patient) session.load(Patient.class, new Integer(id));
			if (null != p) {
				session.delete(p);
			}
		} 
	}
