package org.frei.springboot.students.university.visit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.frei.springboot.students.university.model.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Entity
@Table(name = "visits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit extends BaseEntity {

    @Column(name = "visit_date")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @Column(name = "student_id")
    private Integer studentId;

}
