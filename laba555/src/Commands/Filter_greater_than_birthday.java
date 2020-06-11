package Commands;
import App.Collection;
import App.Person;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 * Команда "ГЛЯДИ! "
 */
public class Filter_greater_than_birthday{
    static String description ="filter_greater_than_birthday : вывести элементы, значения поля birthday которых больше заданного";

    /**
     * Метод для отображения всех элементов коллекции
     * @param c коллекция
     */
    public static void filter_greater_than_birthday (Collection c, String s2) {
        if ( s2.equals("") || s2 == null) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        LocalDateTime localDateTime;
        try {
            localDateTime = LocalDateTime.parse(s2);
        } catch (DateTimeParseException e){
            System.out.println("Неверный формат, попробуйте еще раз");
            return;
        }
        if (c.people.size() == 0) {
            System.out.println("Коллекция пуста, милорд");
        } else {
            for (Person r : c.people) {
                if(r.getBirthday().isAfter(localDateTime))
                    System.out.println("  " + r.toString());
            }
        }
    }
}
