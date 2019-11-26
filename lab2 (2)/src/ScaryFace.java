import ru.ifmo.se.pokemon.*;
public class ScaryFace  extends StatusMove{
    public ScaryFace () {
        super(Type.NORMAL, 0, 100);
    }
    protected java.lang.String describe (){
        return "Использует ScaryFace";
    }
    protected void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPEED , -2);
    }
}