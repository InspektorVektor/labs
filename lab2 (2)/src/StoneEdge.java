import ru.ifmo.se.pokemon.*;
public class StoneEdge  extends PhysicalMove{
    public StoneEdge () {
        super(Type.ROCK, (100+(int)(Math.random()+0.25)*100), 80);

    }
    protected java.lang.String describe (){
        return "Использует StoneEdge" ;
    }
}