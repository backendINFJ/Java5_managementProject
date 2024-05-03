public class Student {
    private String studentId;

    private  String studentName;


    // Student 기본생성자
    public Student( String studentName, String studentId) {
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



    //Setter

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
