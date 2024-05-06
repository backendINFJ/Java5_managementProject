package camp.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private List<Subject> studentSubjectStore;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
        this.studentSubjectStore = new ArrayList<>();
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentSubjectStore(Subject subject){
        studentSubjectStore.add(subject);
    }
}
