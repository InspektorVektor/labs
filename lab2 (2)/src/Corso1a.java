import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Corso1a extends Pokemon {
    public Corso1a(String name, int level)  {
        super (name, level);
        setStats(65,55,95,65,95,35);
        setType (Type.ROCK, Type.WATER);
        setMove( new StoneEdge(), new ScaryFace(),
                new Magnitude (), new IceBeam () );
    }
}