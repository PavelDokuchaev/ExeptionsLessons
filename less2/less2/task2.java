package less2;

public class task2 {
  public static void main(String[] args) {
    /*
     * Было:
     * try {
     * int d = 0;
     * double catchedRes1 = intArray[8] / d;
     * System.out.println("catchedRes1 = " + catchedRes1);
     * } catch (ArithmeticException e) {
     * System.out.println("Catching exception: " + e);
     * }
     */

    // Стало:
    int[] intArray = { 5, 2, 7, 12, 11, 6, 17, 9, 8, 10, 12, 4, 7 }; // добавлен массив, т.к. его не было
    try {
      int d = 4; // исправил на 4, чтобы не делить на ноль, но есть ArithmeticException, наверно
                 // можно было не исправлять
      double catchedRes1 = (double) intArray[8] / d; // привел к типу double
      System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException e) {
      System.out.println("Catching exception: " + e);
    } catch (ArrayIndexOutOfBoundsException e) { // возможно, что будет задан массив длиной меньше 8, поэтому добавил
                                                 // исключение ArrayIndexOutOfBoundsException
      System.out.println("Catching exception: " + e);
    }
  }

}
