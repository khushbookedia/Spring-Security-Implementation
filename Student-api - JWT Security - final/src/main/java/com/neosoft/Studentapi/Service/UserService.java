package com.neosoft.Studentapi.Service;

import com.neosoft.Studentapi.Entity.Student;

import java.util.List;


public interface UserService {
    public Student getStudent(int studentId);

    public Student registerStudent(Student student);

    public List<Student> getAllStudents();
}
