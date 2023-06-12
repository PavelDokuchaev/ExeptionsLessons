package less2;

import java.util.Scanner;

public class task4 {
  /*
   * Разработайте программу, которая выбросит Exception, когда пользователь вводит
   * пустую строку.
   * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
   */

  public static void main(String[] args) {
    try {
      System.out.println(getUserString());
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }

  }

  public static String getUserString() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите строку: ");
    String userString = scanner.nextLine();
    if (userString == "") {
      throw new RuntimeException("Пустые строки вводить нельзя!");
    }
    return userString;
  }

}
