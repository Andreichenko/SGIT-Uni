package org.frei.springboot.students.university.parents;


import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

public class StudentValidator implements Validator{


    public static final String REQUIRED = "required";


    @Override
    public void validate(Object obj, Errors errors) {
        Student student = (Student) obj;
        String name = student.getName();
        // name validation
        if (!StringUtils.hasLength(name)) {
            errors.rejectValue("name", REQUIRED, REQUIRED);
        }

        // type validation
        if (student.isNew() && student.getStudentType() == null) {
            errors.rejectValue("type", REQUIRED, REQUIRED);
        }

        // birth date validation
        if (student.getBirthDate() == null) {
            errors.rejectValue("birthDate", REQUIRED, REQUIRED);
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.isAssignableFrom(aClass);
    }
}
