package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.StudentInfo;
import com.example.repository.FrogRepositoryDef;
import com.jaycon.repository.JayconRepositoryDef;

@Service("ProjectFrogService")
public class ProjectFrogImpl implements ProjectFrogDef {
   
	@Autowired
	FrogRepositoryDef orderrepository;
	
	 public StudentInfo addStudentInfo(StudentInfo a)
	 	{
		  StudentInfo a=new StudentInfo();
		  return a;
 	     }
	 public List<StudentInfo> getStudentInfoById(String Id)
	    {
		    StudentInfo a=new StudentInfo();
		    List<StudentInfo> b=new ArrayList<StudentInfo>();
		    b.add(a);
		    return b;
	    }
	 public List<StudentInfo> getStudentInfoByClass(String className)
	    {
		 	StudentInfo a=new StudentInfo();
		    List<StudentInfo> b=new ArrayList<StudentInfo>();
		    b.add(a);
		    return b;
	    }
	 public List<StudentInfo> getStudentInfoByName(String student)
	    {
		 	StudentInfo a=new StudentInfo();
		    List<StudentInfo> b=new ArrayList<StudentInfo>();
		    b.add(a);
		    return b;
	    }
}
