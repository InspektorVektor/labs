import ru.ifmo.se.pokemon.*;
public class IceBeam  extends SpecialMove{
    public IceBeam () {
        super(Type.ICE, 90, 100);
    }
    protected java.lang.String describe (){
        return "Использует Ice Beam" ;
    }
    protected  void applyOppEffects (Pokemon p) {
        if (Math.random()<=0.1)  Effect.freeze(p);
    }
}