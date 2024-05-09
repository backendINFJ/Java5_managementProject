public class Score {
   private String scoreId;

   //필수과목 점수별 등급
   public static char mandatorySbjectGrade(int score) {
      char mandatorySbjectGrade;
      if (95 <= score &&  score<= 100) {
         mandatorySbjectGrade = 'A';
      } else if (90 <= score &&  score < 95){
         mandatorySbjectGrade = 'B';
      } else if (80 <= score &&  score < 90){
         mandatorySbjectGrade = 'C';
      } else if (70 <= score &&  score < 80){
         mandatorySbjectGrade = 'D';
      } else if (60 <= score &&  score < 70){
         mandatorySbjectGrade = 'F';
      } else {
         mandatorySbjectGrade = 'N';
      }
      return mandatorySbjectGrade;
   }

   //선택과목 점수별 등급
   public static char chioceSubjectGrade(int score){
      char chioceSubjectGrade;
      if (90 <= score &&  score<= 100) {
         chioceSubjectGrade = 'A';
      } else if (80 <= score &&  score < 90){
         chioceSubjectGrade = 'B';
      } else if (70 <= score &&  score < 80){
         chioceSubjectGrade = 'C';
      } else if (60 <= score &&  score < 70){
         chioceSubjectGrade = 'D';
      } else if (50 <= score &&  score < 60){
         chioceSubjectGrade = 'F';
      } else {
         chioceSubjectGrade = 'N';
      }
      return chioceSubjectGrade;
   }

   //수강생Id(studentId) 와 Subject Id 에 따른 회차별 점수 저장소
   //필수과목 시험 점수 10회분량씩 담은 배열을 ArrayList 로 묶기

   public Score(String seq) {
      this.scoreId = seq;
   }

   // Getter
   public String getScoreId() {
      return scoreId;
   }
}
