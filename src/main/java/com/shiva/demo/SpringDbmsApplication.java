package com.shiva.demo;

import com.shiva.demo.model.Student;
import com.shiva.demo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
public class SpringDbmsApplication {

	public static void main(String[] args) {

        ApplicationContext context =  SpringApplication.run(SpringDbmsApplication.class, args);
        Student s1 = context.getBean(Student.class);
        s1.setName("shiva");
        s1.setMarks(99);
        s1.setRollNo(44);

        StudentService service = context.getBean(StudentService.class);

        service.addStudent(s1);
        List<Student> student = service.getStudents();
        System.out.println(student);
	}
}
