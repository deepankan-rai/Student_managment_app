package com.example.student.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;

import com.example.student.serviceimpl.StudentServiceImpl;

@RestController
@RequestMapping("/std")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl stdServiceImpl;
	
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to student managment";
	}
	
	
	@PostMapping("/addStd")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student std=stdServiceImpl.addStudent(student);
		return new ResponseEntity<Student>(std,HttpStatus.CREATED);
		
		
	}
	
	@DeleteMapping("/removeStd{id}")
	public ResponseEntity<String> removeStudent(@PathVariable int id){
		stdServiceImpl.removeStudent(id);
		
		return new ResponseEntity<String>("Remove Successfully",HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/Stdid{id}")
	public ResponseEntity<Optional<Student>> findStdById(@PathVariable int id){
		Optional<Student> stds=stdServiceImpl.findStudById(id);
		return new ResponseEntity<Optional<Student>>(stds,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/allStd")
	public ResponseEntity<List<Student>> getAllStd(){
		List<Student> stud=stdServiceImpl.getAllStudent();
		return new ResponseEntity<List<Student>>(stud,HttpStatus.OK);
	}
	
	@PutMapping("/updateStd{id}")
	public ResponseEntity<String> updateStud(@PathVariable int id){
		stdServiceImpl.updateStudent(id);
		return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
	}
	
}
