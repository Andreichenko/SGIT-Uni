package org.frei.springboot.students.university.components;

import org.frei.springboot.students.university.model.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "specials")
public class Specials extends NamedEntity implements Serializable{
}
