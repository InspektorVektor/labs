import ru.ifmo.se.pokemon.*;
public class Magnitude  extends PhysicalMove{
    double p=0;
    public Magnitude () {
        super(Type.GROUND, (int)(Math.random() * 140) + 10, 100);
    }
    protected java.lang.String describe (){
        return "Использует Magnitude";
    }
}