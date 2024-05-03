import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ManagementMain {

    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;


    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";








    // index 필드
    //3필드의 인덱스가 각각 있을 필요가 있을까??
    //학생이 하나 생성되면 그 인덱스로 다같이 사용하면 되지않을까??
    //학생이 없이 점수, 과목만 있는 상황을 예방할 수 있지 않을까??

    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";


    public static void main(String[] args) {


    }
}