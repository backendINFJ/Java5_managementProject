public class Subject {
    private String subjectId;
    private SubjectList subjectList;

    // SubjectList 타입, SubjectType을 받음
    public Subject(String seq, SubjectList subjectList) {
        this.subjectId = seq;
        this.subjectList = subjectList;

    }

    // Getter
    public String getSubjectId() {
        return subjectId;
    }

    public SubjectList getSubjectList() {
        return subjectList;
    }



}
