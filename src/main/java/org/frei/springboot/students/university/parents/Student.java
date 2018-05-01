package org.frei.springboot.students.university.parents;


import org.frei.springboot.students.university.model.NamedEntity;
import org.frei.springboot.students.university.visit.Visit;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "students")
public class Student extends NamedEntity {

    @ManyToOne
    @JoinColumn(name = "birth_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @ManyToOne
    @JoinColumn(name = "student_type")
    private StudentType studentType;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.EAGER)
    private Set<Visit> visits = new LinkedHashSet<>();

    public Date getBirthDay() {
        return this.birthDay;
    }

    public StudentType getStudentType() {
        return this.studentType;
    }

    public Parent getParent() {
        return this.parent;
    }

    protected Set<Visit> getVisitsInternal() {
        if (this.visits == null) {
            this.visits = new HashSet<>();
        }
        return this.visits;
    }

    protected void setVisitsInternal(Set<Visit> visits) {
        this.visits = visits;
    }

    public List<Visit> getVisits() {
        List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
        PropertyComparator.sort(sortedVisits,
                new MutableSortDefinition("date", false, false));
        return Collections.unmodifiableList(sortedVisits);
    }

    public void addVisit(Visit visit) {
        getVisitsInternal().add(visit);
        visit.setStudentId(this.getId());
    }
}
