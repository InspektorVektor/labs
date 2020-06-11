package Commands;

/**
 * Команда "ЧИСТИЛЬЩИК "
 */
public class Clear {
    static String description ="clear : очистить коллекцию";

    /**
     * Метод для очистки коллекции, подаваемой на вход
     * @param c коллекция
     */
    public static void clear(App.Collection c) {
        c.people.clear();
    }
}
