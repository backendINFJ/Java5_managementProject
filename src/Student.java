import java.util.ArrayList;

public class Student {
    private String studentId;

    private String studentName;
    private ArrayList<String> studentSubjectList = new ArrayList<>();

    // Student 기본생성자
    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    // GEtter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public ArrayList<String> getStudentSubjectList() {
        return studentSubjectList;
    }
    //Setter

    public void setStudentSubjectList(ArrayList<String> studentSubjectList) {
        this.studentSubjectList = studentSubjectList;
    }
}


