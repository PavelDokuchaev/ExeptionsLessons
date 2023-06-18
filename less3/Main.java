/*
 Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
  static boolean flag = true;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(
        "Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (число без разделителей) и пол(символ латиницей f или m), разделенные пробелом");
    String input = scanner.nextLine();
    String[] data = input.split(" ");

    if (data.length != 6) {
      System.err.println("Вы ввели неверное колличество данных!");
      return;
    }
    String lastName = data[0];
    String firstName = data[1];
    String middleName = data[2];
    String birthDatePers = data[3];
    String phone = data[4];
    String genderPers = data[5];
    LocalDate birthDate;

    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
      birthDate = LocalDate.parse(birthDatePers, formatter);
    } catch (Exception e) {
      System.err.println("Вы ввели неверный формат даты рождения");
      return;
    }
    long phoneNumber;
    try {
      phoneNumber = Long.parseLong(phone);
    } catch (NumberFormatException e) {
      System.err.println("Вы ввели неверный формат номера телефона!");
      return;
    }
    char gender;
    if (genderPers.length() != 1 || (genderPers.charAt(0) == 'f' && genderPers.charAt(0) == 'm')) {
      System.err.println("Вы ввели неверный формат пола");
      return;
    } else {
      gender = genderPers.charAt(0);
    }
    String file = lastName + ".txt";
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
      if (file.length() > 0) {
        writer.write('\n');
      }
      writer.write(
          lastName + " " + firstName + " " + middleName + " " + birthDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + " "
              + phoneNumber + " " + gender);
      System.out.println("Успешно!");
      flag = false;
    } catch (IOException e) {
      System.err.println("Ошибка записи в файл!");
      e.printStackTrace();
    }
  }
}