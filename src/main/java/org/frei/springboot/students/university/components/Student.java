package org.frei.springboot.students.university.components;

import org.frei.springboot.students.university.model.Person;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import java.util.*;


@Entity
@Table(name = "students")
public class Student extends Person{

    @JoinTable(name = "student_teachers",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teachers> teachers;

    protected Set<Teachers> getTeachersInternal() {
        if (this.teachers == null) {
            this.teachers = new HashSet<>();
        }
        return this.teachers;
    }
// todo Entiity Student????

    protected void setTeachersInternal(Set<Teachers> teachers){
        this.teachers = teachers;
    }

    @XmlElement
    public List<Teachers> getTeachers(){
    List<Teachers> sortedTeach = new ArrayList<>(getTeachersInternal());
        PropertyComparator.sort(sortedTeach,
                new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedTeach);
    }

    public int getNrOfteachers(){
        return getTeachersInternal().size();
    }

    public void addTeacher(Teachers teachers){
        getTeachersInternal().add(teachers);
    }

}
