package Commands;

import Readers.*;
import App.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;

/**
 * Команда "Добавить-ка ещё!"(Но только самый большой)
 */

public class Add_if_max {
    static String description = "add_if_max {element} : добавить новый элемент в коллекцию, если его значение роста превышает наибольшее значение роста в коллекции";
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
    public static void add_if_max(Reader reader, Collection c) throws NullPointerException, IOException {
        Person person = new Person();
        person.setId(c.generateUniqueID());
        while (!Add_if_max.hasName) add_if_maxName(reader, c, person);
        while (!Add_if_max.hasCoordinates) add_if_maxCoordinates(reader, c, person);
        while (!Add_if_max.hasLocation) add_if_maxLocation(reader,c, person);
        while (!Add_if_max.hasHairColor) add_if_maxHairColor(reader,c, person);
        while (!Add_if_max.hasNationality) add_if_maxNationality(reader,c, person);
        while (!Add_if_max.hasBirthday) add_if_maxBirthday(reader,c, person);
        while (!Add_if_max.hasHeight) add_if_maxHeight(reader,c, person);
        person.setCreationDate(ZonedDateTime.now());

        double maxHeight = 0;
        for (Person r: c.people) {
            if (r.getHeight() > maxHeight) {
                maxHeight = r.getHeight();
            }
        }

        if(person.getHeight() > maxHeight) {
            c.people.add(person);
            System.out.println("Элемент добавлен");
            hasName = false;
            hasCoordinates = false;
            hasHairColor = false;
            hasNationality = false;
            hasLocation = false;
            hasBirthday = false;
            hasHeight = false;
        }else {
            System.out.println("Элемент не добавлен");
        }
    }

    /**
     * Метод добавления имени в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void add_if_maxName (Reader reader, Collection c, Person person) throws IOException {
        System.out.print("Давайте попробуем добавить элемент." + "\n" + "Как вы хотите, чтобы его звали?  ");
        String name = reader.getLine();
        if (  name.equals("") || name == null) {
            System.out.println("Ноль это не имя");
            return;
        }
        person.setName(name);
        Add_if_max.hasName = true;
    }
    /**
     * Метод добавления дня рождения в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void add_if_maxBirthday (Reader reader, Collection c, Person person) throws IOException {
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
        Add_if_max.hasBirthday = true;
    }

    /**
     * Метод добавления координат в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void add_if_maxCoordinates (Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Координаты, пожалуйста." + "\n" + "int X = ");
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
        Add_if_max.hasCoordinates = true;
    }


    /**
     * Метод добавления поля Height в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void add_if_maxHeight(Reader reader, Collection c, Person person) throws IOException {
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
        Add_if_max.hasHeight = true;
    }
    /**
     * Метод добавления поля HairColor в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void add_if_maxHairColor(Reader reader, Collection c, Person person) throws IOException {
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
        Add_if_max.hasHairColor = true;
    }
    /**
     * Метод добавления поля Nationality в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void add_if_maxNationality(Reader reader, Collection c, Person person) throws IOException {
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
        Add_if_max.hasNationality = true;
    }
    /**
     * Метод добавления поля Location в элемент
     * @param reader объект - считыватель
     * @param c коллекция
     * @param person объект
     * @throws IOException
     */
    protected static void add_if_maxLocation (Reader reader, Collection c, Person person) throws IOException {
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
        Add_if_max.hasLocation = true;
    }

}
