package com.jwt.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Exams;
import com.jwt.model.Student;

@Repository
public class ExamDAOImpl implements ExamDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addExam(Exams exam) {
		sessionFactory.getCurrentSession().saveOrUpdate(exam);
		
	}

	@Override
	public Exams updateExam(Exams exam) {
		sessionFactory.getCurrentSession().update(exam);
		return exam;
	}

	@Override
	public void deleteExam(Integer examid) {
		Student ex = (Student) sessionFactory.getCurrentSession().load(
				Exams.class, examid);
		if (null != ex) {
			this.sessionFactory.getCurrentSession().delete(ex);
		}
	}

}
