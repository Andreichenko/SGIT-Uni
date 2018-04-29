package org.frei.springboot.students.university.parents;

import org.frei.springboot.students.university.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class StudentType extends NamedEntity {
}
