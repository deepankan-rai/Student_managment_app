package com.example.student.service;

import java.util.List;
import java.util.Optional;

import com.example.student.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	
	public String removeStudent(int id);
	
	public Optional<Student> findStudById(int id);
	
	public List<Student> getAllStudent();
	
	public String updateStudent(int id);
}
