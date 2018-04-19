package org.frei.springboot.students.university.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

    private Integer id;
}
