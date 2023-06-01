
public class Assignment {
   private String studentName;
   private String assignName;
   private int grade;

   public Assignment(String tempStudentName, String tempAssignName, int tempGrade) {
      studentName = tempStudentName;
      assignName = tempAssignName;
      grade = tempGrade;
   }

   public String getStudentName() {
      return studentName;
   }

   public String getAssignName() {
      return assignName;
   }

   public int getGrade() {
      return grade;
   }

}
