package com.neosoft.Studentapi.Service;

import com.neosoft.Studentapi.Dao.StudentDao;
import com.neosoft.Studentapi.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    StudentDao studentDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Student getStudent(int studentId) {
        return studentDao.findById(studentId).get();
    }

    @Override
    @Transactional
    public Student registerStudent(Student student) {
        return studentDao.save(student);
    }

    public List<Student> getAllStudents(){
        return studentDao.findAll();
    }



}
