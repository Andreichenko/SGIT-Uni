package org.frei.springboot.students.university.components;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TeacherController {

   private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository studentRep) {
        this.teacherRepository = studentRep;
    }

    @GetMapping("/students.html")
    public Teachers showStudentList(Map<String, Object> model){
        Teachers students = new Teachers();
        students.getStudents().addAll(this.teacherRepository.findAll());
        return students;
    }
    @GetMapping({"/students.json", "/students.xml"})
    public @ResponseBody
    Teachers showResourcesStudentList(){
        Teachers students = new Teachers();
        students.getStudents().addAll(this.teacherRepository.findAll());
        return students;
    }
}
