package com.jwt.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Exams;
import com.jwt.model.Student;
import com.jwt.service.ExamService;

@Controller
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@RequestMapping(value = "/saveExam", method = RequestMethod.POST)
	public ModelAndView saveExam(@ModelAttribute Exams exam) {
		if (exam.getExamid() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			examService.addExam(exam);
		} else {
			examService.updateExam(exam);
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/newExam", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Exams exam = new Exams();
		model.addObject("exam", exam);
		model.setViewName("ExamForm");
		return model;
	}
	
}
