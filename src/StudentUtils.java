import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentUtils {
    // 중복과 과목일치 확인을 위해 임시로 만든 리스트




    static Scanner sc = new Scanner(System.in);

    // 수강생 관리 메서드 클래스
    public static Student inItMethod(String studentId) {

        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.nextLine();
        Student student = new Student(studentId, studentName);
        return student;
    }


    //필수과목 등록 및 저장 메서드
    public static void mandatoryMethod(Student student, List<Subject> subjectStore) {
        ArrayList<String> mandatoryTempList = new ArrayList<>();

        //필수과목 리시트 보여주기
        System.out.println("========================================================================");
        for (Subject subject : subjectStore) {
            SubjectList s = subject.getSubjectList();
            if (s.getSubjectType() == SubjectType.MANDATORY) {
                mandatoryTempList.add(s.getSubjectName()); // 필수과목 임시리스트에 저장
                System.out.println((s.ordinal() + 1) + ". 타입: " + s.getSubjectType() + ", 과목이름: " + s.getSubjectName());
            }
        }
        System.out.println("========================================================================");


        //필수과목 입력받기
        //단축 리스트에 실제 저장될 getStudentSubjectList 담기
        ArrayList<String> s = student.getStudentSubjectList();
        loop:
        for (int i = 0; i < mandatoryTempList.size(); i++) {

            System.out.print("필수 과목을 선택하세요(3개이상): ");
            String mandatoryChoice = sc.nextLine();

            // 중복 검사
            boolean flag1 = s.contains(mandatoryChoice); // 추가하는 값이 중복되어 있으면 true
            if (flag1) {
                System.out.println("중복된 값을 입력하셨습니다. \n다시 입력하세요.");
                System.out.println("중복된 과목: [" + mandatoryChoice + "]" ); // 중복된 과목 출력
                i--;
                continue;
            }

            //유효한 과목인지 검사
            boolean flag2 = mandatoryTempList.contains(mandatoryChoice); // 추가하는 값이 존재하는 값이면 true
            //입력하는 과목이 존재하는지 확인후 존재하면 추가
            if (flag2) {
                s.add(mandatoryChoice);
                System.out.println((i + 1) + "개 저장완료");

                //리스트 확인
                for (String a : s) {
                    System.out.print( " [" +  a + "] ");
                }
                System.out.println();
            } else {
                System.out.println("과목에 없는 값을 입력하셨습니다. \n 다시 입력하세요");
                i--; // i를 하나 줄이고 다시 반복문을 실행
                continue;
            }


            if (i >= 2 && i < mandatoryTempList.size() - 1) {
                System.out.println("더 선택하시겠습니까?(필수과목 최대 5개 수강 가능) \n 1.네 \n 2.아니요 ");
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
    public static void choiceMethod(Student student, List<Subject> subjectStore) {
        ArrayList<String> choiceTempList = new ArrayList<>();

        //단축 리스트에 실제 저장될 getStudentSubjectList 담기
        ArrayList<String> s = student.getStudentSubjectList();

        //선택과목 입력받기
        System.out.println();
        System.out.println("선택과목을 입력받습니다.");
        //선택과목 리시트 보여주기
        System.out.println("========================================================================");
        for (Subject subject : subjectStore) {
            SubjectList subjectList = subject.getSubjectList();

            if (subjectList.getSubjectType() == SubjectType.CHOICE) {
                choiceTempList.add(subjectList.getSubjectName()); // 선택과목 임시리스트에 저장
                System.out.println("타입: " + subjectList.getSubjectType() + ", 과목이름: " + subjectList.getSubjectName());
            }
        }
        System.out.println("========================================================================");

        System.out.println(choiceTempList.size());

        loop:
        for (int i = 0; i < choiceTempList.size(); i++) {
            System.out.print("선택과목을 선택하세요(2개이상): ");
            String choiceSubject = sc.nextLine();
            // 중복 검사
            boolean flag1 = s.contains(choiceSubject); // 추가하는 값이 중복되어 있으면 true
            if (flag1) {
                System.out.println("중복된 값을 입력하셨습니다. \n다시 입력하세요.");
                System.out.println("중복된 과목: [" + choiceSubject + "]" ); //중복된 과목 출력
                i--;
                continue;
            }

            //유효한 과목인지 검사
            //입력하는 과목이 존재하는지 확인후 존재하면 추가
            boolean flag2 = choiceTempList.contains(choiceSubject); // 추가하는 값이 존재하는 값이면 true
            if (flag2) {
               s.add(choiceSubject);
                System.out.println((i + 1) + "개 저장완료");
                //리스트 확인
                System.out.print("현재 선택한 과목: ");
                for (String a : s) {
                    System.out.print( " [" +  a + "] ");
                }
                System.out.println();
            }else {
                System.out.println("과목에 없는 값을 입력하셨습니다. \n다시 입력하세요");
                i--; // i를 하나 줄이고 다시 반복문을 실행
                continue;
            }
            if (i >= 1 && i < choiceTempList.size() - 1) {
                System.out.println("더 선택하시겠습니까?(선택과목 제한 없음): \n 1.네 \n 2.아니요 ");
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

    public static void lookUp(List<Student> studentStore) {
        if (studentStore.size() >= 1) {
            System.out.println("\n수강생 목록을 조회합니다...");
            for (Student student : studentStore) {
                System.out.println("학생이름: " + student.getStudentName() + " ,고유번호: " + student.getStudentId());
            }
            // 기능 구현
            System.out.println("\n수강생 목록 조회 성공!");
        } else {
            System.out.println("조회할 학생이 없습니다.");
        }

    }

    public void removeStudent(List<Student> studentRemove) { // 학생 정보 삭제 메서드, code by yoonjae
        System.out.print("삭제할 학생의 고유번호를 입력하세요: ");
        String studentId = sc.nextLine();

        for (Student student : studentRemove) {
            if (student.getStudentId().equals(studentId)) {
                studentRemove.remove(student);
                System.out.println("학생 정보가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("해당 학생 고유번호를 찾을 수 없습니다.");
    }

}
