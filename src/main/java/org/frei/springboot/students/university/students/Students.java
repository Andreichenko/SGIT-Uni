package org.frei.springboot.students.university.students;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Students {

    private List<Student> students;

    @XmlElement
    public List<Student> getStudents() {
        if (students == null){
            students = new ArrayList<>();
        }

        return students;
    }
}
