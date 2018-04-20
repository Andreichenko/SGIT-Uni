package org.frei.springboot.students.university.students;

import org.frei.springboot.students.university.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "teachers")
public class Teacher extends NamedEntity implements Serializable{
}
