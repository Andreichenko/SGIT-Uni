package org.frei.springboot.students.university.parents;


import org.frei.springboot.students.university.model.NamedEntity;
import org.frei.springboot.students.university.visit.Visit;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "birth_date")
    private Date birthDay;

    @ManyToOne
    private StudentType studentType;


    private Parent parent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.EAGER)
    private Set<Visit> visits = new LinkedHashSet<>();


    public void isNew(){

    }
}
