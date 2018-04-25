package com.example.repository;

import java.util.List;

import com.example.model.StudentInfo;

public interface FrogRepositoryDef {
	    public StudentInfo addStudentInfo(StudentInfo a);
	    public List<StudentInfo> getStudentInfoById(long Id);
	    public List<StudentInfo> getStudentInfoByClass(String className);
	    public List<StudentInfo> getStudentInfoByName(String student);  
	    public List<StudentInfo> getStudentInfoByLastName(String student);
	    public List<StudentInfo> deleteById(String id);
	    public List<StudentInfo> updateByDetails(StudentInfo a);
}
