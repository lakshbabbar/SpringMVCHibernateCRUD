package com.jwt.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.criterion.Example;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.model.Exams;
import com.jwt.model.Student;
import com.jwt.service.StudentService;

@Controller
public class StudentController {

	private static final Logger logger = Logger.getLogger(StudentController.class);


	public StudentController() {
		logger.info("Testxyz");
		System.out.println("StudentController()");
	}
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/")
	public ModelAndView listStudent(ModelAndView model) throws IOException {
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":listStudent()"+"You are entering into");
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":listStudent()"+"Calling the student Service");
		List<Student> listStudent = studentService.getAllStudents();
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":listStudent()"+"Calling is completed and number"
				+ " of records is " + listStudent.size());
		model.addObject("listStudent", listStudent);
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":listStudent()"+"Redirecting to home");
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":newContact()"+"You are entering into");
		Student student = new Student();
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":newContact()"+"Adding Student");
		model.addObject("student", student);
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":newContact()"+"Redirecting to StudentForm");
		model.setViewName("StudentForm");
		return model;
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":saveStudent()"+"You are entering into");
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":saveStudent()"+"Calling the student Service");
		if (student.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			studentService.addStudent(student);
		} else {
			studentService.updateStudent(student);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest request) {
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":deleteStudent()"+"You are entering into");
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":deleteStudent()"+"Deleting Student");
		int studentId = Integer.parseInt(request.getParameter("id"));
		studentService.deleteStudent(studentId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {logger.debug("Debug:"+new Date()+":"+this.getClass()+":deleteStudent()"+"You are entering into");
	logger.debug("Debug:"+new Date()+":"+this.getClass()+":editStudent()"+"Entering into");
	logger.debug("Debug:"+new Date()+":"+this.getClass()+":editStudent()"+"Calling the student Service");
		int studentId = Integer.parseInt(request.getParameter("id"));
		logger.debug("Debug:"+new Date()+":"+this.getClass()+":editStudent()"+"Redirecting to StudentForm");
		Student student = studentService.getStudent(studentId);
		ModelAndView model = new ModelAndView("StudentForm");
		model.addObject("student", student);

		return model;
	}
	
	

}