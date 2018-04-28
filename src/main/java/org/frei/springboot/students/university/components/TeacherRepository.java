package org.frei.springboot.students.university.components;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface TeacherRepository {

    @Transactional(readOnly = true)
    @Cacheable("students")
    Collection<Teacher> findAll() throws DataAccessException;
}
