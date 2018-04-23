package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.model.StudentInfo;

public class FrogRepositoryImpl implements FrogRepositoryDef{
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
