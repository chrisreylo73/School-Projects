import java.io.*;

public class CourseDriver {
   public static void main(String[] args) throws IOException {
      Course run = new Course();
      run.inputData();
      run.reportZeros();
      run.reportAssignmentAverages();
      run.reportStudentGrades();
      run.letterGrade();
      run.createReport();
   }
}