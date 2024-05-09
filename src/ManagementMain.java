import java.util.*;
// dev로 가자

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */
public class ManagementMain {
    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;

    private static Student student;


    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static final Scanner sc = new Scanner(System.in);


    // 실행부분
    public static void main(String[] args) {
        setInitData(); //데이터 생성.
        while (true) {
            try {
                displayMainView();
            } catch (Exception e) {
                System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
            }
        }
    }


    // 초기 데이터 생성
    private static void setInitData() {
        studentStore = new ArrayList<>(); // 학생 배열 초기화
        // 과목 배열 초기화 , Enum을 활용하여 리펙토링
        subjectStore = List.of(
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.JAVA),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.OBJECT_ORIENTED),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.SPRING),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.JPA),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.MYSQL),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.DESIGN_PATTERN),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.SPRING_SECURITY),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.REDIS),
                new Subject(sequence(INDEX_TYPE_SUBJECT), SubjectList.MONGODB)
        );
        scoreStore = new ArrayList<>(); // 점수 배열 초기화
    }


    // index 자동 증가
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 수강생 정보 삭제");
            System.out.println("4. 메인 항목으로 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> removeStudent(); // 수강생 정보 삭제
                case 4 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    private static void removeStudent() {  // by 윤재
        StudentUtils studentUtils = new StudentUtils();
        studentUtils.removeStudent(studentStore); // 고유 ID를 불러와서 삭제하기
    }

    // 수강생 등록
    private static void createStudent() {

        // 기능구현 - by 정근
        // inItMethod 로 INDEX_TYPE_STUDENT 만 넘겨주면 Student 인스턴스를 리턴받음
        Student student = StudentUtils.inItMethod(sequence(INDEX_TYPE_STUDENT));
        studentStore.add(student);
        // 기능 구현 (필수 과목, 선택 과목)
        //필수과목 입력받고 저장하기
        StudentUtils.mandatoryMethod(student, subjectStore);

        //선택과목 입력받고 저장하기
        StudentUtils.choiceMethod(student, subjectStore);


        // 리스트 확인
        System.out.println(student.getStudentId() + "   " + student.getStudentName()); // 수강생 인스턴스 생성확인
        ArrayList<String> studentSubjectList = student.getStudentSubjectList();
        for (Object o : studentSubjectList) {
            System.out.println(o);
        }
        System.out.println("수강생 등록 성공!\n");


    }


    // 수강생 목록 조회
    private static void inquireStudent() {
        StudentUtils studentUtils = new StudentUtils();
        studentUtils.lookUp(studentStore);
        // made by 정근
        // 수강생 목록 불러오기

    }

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급을 조회");
            System.out.println("4. 수강생의 특정 과목별 평균등급 조회");
            System.out.println("5. 수강생 필수과목 평균등급 조회");
            System.out.println("6. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquiryEpisodeGrade(); //수강생의 특정 과목 회차별 등급 조회
                case 4 -> inquiryAvgGrade(); // 수강생의 특정 과목별 평균등급 조회
                case 5 -> calculateAverageMandatorySubjects(); // 평균등급 조회
                case 6 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 멤버 변수로 등급을 가지고 있기 , 점수가 입력되는순간 등급을 반환되는 메서드 가지고 있기 enum
    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

    //code by Leejinuk.
    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        String selectSubject;
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        if ("exit".equals(studentId)) return;
        System.out.println("==================================");
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {

                System.out.println(student.getStudentId() + " " + student.getStudentName() + "의 점수를 등록합니다.");
                for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                    String subject = student.getStudentSubjectList().get(i);
                    System.out.println(i + 1 + ". " + subject);
                }

                boolean flag = true; //반복 체크용 flag.
                sc.nextLine(); //개행문자 비워주기.
                do {
                    System.out.print("점수를 등록할 과목의 이름을 입력하세요(돌아가려면 \"exit\"을 입력해주세요): ");
                    selectSubject = sc.nextLine();
                    if ("exit".equals(selectSubject)) return;
                    for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                        String subject = student.getStudentSubjectList().get(i);
                        if (subject.equals(selectSubject)) flag = false; //일치하는 과목이 있으면 do-while문 탈출.
                    }
                    if (flag) System.out.println("과목 이름이 틀렸거나, 존재하지 않는 과목입니다. 다시 입력해주세요.");
                } while (flag);

                Map<String, int[]> scoreMap = student.getStudentScoreMap();

                if (scoreMap.containsKey(selectSubject)) { // 점수가 이미 등록된 경우 Execption을 배제한 간단한 예외처리
                    System.out.println("이미 해당 과목의 점수가 등록되어 있습니다.");
                    System.out.println("추가적인 등록은 불가능하므로 수정 메서드로 이동하겠습니다.");
                    updateRoundScoreBySubject(); // 수정 메서드로 이동
                    return;
                }
                System.out.println(selectSubject + "의 점수 등록을 시작합니다...");
                int score;
                int[] scoreArr = new int[10];
                for (int i = 0; i < 10; i++) {
                    flag = true;
                    do {
                        System.out.print(i + 1 + "회차 점수 : ");
                        score = sc.nextInt();
                        if (0 <= score && score <= 100) {
                            scoreArr[i] = score;
                            //점수를 기반으로 등급을 매겨 저장해준다.
                            flag = false;
                        } else {
                            System.out.println("0 ~ 100 사이의 점수로 입력해주세요.");
                        }
                    } while (flag);
                }
                scoreMap.put(selectSubject, scoreArr);
                System.out.println(selectSubject + "\n" + Arrays.toString(scoreMap.get(selectSubject)));
                System.out.println("\n점수 등록 성공!");
                return;
            }
        }
        System.out.println("입력한 학생 번호는 잘못 입력됐거나, 존재하지 않습니다.");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String selectSubject;
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        if ("exit".equals(studentId)) return;
        System.out.println("==================================");
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {
                Map<String, int[]> scoreMap = student.getStudentScoreMap();
                Set<String> subject = scoreMap.keySet();
                System.out.println(student.getStudentId() + " " + student.getStudentName() + "의 점수를 수정합니다.");
                for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                    System.out.println(i + 1 + ". " + student.getStudentSubjectList().get(i));
                }

                boolean flag = true; //반복 체크용 flag.
                sc.nextLine(); //개행문자 비워주기.
                do {
                    System.out.print("점수를 수정할 과목의 이름을 입력하세요(돌아가려면 \"exit\"을 입력해주세요): ");
                    selectSubject = sc.nextLine();
                    if ("exit".equals(selectSubject)) return;
                    for (String key : subject) {
                        if (key.equals(selectSubject)) {
                            flag = false; //일치하는 과목이 있으면 do-while문 탈출.
                        }
                    }
                    if (flag) System.out.println("과목 이름이 틀렸거나, 점수가 미등록된 과목은 수정할 수 없습니다. 다시 입력해주세요.");
                } while (flag);

                System.out.println(selectSubject + "의 점수 수정을 원하는 회차를 입력해주세요: ");
                int round = sc.nextInt();
                if (1 <= round && round <= 10) {
                    int[] scoreArray = scoreMap.get(selectSubject);
                    System.out.println(selectSubject + " 과목, " + round + " 회차의 수정할 점수를 입력해주세요: ");
                    flag = true; //반복 체크
                    do {
                        int updateScore = sc.nextInt();
                        if (0 <= updateScore && updateScore <= 100) {
                            scoreArray[round - 1] = updateScore; //입력받은 회차에 -1을 해야 원하는 index에 접근가능.
                            flag = false;
                        } else {
                            System.out.println("0 ~ 100 사이의 점수로 입력해주세요.");
                        }
                    } while (flag);
                    System.out.println("점수 수정 성공!");
                    return;
                } else {
                    System.out.println("올바른 회차가 아닙니다.");
                    return;
                }
            }
        }
        System.out.println("입력한 학생 번호는 잘못 입력됐거나, 존재하지 않습니다.");
    }

    private static void inquiryEpisodeGrade() {
        String selectSubject;
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        if ("exit".equals(studentId)) return;
        System.out.println("==================================");
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {
                Map<String, int[]> scoreMap = student.getStudentScoreMap();
                Set<String> subject = scoreMap.keySet();
                System.out.println(student.getStudentId() + " " + student.getStudentName() + "의 등급을 조회합니다.");
                for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                    System.out.println(i + 1 + ". " + student.getStudentSubjectList().get(i));
                }

                boolean flag = true; //반복 체크용 flag.
                sc.nextLine(); //개행문자 비워주기.
                do {
                    System.out.print("등급을 조회할 과목의 이름을 입력하세요(돌아가려면 \"exit\"을 입력해주세요): ");
                    selectSubject = sc.nextLine();
                    if ("exit".equals(selectSubject)) return;
                    for (String key : subject) {
                        if (key.equals(selectSubject)) {
                            flag = false; //일치하는 과목이 있으면 do-while문 탈출.
                        }
                    }
                    if (flag) System.out.println("과목 이름이 틀렸거나, 점수가 미등록된 과목은 조회할 수 없습니다. 다시 입력해주세요.");
                } while (flag);

                System.out.println(selectSubject + "과목의 등급을 조회합니다. ");
                int[] scores = scoreMap.get(selectSubject);
                for (int i = 0; i < scores.length; i++) {
                    String grade = getGrade(scores[i]); // 점수에 따른 등급 계산 메서드 호출
                    System.out.println((i + 1) + "회차 등급: " + grade);
                }

                return;
            }
        }
        System.out.println("입력한 학생 번호는 잘못 입력됐거나, 존재하지 않습니다.");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    // 수강생의 특정 과목 회차별 점수 조회
    private static void inquireRoundScoreBySubject() {
        String selectSubject;
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        if ("exit".equals(studentId)) return;
        System.out.println("==================================");
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {
                Map<String, int[]> scoreMap = student.getStudentScoreMap();
                Set<String> subject = scoreMap.keySet();
                System.out.println(student.getStudentId() + " " + student.getStudentName() + "의 점수를 조회합니다.");
                for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                    System.out.println(i + 1 + ". " + student.getStudentSubjectList().get(i));
                }

                boolean flag = true; //반복 체크용 flag.
                sc.nextLine(); //개행문자 비워주기.
                do {
                    System.out.print("점수를 조회할 과목의 이름을 입력하세요(돌아가려면 \"exit\"을 입력해주세요): ");
                    selectSubject = sc.nextLine();
                    if ("exit".equals(selectSubject)) return;
                    for (String key : subject) {
                        if (key.equals(selectSubject)) {
                            flag = false; //일치하는 과목이 있으면 do-while문 탈출.
                        }
                    }
                    if (flag) System.out.println("과목 이름이 틀렸거나, 점수가 미등록된 과목은 조회할 수 없습니다. 다시 입력해주세요.");
                } while (flag);

                System.out.println(selectSubject + "과목의 점수를 조회합니다. ");
                System.out.println(Arrays.toString(scoreMap.get(selectSubject)));
                return;
            }
        }
        System.out.println("입력한 학생 번호는 잘못 입력됐거나, 존재하지 않습니다.");
    }

    // 수강생의 특정 과목 회차별 등급 조회 마무리 ,  code by yoonjae
    private static void inquiryAvgGrade() {
        String selectSubject;
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        if ("exit".equals(studentId)) return;
        System.out.println("==================================");
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {
                Map<String, int[]> scoreMap = student.getStudentScoreMap();
                Set<String> subject = scoreMap.keySet();
                System.out.println(student.getStudentId() + " " + student.getStudentName() + "의 등급을 조회합니다.");
                for (int i = 0; i < student.getStudentSubjectList().size(); i++) {
                    System.out.println(i + 1 + ". " + student.getStudentSubjectList().get(i));
                }

                boolean flag = true; //반복 체크용 flag.
                sc.nextLine(); //개행문자 비워주기.
                do {
                    System.out.print("등급을 조회할 과목의 이름을 입력하세요(돌아가려면 \"exit\"을 입력해주세요): ");
                    selectSubject = sc.nextLine();
                    if ("exit".equals(selectSubject)) return;
                    for (String key : subject) {
                        if (key.equals(selectSubject)) {
                            flag = false; //일치하는 과목이 있으면 do-while문 탈출.
                        }
                    }
                    if (flag) System.out.println("과목 이름이 틀렸거나, 점수가 미등록된 과목은 조회할 수 없습니다. 다시 입력해주세요.");
                } while (flag);

                System.out.println(selectSubject + "과목의 등급을 조회합니다. ");
                int[] scores = scoreMap.get(selectSubject);
                int totalScore = 0;
                for (int i = 0; i < scores.length; i++) {
                    totalScore += scores[i];
                }
                int averageScore = totalScore / scores.length;
                String grade = getGrade(averageScore); // 평균 점수에 따른 등급 계산 메서드 호출
                System.out.println("평균 등급: " + grade);

                return;
            }
        }
        System.out.println("입력한 학생 번호는 잘못 입력됐거나, 존재하지 않습니다.");
    }


    private static String getGrade(int score) { // 필수과목 산정기준
        if (score >= 95) {
            return "A";
        } else if (score >= 90) {
            return "B";
        } else if (score >= 80) {
            return "C";
        } else if (score >= 70) {
            return "D";
        } else if (score >= 60) {
            return "F";
        }
        return "N";
    }


    //
    private static boolean isMandatorySubject(String subjectName) {
        for (SubjectList subject : SubjectList.values()) {
            if (subject.getSubjectName().equals(subjectName) && subject.getSubjectType() == SubjectType.MANDATORY) {
                return true;
            }
        }
        return false;
    }

    // 필수 과목 평균 등급 조회하는 메서드
    private static void calculateAverageMandatorySubjects() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        if ("exit".equals(studentId)) return;

        System.out.println("==================================");
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {
                Map<String, int[]> scoreMap = student.getStudentScoreMap();
                ArrayList<String> subjectList = student.getStudentSubjectList();

                System.out.println(student.getStudentId() + " " + student.getStudentName() + "의 필수 과목 평균 등급을 계산합니다.");

                int totalMandatoryScore = 0; // 모든 필수 과목의 총 점수
                int totalMandatorySubjects = 0; // 필수 과목 수

                // 모든 과목에 대해 점수를 확인하여 필수 과목이면 평균 계산에 포함
                for (String subject : subjectList) {
                    if (isMandatorySubject(subject)) {
                        int[] scores = scoreMap.get(subject);
                        if (scores != null && scores.length > 0) { // 과목 점수 배열이 null이 아니고 길이가 0보다 큰 경우
                            int subjectTotalScore = 0; // 각 과목의 총 점수
                            for (int score : scores) {
                                subjectTotalScore += score;
                            }
                            // 각 과목의 평균 점수를 계산하여 총 점수에 더함
                            totalMandatoryScore += subjectTotalScore / scores.length;
                            totalMandatorySubjects++; // 필수 과목 수 증가
                        } else {
                            System.out.println(subject + " 과목의 점수가 없습니다. 이 과목은 평균 계산에서 제외됩니다.");
                        }
                    }
                }
                // 필수 과목 점수가 없는 경우를 처리하여 평균 등급 계산 (예외처리(?))
                int averageScore = totalMandatorySubjects > 0 ? totalMandatoryScore / totalMandatorySubjects : 0;
                String grade = getGrade(averageScore); // 등급 반환
                System.out.println("필수 과목 평균 등급: " + grade);
            }
        }
    }
}