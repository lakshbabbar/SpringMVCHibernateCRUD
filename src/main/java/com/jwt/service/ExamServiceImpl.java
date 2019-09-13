package com.jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.dao.ExamDAO;
import com.jwt.dao.StudentDAO;
import com.jwt.model.Exams;
import com.jwt.model.Student;

@Service
@Transactional
public class ExamServiceImpl implements ExamService{

	@Autowired
	private ExamDAO examDAO;
	
	@Override
	@Transactional
	public void addExam(Exams exam) {
		examDAO.addExam(exam);
	}

	@Override
	public void deleteExam(Integer examId) {
		examDAO.deleteExam(examId);
		
	}

	@Override
	public Exams updateExam(Exams exam) {
		// TODO Auto-generated method stub
		return examDAO.updateExam(exam);
	}
}
