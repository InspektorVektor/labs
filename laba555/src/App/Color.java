package App;


import javax.xml.bind.annotation.XmlEnum;
/**
 * Список Цветов
 */
@XmlEnum
public enum Color {
    GREEN("зеленый"),
    RED("красный"),
    YELLOW("желтый"),
    BROWN("коричневый");

    private String str;

    Color(String str) {
        this.str = str;
    }

    public static Color getValue(String value) {
        for (Color color : Color.values()) {
            if (color.str.equals(value)) return color;
        }
        return null;
    }

}

