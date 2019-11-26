import ru.ifmo.se.pokemon.*;
public class DoubleTeam  extends StatusMove{
    public DoubleTeam () {
        super(Type.NORMAL, 0, 0);
    }
    protected java.lang.String describe (){
        return "Использует Double Team";
    }
    protected void applySelfEffects(Pokemon p){
        p.setMod(Stat.EVASION , 1);
    }
}