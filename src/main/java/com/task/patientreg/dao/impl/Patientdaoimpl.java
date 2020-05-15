package com.task.patientreg.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;

import com.task.patientreg.dao.PatientDao;
import com.task.patientreg.dao.entity.PatientEntity;
import com.task.patientreg.dto.Patientdto;
import com.task.patientreg.hibernate.utils.HibernateUtils;


public class Patientdaoimpl implements PatientDao{
	
	Session session;

	@Override
	public void openConnection() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		session= sessionFactory.openSession();
		
	}

	@Override
	public Patientdto getPatientById(String patientId) {
		//test jenkins auto build
		// TODO Auto-generated method stub
		Patientdto patientdto = null;
		
		long patId = Long.parseLong(patientId);
		
		CriteriaBuilder crb= session.getCriteriaBuilder();
		
		CriteriaQuery<PatientEntity> cquery= crb.createQuery(PatientEntity.class);
		
		Root<PatientEntity> root= cquery.from(PatientEntity.class);
		
		cquery.select(root);
		
		cquery.where(crb.equal(root.get("id"), patId));
		
		Query<PatientEntity> query= session.createQuery(cquery);
		
		PatientEntity patientEntity = query.uniqueResult();
		
		if(patientEntity!=null) {
			patientdto = new Patientdto();
			BeanUtils.copyProperties(patientEntity, patientdto);
		}
		
		return patientdto;
		
	}

	
	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		if(session!=null)
			session.close();
	}

	@Override
	public Patientdto savePatient(Patientdto patientdto) {
		// TODO Auto-generated method stub
		Patientdto savedPatient=null;
		PatientEntity patientEntity= new PatientEntity();
		
		BeanUtils.copyProperties(patientdto, patientEntity);
		 
		openConnection();
		session.beginTransaction();
		session.save(patientEntity);
		session.getTransaction().commit();
		closeConnection();
		
		savedPatient= new Patientdto();
		BeanUtils.copyProperties(patientEntity, savedPatient);
		
		return savedPatient;
	
	}

}
