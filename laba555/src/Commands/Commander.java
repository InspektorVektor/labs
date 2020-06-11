package Commands;

import App.Collection;
import Readers.*;
import java.io.IOException;

/**
 * Класс, соотносящий введённую команду с доступными командами
 */
public class Commander {
    /**
     * Распределение команд
     * @param reader объект - считыватель
     * @param c коллекция
     * @param s1 команда
     * @param s2 данные, читаемые в одной строке с командой
     * @return возвращает true, если не была введена команда exit
     * @throws IOException
     */
    public  static boolean switcher(Reader reader, Collection c, String s1, String s2) throws IOException {
        boolean historyCheck = true;
        switch (s1.toLowerCase()) {
            case ("help"):
                Help.help();
                break;
            case ("info"):
                Info.info(c);
                break;
            case ("show"):
                Show.show(c);
                break;
            case ("add"):
                Add.add(reader, c);
                break;
            case ("add_if_max"):
                Add_if_max.add_if_max(reader, c);
                break;
            case ("remove_by_id"):
                Remove_by_id.remove_by_id(c, s2);
                break;
            case ("filter_by_nationality"):
                Filter_by_nationality.filter_by_nationality(c, s2);
                break;
            case ("filter_greater_than_birthday"):
                Filter_greater_than_birthday.filter_greater_than_birthday(c, s2);
                break;
            case ("remove_greater"):
                Remove_greater.remove_greater(c, s2);
                break;
            case ("clear"):
                Clear.clear(c);
                break;
            case ("save"):
                Save.save(c);
                break;
            case ("execute_script"):
                return Execute_script.execute_script(c, s2);
            case ("exit"):
                return Exit.exit();
            case ("history"):
                History.history();
                break;
            case ("update"):
                Updater.update(reader, c, s2);
                break;
            case ("max_by_height"):
                Max_by_height.max_by_height(c);
                break;

            default:
                historyCheck = false;
                System.out.println("Неизвестная команда. Попробуйте написать что-нибудь как-нибудь иначе.");
        }
        if(historyCheck)History.addInArray(s1);
        return true;
    }
}
