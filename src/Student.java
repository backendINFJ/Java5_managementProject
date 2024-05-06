import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String studentId;
    private String studentName;
    private ArrayList<String> studentSubjectList = new ArrayList<>();
    private Map<String, int[]> studentScoreMap = new HashMap<>();

    // Student 기본생성자

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }
    // Getter

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

    //점수 setter
    public void setStudentScoreMap(Map<String, int[]> studentScoreMap) {
        this.studentScoreMap = studentScoreMap;
    }

    //점수 getter
    public Map<String, int[]> getStudentScoreMap() {
        return studentScoreMap;
    }
}


