public class Subject {
    private String subjectId;
    private SubjectList subjectList;
    private String subjectName; // 과목명
    private boolean isMandatory; // 필수과목 확인

    // SubjectList 타입, SubjectType을 받음
    public Subject(String seq, SubjectList subjectList) {
        this.subjectId = seq;
        this.subjectList = subjectList;
    }

    public Subject(String subjectName, boolean isMandatory) {
    }


    // Getter
    public String getSubjectId() {
        return subjectId;
    }

    public SubjectList getSubjectList() {
        return subjectList;
    }

    public Subject(String subjectId, String subjectName, boolean isMandatory) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.isMandatory = isMandatory;

    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }
}
