package org.frei.springboot.students.university.students;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class StudentController {

   private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRep) {
        this.studentRepository = studentRep;
    }

    @GetMapping("/students.html")
    public String showStudentList(Map<String, Object> model){
        Students students = new Students();
        students.getStudents().addAll(this.studentRepository.findAll());
        return students;
    }
}
