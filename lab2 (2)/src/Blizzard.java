import ru.ifmo.se.pokemon.*;
public class Blizzard  extends SpecialMove{
    public Blizzard () {
        super(Type.ICE, 110, 70);
    }
    protected java.lang.String describe (){
        return "Использует Blizzard" ;
    }
    protected void applyOppEffects (Pokemon p) {
        if (Math.random()<=0.1) Effect.freeze(p);
    }
}