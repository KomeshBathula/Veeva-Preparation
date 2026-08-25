package Day2.SchoolManagement;

import java.util.HashMap;

public class SchoolManagement {
    
    private final Map<String, HashSet<Student>>
    public static void main(String[] args) {
        Student s1 = new Student("23a81a0509", "Komesh", "CSE");
        Student s2 = new Student("23a81a0510", "Phani", "CSE");
        Student s3 = new Student("23a81a0511", "balaji", "AIM");
        Student s4 = new Student("23a81a0512", "balu", "AIM");
        Student s5 = new Student("23a81a0513", "Komesh", "CSE");
        Student s6 = new Student("23a81a0514", "Komesh", "CSE");
        Student s7 = new Student("23a81a0515", "Komesh", "CSE");

        Classroom classroom = new Classroom("Machine Learning");
        classroom.addStudent(s1);
        classroom.addStudent(s2);
        classroom.addStudent(s3);
        classroom.addStudent(s4);
        classroom.addStudent(s4);

        Classroom classroom2 = new Classroom("DSA");
        classroom2.addStudent(s5);
        classroom2.addStudent(s6);
        classroom2.addStudent(s7);

        TotalStudentsForEachClass.getTotalStudents(classroom, classroom2);
    }
}
