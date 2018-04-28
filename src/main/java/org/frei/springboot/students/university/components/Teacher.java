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
@Table(name = "teachers")
public class Teacher extends Person{

    @JoinTable(name = "teachers",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Specials> teachers;

    protected Set<Specials> getTeachersInternal() {
        if (this.teachers == null) {
            this.teachers = new HashSet<>();
        }
        return this.teachers;
    }


    protected void setTeachersInternal(Set<Specials> teachers){
        this.teachers = teachers;
    }

    @XmlElement
    public List<Specials> getTeachers(){
    List<Specials> sortedTeach = new ArrayList<>(getTeachersInternal());
        PropertyComparator.sort(sortedTeach,
                new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedTeach);
    }

    public int getNrOfteachers(){
        return getTeachersInternal().size();
    }

    public void addTeacher(Specials specials){
        getTeachersInternal().add(specials);
    }

}
