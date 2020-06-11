package Commands;

import Readers.*;
import App.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 * Команда  "ПРАВКИ!"
 */
public class Updater {
    static String description ="update id {element} : обновить значение элемента коллекции, id которого равен заданному.";
    static boolean changedName = false;  // показывает, было ли изменено имя элемента
    static boolean changedCoordinates = false; // показывает, было ли изменено поле coordinates
    static boolean changedHairColor = false; //показывает, было ли изменено поле from
    static boolean changedNationality = false; // показывает, было ли изменено поле to
    static boolean changedLocation = false; // показывает, было ли изменено поле distance
    static boolean changedBirthday = false;
    static boolean changedHeight = false;
    /**
     * Метод для изменения значений элемента по id
     * @param reader объект - считыватель
     * @param c коллекция
     * @param s2 id
     * @throws IOException
     */
    public static void update (Reader reader, Collection c, String s2) throws IOException {
        if (s2==null | s2.equals("")) {
            System.out.println("кажется вы забыли ввести айди");
            return;
        }

        int id = Checker.intChecker(s2);
        Person r = c.searchById(id);
        if (r ==null) {System.out.println("похоже элемента с таким айди не существует");
            return;
        }


        System.out.print("\n" +"Давайте попробуем изменить элемент по введённому айди." + "\n" +
                "Раньше его звали \""+ r.getName() );
        while (!changedName) changeName(reader, c, r);
        System.out.print("\n" +"Раньше координаты были  "+  r.getCoordinates() );
        while (!changedCoordinates) changeCoordinates(reader, c, r);

        System.out.print("\n" +"Раньше цвет волос был "+r.getHairColor());
        while (!changedHairColor) changeHairColor(reader, c, r);
        System.out.print("\n" +"Раньше Nationality было "+r.getNationality());
        while (!changedNationality) changeNationality(reader, c, r);
        System.out.print("\n" +"Раньше Location было "+r.getLocation());
        while (!changedLocation) changeLocation(reader, c, r);
        System.out.print("\n" +"Раньше Birthday было "+r.getBirthday());
        while (!changedBirthday) changeBirthday(reader, c, r);
        System.out.print("\n" +"Раньше Height было "+r.getHeight());
        while (!changedHeight) changeHeight(reader, c, r);
        System.out.println("\n" +"Вы достигли успеха в замене элемента по айди!");

        changedName = false;
        changedCoordinates = false;
        changedHairColor =false;
        changedNationality = false;
        changedLocation = false;
        changedBirthday = false;
        changedHeight = false;

    }



    /**
     * Метод изменения имени в элемент
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     * @param person  объект
     * @throws IOException
     */
    protected static void changeName(Reader reader, Collection c, Person person) throws IOException {
        System.out.print( "\n" + "Как вы хотите, чтобы его звали?  ");
        String name = reader.getLine()+"";
        if (name.equals("") ) {
            System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
            return;
        }
        person.setName(name);
        Updater.changedName = true;
    }

    protected static void changeNationality(Reader reader, Collection c, Person person) throws IOException {
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

    protected static void changeHairColor(Reader reader, Collection c, Person person) throws IOException {
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
     * Метод изменения координат в элемент
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     * @param person  объект
     * @throws IOException
     */
    protected static void changeCoordinates(Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Координаты, пожалуйста." + "\n" + "Double X = ");
        String s = reader.getLine()+"";
        if (s.equals("") ) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        double coordinateX;
        try {
            coordinateX = Checker.doubleChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate X должно быть типа Double." + "\n Попробуем ещё разок!");
            return;
        }
        if (coordinateX <= -522) {
            System.out.println("Coordinate x должно быть больше -522");
            return;
        }

        System.out.print("double Y = ");
        double coordinateY;
        try {
            coordinateY = Checker.doubleChecker(reader.getLine());
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. Coordinate Y должно быть типа double" + "\n Попробуем ещё разок!");
            return;
        }
        if (coordinateY <= -256) {
            System.out.println("Coordinate y должно быть больше -256");
            return;
        }

        person.setCoordinates(new Coordinates(coordinateX, coordinateY));
        Updater.changedCoordinates = true;
    }

    protected static void changeBirthday (Reader reader, Collection c, Person person) throws IOException {
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
     * Метод изменения поля Location в элемент
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     * @param person  объект
     * @throws IOException
     */
    protected static void changeLocation(Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Location" + "\n" + "locationX = ");

        String s = reader.getLine()+"";
        if (s.equals("") ) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        float locationX;
        try {
            locationX = Checker.floatChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. locationX должно быть типа float." + "\n Попробуем ещё разок!");
            return;
        }
        System.out.print("locationY = ");
        float locationY;
        try {
            locationY = Checker.floatChecker(reader.getLine());
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. locationY должно быть типа Float." + "\n Попробуем ещё разок!");
            return;
        }
        System.out.print("locationZ = ");
        int locationZ;
        try {
            locationZ = Checker.intChecker(reader.getLine());
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. locationZ должно быть типа Integer." + "\n Попробуем ещё разок!");
            return;
        }

        System.out.print("Название локации:  ");
        String locationName = reader.getLine();
        if (locationName.equals("") || locationName == null) {
            System.out.println("Пустая строка ни к чему не приведёт. Пока ты смотришь в пустую строку, пустая строка смотрит в тебя...");
            return;
        }
        person.setLocation(new Location(locationX, locationY, locationZ,  locationName));
        Updater.changedLocation = true;
    }


    /**
     * Метод изменения поля Height в элемент
     *
     * @param reader объект - считыватель
     * @param c      коллекция
     * @param person  объект
     * @throws IOException
     */
    protected static void changeHeight(Reader reader, Collection c, Person person) throws IOException {
        System.out.print("\n" + "Height" + "\n" + "Double x = ");
        String s = reader.getLine()+"";
        if (s.equals("") ) {
            System.out.println("Введена пустая строка. Не надо так.");
            return;
        }
        double HeightX;
        try {
            HeightX = Checker.doubleChecker(s);
        } catch (NullPointerException e) {
            System.out.println("Неправильный тип. Height (X) должно быть типа double." + "\n Попробуем ещё разок!");
            return;
        }
        if (!(HeightX > 0)) {
            System.out.println("Значение Height должно быть больше 0");
            return;
        }
        person.setHeight(HeightX);
        Updater.changedHeight = true;
    }


}



