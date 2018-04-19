package org.frei.springboot.students.university.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NamedEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

}
