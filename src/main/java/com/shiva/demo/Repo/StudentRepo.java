package com.shiva.demo.Repo;

import com.shiva.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;   // <-- correct import

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void save() {
    }

    public void save(Student s1) { // save or update,delete fetch data through jdbc
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
        String sql = "SELECT * FROM Student";
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setMarks(rs.getInt("marks"));
                s.setName(rs.getString("name"));
                s.setRollNo(rs.getInt("RollNo"));

                return s;
            }
        };
        return jdbc.query(sql,mapper);
    }
}
