package SpringData_example;

import SpringData_example.entities.Major;
import SpringData_example.entities.Student;
import SpringData_example.services.MajorService;
import SpringData_example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private StudentService studentService;

    private MajorService majorService;

    @Autowired
    public ConsoleRunner(StudentService studentService, MajorService majorService) {
        this.studentService = studentService;
        this.majorService = majorService;
    }

    public MajorService getMajorService() {
        return majorService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    @Override
    public void run(String... strings) throws Exception {
        Major major = new Major("Java DB Fundamentals");
        Student student = new Student("John",new Date(), major);
        majorService.create(major);
        studentService.register(student);
    }
}
