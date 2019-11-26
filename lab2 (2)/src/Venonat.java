import ru.ifmo.se.pokemon.*;
public class Venonat extends Pokemon {
    public Venonat (String name, int level)  {
        super (name, level);
        setStats(60,55,50,40,55,45);
        setType (Type.BUG, Type.POISON);
        setMove( new Slam (), new Swagger (), new DoubleTeam ());
    }
}
