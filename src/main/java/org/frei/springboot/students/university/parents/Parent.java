package org.frei.springboot.students.university.parents;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.frei.springboot.students.university.model.Person;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;


@Entity
@Table(name = "parents")
public class Parent extends Person {

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column (name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private Set<Student> students;

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    protected Set<Student> getStudentsInternal() {
        if (this.students == null) {
            this.students = new HashSet<>();
        }
        return this.students;
    }

    protected void setStudentsInternal(Set<Student> students) {
        this.students = students;
    }

    public List<Student> getStudent() {
        List<Student> sortedStudents = new ArrayList<>(getStudentsInternal());
        PropertyComparator.sort(sortedStudents,
                new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedStudents);
    }

    public void addStudent(Student student) {
        if (student.isNew()) {
            getStudentsInternal().add(student);
        }
        student.setParent(this);
    }

    /**
     * Return the Student with the given name, or null if none found for this Parent.
     *
     * @param name to test
     * @return true if student name is already in use
     */
    public Student getStudent(String name) {
        return getStudent(name, false);
    }

    /**
     * Return the Student with the given name, or null if none found for this Student.
     *
     * @param name to test
     * @return true if student name is already in use
     */
    public Student getStudent(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Student student : getStudentsInternal()) {
            if (!ignoreNew || !student.isNew()) {
                String compName = student.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)

                .append("id", this.getId()).append("new", this.isNew())
                .append("lastName", this.getLastName())
                .append("firstName", this.getFirstName()).append("address", this.address)
                .append("city", this.city).append("telephone", this.telephone).toString();
    }
}