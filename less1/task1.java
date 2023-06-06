package lesson1;

// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
public class task1 {

  public static void main(String[] args) {
    divideTwoNumbers(4, 0);
    getValue(new int[10], 12);
    createArray(-10);
  }

  public static int divideTwoNumbers(int num1, int num2) {
    if (num2 == 0) {
      throw new ArithmeticException("Вы не можете делить на ноль");
    }
    return num1 / num2;
  }

  public static int[] createArray(int sizeArr) {
    if (sizeArr < 0) {
      throw new NegativeArraySizeException("Размер массивы не может быть меньше нуля");
    }
    return new int[sizeArr];
  }

  public static int getValue(int[] arr, int i) {
    if (i > arr.length) {
      throw new IndexOutOfBoundsException("Вы обратились к индексу за пределами массива");
    }
    return arr[i];
  }
}
