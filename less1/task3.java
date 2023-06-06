package lesson1;

// Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
// и возвращающий новый массив, каждый элемент которого равен частному элементов двух
// входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
// оповестить пользователя. Важно: При выполнении метода единственное исключение,
// которое пользователь может увидеть - RuntimeException, т.е. ваше
public class task3 {

  public static void main(String[] args) {
    createArray(new int[5], new int[9]);
  }

  public static int[] createArray(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length) {
      throw new RuntimeException("Длины массивов не равны!");
    }
    int[] resultArray = new int[arr1.length];
    for (int i = 0; i < arr1.length; i++) {
      resultArray[i] = arr1[i] / arr2[i];
    }
    return resultArray;
  }
}
