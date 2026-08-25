package Day2.SchoolManagement;

public class Student {
    String id;
    String name;
    String branch;

    public Student(String id, String name, String branch) {
        this.id = id;
        this.name = name;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+branch;
    }
}
