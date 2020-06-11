package Commands;

import Readers.*;
import App.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

/**
 * Команда "Добавить-ка ещё!"
 */

public class Add {
    static String description = "add {element} : добавить новый элемент в коллекцию";
    static boolean hasName = false;  // показывает, было ли добавлено имя элемента
    static boolean  hasCoordinates = false; // показывает, было ли добавлено поле coordinates
    static boolean  hasHairColor = false; //показывает, было ли добавлено поле from
    static boolean hasNationality = false; // показывает, было ли добавлено поле to
    static boolean hasLocation = false; // показывает, было ли добавлено поле distance
    static boolean hasBirthday = false; // показывает, было ли добавлено поле distance
    static boolean hasHeight = false; // показывает, было ли добавлено поле distance
    /**
     * Метод для добавления новых элементов в коллекцию
     * @param reader объект - считыватель
     * @param c коллекция
     * @throws NullPointerException, IOException
     */
    public static void add(Reader reader, Collection c) throws NullPointerException, IOException {
        Person person = new Person();
        person.setId(c.generateUniqueID());
        while (!Add.hasName) addName(reader, c, person);
        while (!Add.hasCoordinates) addCoordinates(reader, c, person);
        while (!Add.hasLocation) addLocation(reader,c, person);
        while (!Add.hasHairColor) addHairColor(reader,c, person);
        while (!Add.hasNationality) addNationality(reader,c, person);
        while (!Add.hasBirthday) addBirthday(reader,c, person);
        while (!Add.hasHeight) addHeight(reader,c, person);
        person.setCreationDate(ZonedDateTime.now());

        c.people.add(person);
        System.out.println("Успех!");
        hasName = false;
        hasCoordinates = false;
        hasHairColor = false;
        hasNationality = false;
        hasLocation = false;
        hasBirthday = false;
        hasHeight = false;
    }

    /**
     * Метод добавления имени в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void addName (Reader reader, Collection c, Person person) throws IOException {
        System.out.print("Давайте попробуем добавить элемент." + "\n" + "Как вы хотите, чтобы его звали?  ");
        String name = reader.getLine();
        if (  name.equals("") || name == null) {
            System.out.println("Ноль это не имя");
            return;
        }
        person.setName(name);
        Add.hasName = true;
    }
    /**
     * Метод добавления дня рождения в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void addBirthday (Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Давайте попробуем добавить дату рождения в формате гггг-мм-ддTчч:мм:сс: ");
        String s = reader.getLine();
        if (  s.equals("") || s == null) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }

        LocalDateTime localDateTime;
        try {
            localDateTime = LocalDateTime.parse(s);
        } catch (DateTimeParseException e){
            System.out.println("Неверный формат, попробуйте еще раз");
            return;
        }

        person.setBirthday(localDateTime);
        Add.hasBirthday = true;
    }

    /**
     * Метод добавления координат в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void addCoordinates (Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Координаты, пожалуйста." + "\n" + "double X = ");
        String s = reader.getLine();
        if (  s.equals("") || s == null) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        double coordinateX;
        try { coordinateX = Checker.doubleChecker(s);}
        catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate X должно быть типа double." + "\n Попробуем ещё разок!");
            return;
        }
        if (coordinateX <= -522){
            System.out.println("Coordinate x должно быть больше -522");
            return;
        }

        System.out.print("double Y = ");
        double coordinateY;
        try {coordinateY = Checker.doubleChecker(reader.getLine());}
        catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate Y должно быть типа double" + "\n Попробуем ещё разок!");
            return;
        }
        if (coordinateY <= -256){
            System.out.println("Coordinate y должно быть больше -256");
            return;
        }

        person.setCoordinates(new Coordinates(coordinateX, coordinateY));
        Add.hasCoordinates = true;
    }


    /**
     * Метод добавления поля distance в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void addHeight(Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Давай посмотрим, что у нас там с Height. (double)  ");
        String s = reader.getLine();
        if (  s.equals("") || s == null) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        double height;
        try { height = Checker.doubleChecker(s); }
        catch (NullPointerException e) {
            System.out.println("Неправильный тип. height должно быть типа Double." + "\n Попробуем ещё разок!");
            return;
        }
        if (!(height > 0)) {
            System.out.println("Значение height должно быть больше 0");
            return;
        }
        person.setHeight(height);
        Add.hasHeight = true;
    }
    /**
     * Метод добавления поля HairColor в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void addHairColor(Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Выберите цвет волос:  ");
        String s = reader.getLine();
        if (  s.equals("") || s == null) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        if (Color.getValue(s) == null) {
            System.out.println("Такого типа волос нет");
            return;
        }
        person.setHairColor(Color.getValue(s));
        Add.hasHairColor = true;
    }
    /**
     * Метод добавления поля Nationality в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void addNationality(Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Выберите нацианальность:  ");
        String s = reader.getLine();
        if (  s.equals("") || s == null) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        if (Country.getValue(s) == null) {
            System.out.println("Такого типа стран нет");
            return;
        }
        person.setNationality(Country.getValue(s));
        Add.hasNationality = true;
    }
    /**
     * Метод добавления поля Location в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void addLocation (Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Название локации, пожалуйста: ");
        String s = reader.getLine();
        if (  s.equals("") || s == null) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        String name = s;
        System.out.print("float X = ");
        float coordinateX;
        try { coordinateX = Checker.floatChecker(reader.getLine());}
        catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate X должно быть типа float." + "\n Попробуем ещё разок!");
            return;
        }


        System.out.print("float Y = ");
        float coordinateY;
        try {coordinateY = Checker.floatChecker(reader.getLine());}
        catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate Y должно быть типа float" + "\n Попробуем ещё разок!");
            return;
        }

        System.out.print("int Z = ");
        int coordinateZ;
        try { coordinateZ = Checker.intChecker(reader.getLine());}
        catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate Z должно быть типа int." + "\n Попробуем ещё разок!");
            return;
        }

        person.setLocation(new Location(coordinateX, coordinateY, coordinateZ, name));
        Add.hasLocation = true;
    }

}
