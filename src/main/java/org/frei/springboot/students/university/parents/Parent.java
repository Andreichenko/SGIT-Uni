package org.frei.springboot.students.university.parents;

import org.frei.springboot.students.university.model.Person;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity
@Table(name = "parents")
public class Parent extends Person {

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "adress")
    @NotEmpty
    private String adress;

    @Column (name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private Set<Student> students;


    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return this.adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Student getStudent(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Student student : getStudentInternal()) {
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
    public String toString() {   // ???? toString method actual ?
        return "Parent{" +
                "city='" + city + '\'' +
                ", adress='" + adress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", students=" + students +
                '}';
    }
}
