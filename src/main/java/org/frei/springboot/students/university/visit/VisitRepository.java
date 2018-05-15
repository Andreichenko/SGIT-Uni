package org.frei.springboot.students.university.visit;


import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface VisitRepository extends Repository<Visit, Integer>{

    void save(Visit visit) throws DataAccessException;

    List<Visit> findByStudentId(Integer studentId);
}



// interface class
