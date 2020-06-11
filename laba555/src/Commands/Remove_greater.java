package Commands;
import Readers.*;
import App.Person;

import java.io.IOException;

/**
 * Команда "УДОЛИ!"(Но только самый большой)
 */
public class Remove_greater {

    static String description ="remove_greater : удалить элемент из коллекции все элементы, превышающие заданный рост";

    /**
     * метод удаления элемента коллекции по его id
     * @param c коллекция
     * @param s2 id
     */
    public static void remove_greater(App.Collection c, String s2) throws IOException {


        if (s2==null | s2.equals("")) {
            System.out.println("кажется вы забыли ввести рост");
            return;
        }
        double height;
        try { height = Checker.doubleChecker(s2); }
        catch (NullPointerException e) {
            System.out.println("Неправильный тип. height должно быть типа Double." + "\n Попробуем ещё разок!");
            return;
        }
        if (!(height > 0)) {
            System.out.println("Значение height должно быть больше 0");
            return;
        }


        if (c.people.size() > 0) {
            for (Person r: c.people) {
                if (r.getHeight() > height) {
                    c.people.remove(r);
                }
            }
        } else
            System.out.println("Коллекция пуста");

    }

}
