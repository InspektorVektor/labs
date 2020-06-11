package Commands;

/**
 * Команда "ПОМОЩЬ"
 */
public  class Help {
    /**
     * Текстовый файл с описанием всех команд
     */
    static String text = Add.description + "\n" +
            Clear.description  + "\n" + Execute_script.description + "\n" + Exit.description + "\n" +
            History.description + "\n" + Info.description + "\n" + Max_by_height.description + "\n" +
            Remove_greater.description + "\n" + Remove_by_id.description + "\n" + Filter_by_nationality.description + "\n" +
            Save.description + "\n" + Show.description + "\n" + Filter_greater_than_birthday.description + "\n" + Add_if_max.description + "\n"
            + Updater.description;

    /**
     * Вывод описания всех команд
     */
    public static  void help() {
        System.out.println(text);
    }
}
