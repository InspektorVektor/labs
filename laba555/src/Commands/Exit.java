package Commands;

/**
 * Команда "ВЫХОДА НЕТ"
 */
public class Exit {
    static String description ="exit : завершить программу (без сохранения в файл)";

    /**
     * Метод для прекращения работы программы
     * @return false (передаётся в Main )
     */
    public static boolean exit(){
        return false;
    }
}
