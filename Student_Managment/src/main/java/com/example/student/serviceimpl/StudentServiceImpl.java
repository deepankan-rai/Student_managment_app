package com.example.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepo;
import com.example.student.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		
		Student std=studentRepo.save(student);
		
		return std;
	}

	@Override
	public String removeStudent(int id) {
		// TODO Auto-generated method stub
		
		studentRepo.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public Optional<Student> findStudById(int id) {
		// TODO Auto-generated method stub
		
		Optional<Student> std =studentRepo.findById(id);
		if(std.isPresent()) {
			return std;
		}
		else {
			
		
		return null;
		}
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		
		List<Student>stdList=studentRepo.findAll();
		return stdList;
	}

	@Override
	public String updateStudent(int id) {
		// TODO Auto-generated method stub
		
		Optional<Student> std=studentRepo.findById(id);
		if(std.isPresent()) {
			Student stds=new Student();
			studentRepo.save(stds);
			return "updated successfully";
		}
		else {
			return "employee not found";
		}
		
	}

}
