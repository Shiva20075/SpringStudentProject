package com.shiva.demo.service;

import com.shiva.demo.Repo.StudentRepo;
import com.shiva.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public StudentRepo getStRepo() {
        return Repo;
    }

    public void setStRepo(StudentRepo stRepo) {
        this.Repo = stRepo;
    }
    @Autowired
    private StudentRepo Repo;
    public void addStudent(Student s1) {
        Repo.save(s1);
    }

    public List<Student> getStudents() {
        return Repo.findAll();

    }
}
