package org.frei.springboot.students.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity{

    @Column(name = "first_name")
    @NotEmpty
    @NonNull
    private String firstName;

    @Column(name = "last-name")
    @NotEmpty
    @NonNull
    private String lastName;
}
