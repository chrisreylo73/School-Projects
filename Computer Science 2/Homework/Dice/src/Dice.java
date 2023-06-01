import java.lang.Math;

class Dice {
  public static int solution(int A) {
    String stringOfA = String.valueOf(A);
    int sizeA = stringOfA.length();
    String firPart;
    String secPart;
    int first;
    int second;
    int lowestVal;
    int[] differences = new int[sizeA - 1];
    for (int i = 0, j = 1; j < sizeA; j++) {
      firPart = stringOfA.substring(i, j);
      secPart = stringOfA.substring(j);
      first = Integer.parseInt(firPart);
      second = Integer.parseInt(secPart);
      differences[j - 1] = Math.abs(first - second);
    }
    lowestVal = differences[0];
    for (int i = 0; i < differences.length; i++) {
      if (differences[i] < lowestVal) {
        lowestVal = differences[i];
      }
    }
    System.out.println(lowestVal);
    System.err.println("Tip: Use System.err.println() to write debug messages on the output tab.");
    return 0;
  }
}
