package com.jwt.service;

import com.jwt.model.Exams;
import com.jwt.model.Student;

public interface ExamService {

	public void addExam(Exams exam);
	
	public void deleteExam(Integer examId);
	
	public Exams updateExam(Exams exam);
}
