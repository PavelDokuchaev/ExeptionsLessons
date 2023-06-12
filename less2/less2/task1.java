package less2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению
приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных. */

public class task1 {

  public static void main(String[] args) {
    enterFloatNumber();
  }

  public static void enterFloatNumber() {
    float userNumber = 0;
    boolean flag = true;

    while (flag) {
      System.out.print("Введите дробное число: ");
      Scanner scan = new Scanner(System.in);
      try {
        userNumber = scan.nextFloat();
        flag = false;
      } catch (InputMismatchException e) {
        System.out.println("Вы ввели не дробное чило!");
      } finally {
        System.out.println(userNumber);

      }
    }
  }
}