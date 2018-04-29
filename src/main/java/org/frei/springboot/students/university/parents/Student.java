package org.frei.springboot.students.university.parents;


import org.frei.springboot.students.university.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student extends NamedEntity {

    private Date birthDay;
    private StudentType
}
