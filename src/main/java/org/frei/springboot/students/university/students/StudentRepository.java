package org.frei.springboot.students.university.students;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface StudentRepository{

    @Transactional(readOnly = true)
    @Cacheable("students")
    Collection<Student> findAll() throws DataAccessException;
}
