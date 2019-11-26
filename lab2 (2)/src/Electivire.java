import ru.ifmo.se.pokemon.*;

public class Electivire  extends Pokemon {
    public Electivire  (String name, int level)  {
        super (name, level);
        setStats(75,123,67,95,85,95);
        setType (Type.ELECTRIC);
        setMove( new Blizzard(), new Swagger(),
                new Scald (), new Thunderbolt());
    }
}