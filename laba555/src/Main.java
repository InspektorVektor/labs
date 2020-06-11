import Readers.CommandArgumentSplitter;
import Readers.ConsoleSourceReader;
import App.Collection;
import XmlManagers.XmlReader;

import java.io.File;
import java.io.IOException;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * Главный класс, в котором происходит вся магия
 */

public class Main {

    /**
     * Главный метод, в котором происходит вся магия
     */

    public static void main(String[] args) throws IOException {

        Signal.handle(new Signal("INT"), new SignalHandler() {
            public void handle(Signal sig) {
                System.out.println("Наконец-то эта программа завершается...");//ctrl-c
                System.exit(0);
            }
        });

        boolean work = true; // переменная, отвечающая за выход из программы. Как только она станет false, программа завершается
        ConsoleSourceReader bufferReader = new ConsoleSourceReader();
        Collection c;
        String path;
        String[] s;


            path = "resources/input.xml";

        c = XmlReader.getCollection(path);
        c.setPath(path);

        while (work) {
            System.out.print("\n \n" + "Введите, что вам надо: ");
            s = CommandArgumentSplitter.comArgSplitter(bufferReader.getLine());
            System.out.println(s[0]);
            work = Commands.Commander.switcher(bufferReader, c, s[0], s[1]);
        }

        System.out.println("Наконец-то эта программа завершается...");
        bufferReader.close();
    }

    //execute_script resources/test.txt
    //resources/input.xml
}
