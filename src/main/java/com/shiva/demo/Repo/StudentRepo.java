package com.shiva.demo.Repo;

import com.shiva.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;   // <-- correct import

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void save() {
    }

    public void save(Student s1) {
        System.out.println("ADDED");
        String sql = "INSERT INTO STUDENT (RollNo,Name,Marks) values(?,?,?)" ;
        int rows = jdbc.update(sql, s1.getRollNo(), s1.getName(), s1.getMarks());
        System.out.println("ROWS " + rows);
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}
