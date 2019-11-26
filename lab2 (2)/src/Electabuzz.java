import ru.ifmo.se.pokemon.Pokemon;
        import ru.ifmo.se.pokemon.Type;

public class Electabuzz extends Pokemon {
    public Electabuzz (String name, int level)  {
        super (name, level);
        setStats(65,83,57,95,85,105);
        setType (Type.ELECTRIC);
        setMove( new Blizzard(), new Swagger(),
                new Scald ());
    }
}