package game;

public class Duel {
    Player p1;
    Player p2;
    Gesture g1;
    Gesture g2;

    public Duel(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.p1.enterDuel(this);
        this.p2.enterDuel(this);
    }

    public void handleGesture(Player player, Gesture gesture){
        if (player.equals(p1)){
            g1 = gesture;
        }
        else if (player.equals(p2)){
            g2 = gesture;
        }
    }

    public Result evaluate(){
        int wynik = g1.compareWith(g2);
        if (wynik == 1){
            return new Result(p1, p2);
        }
        if (wynik == -1){
            return new Result(p2, p1);
        }
        return null;
    }
}
