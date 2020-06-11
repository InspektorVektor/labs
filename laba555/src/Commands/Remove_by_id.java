package Commands;
import Readers.*;
import App.Person;

/**
 * Команда "УДОЛИ!"
 */
public class Remove_by_id {

        static String description ="remove_by_id id : удалить элемент из коллекции по его id";

    /**
     * метод удаления элемента коллекции по его id
     * @param c коллекция
     * @param s2 id
     */
    public static void remove_by_id(App.Collection c, String s2){
    if (s2==null | s2.equals("")) {
        System.out.println("кажется вы забыли ввести айди");
        return;
    }

    int removeId = Checker.intChecker(s2);
    Person r = c.searchById(removeId);
    if (r ==null) {System.out.println("похоже элемента с таким айди не существует");
        return;
    }
       c.people.remove(r);
}

}
