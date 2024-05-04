import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMethod {

     Scanner sc = new Scanner(System.in);

    // 수강생 관리 메서드 클래스
    public Student inItMethod( String studentId) {

        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.nextLine();
        Student student = new Student(studentId,studentName);
        return  student;
    }



    //필수과목 등록 및 저장 메서드
     public void mandatoryMethod(Student student, List<Subject> subjectStore) {

        //필수과목 리시트 보여주기
        System.out.println("========================================================================");
        for (Subject subject : subjectStore) {
            SubjectList s = subject.getSubjectList();
            if (s.getSubjectType() == SubjectType.MANDATORY) {
                System.out.println("타입: " + s.getSubjectType() + ", 과목이름: " + s.getSubjectName());
            }
        }
        System.out.println("========================================================================");
        //필수과목 입력받기
        loop:
        for (int i = 1; i <= 5; i++) {
            System.out.print("필수 과목을 선택하세요(3개이상): ");
            String mandatoryChoice = sc.nextLine();
            student.getStudentSubjectList().add(mandatoryChoice);

            if (i >= 3) {
                System.out.print("더 선택하시겠습니까?(필수과목 최대 5개 수강 가능): \n 1.네 \n 2.아니요 ");
                int additionalChoice = Integer.parseInt(sc.nextLine());
                switch (additionalChoice) {
                    case 1:
                        break;  //현재 진행중인 반복문을 종료하고 조건문으로 이동한다.
                    case 2:
                        break loop;
                }
            }

        }
    }




    // 선택과목 등록 및 저장하기
   public void choiceMethod(Student student, List<Subject> subjectStore) {
        //선택과목 리시트 보여주기
        System.out.println("========================================================================");
        for (Subject subject : subjectStore) {
            SubjectList s = subject.getSubjectList();
            if (s.getSubjectType() == SubjectType.CHOICE) {
                System.out.println("타입: " + s.getSubjectType() + ", 과목이름: " + s.getSubjectName());
            }
        }
        System.out.println("========================================================================");

        //선택과목 입력받기
        System.out.println("선택과목을 입력받습니다.");
        loop:
        for (int i = 1; i <= 4; i++) {
            System.out.print("선택과목을 선택하세요(2개이상): ");
            String choiceSubject = sc.nextLine();
            student.getStudentSubjectList().add(choiceSubject);
            if (i >= 2) {
                System.out.print("더 선택하시겠습니까?(선택과목 제한 없음): \n 1.네 \n 2.아니요 ");
                int additionalChoice = Integer.parseInt(sc.nextLine());
                switch (additionalChoice) {
                    case 1:
                        break;  //현재 진행중인 반복문을 종료하고 조건문으로 이동한다.
                    case 2:
                        break loop;
                }
            }

        }
    }
}
