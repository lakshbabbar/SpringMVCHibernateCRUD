package com.jwt.dao;

import com.jwt.model.Exams;
import com.jwt.model.Student;

public interface ExamDAO {


	public void addExam(Exams exam);
	
	public Exams updateExam(Exams exam);
	
	public void deleteExam(Integer examid);
}
