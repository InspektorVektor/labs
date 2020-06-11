package Commands;
import App.Collection;
import App.Person;

/**
 * Команда "ГЛЯДИ! "
 */
public class Show {
    static String description ="show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";

    /**
     * Метод для отображения всех элементов коллекции
     * @param c коллекция
     */
    public static void show (Collection c) {
        if (c.people.size() == 0) {
            System.out.println("Коллекция пуста, милорд");
        } else {

            for (Person r : c.people) {
                System.out.println("  " + r.toString());
            }
        }
    }
}
