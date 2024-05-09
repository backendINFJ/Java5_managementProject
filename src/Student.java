import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Student {
    private String studentId;
    private String studentName;
    private String studentStatus;
    private ArrayList<String> studentSubjectList = new ArrayList<>();
    private Map<String, int[]> studentScoreMap = new HashMap<>();

    // Student 기본생성자

    public Student(String studentId, String studentName, String studentStatus) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentStatus = studentStatus;
    }
    // Getter

    public String getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    // 이름 Setter
    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    //상태 setter
    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }
    //상태 getter
    public String getStudentStatus() {
        return studentStatus;
    }

}
