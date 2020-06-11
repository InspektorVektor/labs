package Commands;
import App.Collection;
import App.Country;
import App.Person;

/**
 * Команда "ГЛЯДИ! "
 */
public class Filter_by_nationality {
    static String description ="filter_by_nationality : вывести элементы, значения поля nationality которых равно заданному";

    /**
     * Метод для отображения всех элементов коллекции
     * @param c коллекция
     */
    public static void filter_by_nationality (Collection c, String s2) {
        if ( s2.equals("") || s2 == null) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        if (Country.getValue(s2) == null) {
            System.out.println("Такого типа нет");
            return;
        }
        if (c.people.size() == 0) {
            System.out.println("Коллекция пуста, милорд");
        } else {
            for (Person r : c.people) {
                if(r.getNationality().str.equals(s2))
                System.out.println("  " + r.toString());
            }
        }
    }
}
