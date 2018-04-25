package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.StudentInfo;
import com.example.repository.FrogRepositoryDef;


@Service("ProjectFrogService")
public class ProjectFrogImpl implements ProjectFrogDef {
   
	@Autowired
	FrogRepositoryDef orderrepository;
	
	 public StudentInfo addStudentInfo(StudentInfo a)
	 	{
		  return orderrepository.addStudentInfo(a);
		 }
	 
	 public List<StudentInfo> getStudentInfoById(long Id)
	    {
		    return orderrepository.getStudentInfoById(Id);
	    }
	 
	 public List<StudentInfo> getStudentInfoByClass(String className)
	    {
		   return orderrepository.getStudentInfoByClass(className);
	    }
	 
	 public List<StudentInfo> getStudentInfoByName(String student)
	    {
		 	return orderrepository.getStudentInfoByName(student);
	    }
	 public List<StudentInfo> getStudentInfoByLastName(String student)
	    {
		 	return orderrepository.getStudentInfoByLastName(student);
	    }
	 public List<StudentInfo> deleteById(String student)
	    {
		 	return orderrepository.deleteById(student);
	    }
	 public List<StudentInfo> updateByDetails(StudentInfo a)
	    {
		 	return orderrepository.updateByDetails(a);
	    }
}
