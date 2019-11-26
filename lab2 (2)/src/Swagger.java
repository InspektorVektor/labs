import ru.ifmo.se.pokemon.*;
public class Swagger extends StatusMove{
    public Swagger(){
        super(Type.NORMAL,0,85);
    }
    protected void applyOppEffects(Pokemon p) {
        Effect e = new Effect().turns(1).stat(Stat.SPECIAL_ATTACK, 2);
        p.addEffect(e);
    }
    protected java.lang.String describe(){
        return "использует Swagger";
    }

}