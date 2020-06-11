package Commands;

/**
 * Команда "ИНФОРМБЮРО"
 */
public class Info {

    static String description ="info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";

    /**
     * Отображение актуальной информации о коллекции
     */
    public static void info(App.Collection c) {
        System.out.println("Коллекция представляет собой: " + c.people.getClass().getName());
        System.out.println("В коллекции: " + c.people.size()+ " элементов");
        System.out.println("Коллеция была создана: " + c.getInitializationDate());
    }
}
