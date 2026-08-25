package Day2.SchoolManagement;

import java.util.HashSet;

public class Classroom {
    String className;
    HashSet<Student> set;

    Classroom(String _className) {
        className = _className;
        set = new HashSet<>();
    }

    public void addStudent(Student student) {
        set.add(student);
    }
}
