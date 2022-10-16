package SpringData_example.entities;

import java.util.Date;

public class Student {

    private String name;
    private Date date;
    private Major major;

    public Student(String name, Date date, Major major) {
        this.name = name;
        this.date = date;
        this.major = major;
    }
}
