package org.frei.springboot.students.university.students;

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
    private Set<Teacher> teachers;

    protected Set<Teacher> getTeachersInternal() {
        if (this.teachers == null) {
            this.teachers = new HashSet<>();
        }
        return this.teachers;
    }


    protected void setTeachersInternal(Set<Teacher> teachers){
        this.teachers = teachers;
    }

    @XmlElement
    public List<Teacher> getTeachers(){
    List<Teacher> sortedTeach = new ArrayList<>(getTeachersInternal());
        PropertyComparator.sort(sortedTeach,
                new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedTeach);
    }

    public int getNrOfteachers(){
        return getTeachersInternal().size();
    }

    public void addTeacher(Teacher teacher){
        getTeachersInternal().add(teacher);
    }

}
