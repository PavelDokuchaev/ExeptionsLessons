package lesson1;

// Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
public class task2 {
  public static int sum2d(String[][] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) { // IndexOutOfBoundsException, NullPointerException
      for (int j = 0; j < 5; j++) {
        int val = Integer.parseInt(arr[i][j]); // ClassCastException
        sum += val;
      }
    }
    return sum;
  }
}
