import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Venomoth extends Pokemon {
    public Venomoth (String name, int level)  {
        super (name, level);
        setStats(70,65,60,90,75,90);
        setType (Type.BUG, Type.POISON);
        setMove( new Slam(), new Swagger(),
                new DoubleTeam (), new Thunderbolt () );
    }
}