package com.example.service;

import java.util.List;

import com.example.model.StudentInfo;

public interface ProjectFrogDef {
    public StudentInfo addStudentInfo(StudentInfo a);
    public List<StudentInfo> getStudentInfoById(String Id);
    public List<StudentInfo> getStudentInfoByClass(String className);
    public List<StudentInfo> getStudentInfoByName(String student);
}
