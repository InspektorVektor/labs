package Commands;
import App.Collection;
import App.Person;

/**
 * Команда "МАКСИМАЛЬНЫЙ"
 */
public class Max_by_height {
        static String description ="max_by_height: вывести любой объект из коллекции, значение поля height которого является максимальным";

        /**
         *  Метод для вывода элемента коллекции People с максимальным значением поля height
         * @param c коллекция
         */
        public static void  max_by_height (Collection c){
        if (c.people.size() > 0) {
                Person maxPersonByHeight = (Person) c.people.toArray()[0];
                for (Person r: c.people) {
                        if (r.getHeight()>maxPersonByHeight.getHeight() ) {
                                maxPersonByHeight = r;
                        }
                }
                System.out.println(maxPersonByHeight);
        } else
        System.out.println("Коллекция пуста");
}
}

