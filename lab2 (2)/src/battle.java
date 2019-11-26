import ru.ifmo.se.pokemon.*;
public class battle {
    public static void main (String [] args){
        Battle b = new Battle();
        b.addAlly(new Corso1a  ("Pinkball", 9));
        b.addAlly(new Venonat ("Blueball",9));
        b.addAlly(new Venomoth ("Blueball Sr.",9));
        b.addFoe (new Elekid ("Yellowball",9));
        b.addFoe (new Electabuzz ("DJ",9));
        b.addFoe (new Electivire ("Overgrownsocket",9));
        b.go();
    }
}
