package org.frei.springboot.students.university.students;

import org.frei.springboot.students.university.model.Person;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Table(name = "students")
public class Student extends Person{

    private Set<Teacher> teachers;
}
