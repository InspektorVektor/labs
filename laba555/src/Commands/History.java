package Commands;

/**
 * Команда "ПАМЯТЬ"
 */

public class History {
    static String description ="history: вывести последние 6 команд (без их аргументов)";
    static final int n = 5; //количество сохраняемых команд -1
    static String [] historyArray = new String[n]; //массив для хранения последних n+1 команд

    /**
     * Метод для отображения истории
     */
    public static void history (){
    for (int i = n-1; i>=0; i--) { if (historyArray[i] != null) System.out.println("   "+ (i+1) + "   " + historyArray[i]);}
}

    /**
     * Запись команды в анналы истории
     * @param s1 команда
     */
    public static void addInArray (String s1){
        for (int i = n-1; i>0; i--) {
            historyArray[i]=historyArray[i-1];
        }
        historyArray[0] = s1; //запись команды в изначальном регистре в массив
    }
}
