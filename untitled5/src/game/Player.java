package game;

public class Player {
    public Duel duel;

    public void makeGesture(Gesture gesture){
        duel.handleGesture(this, gesture);
    }

    public void enterDuel(Duel duel){

    }

    public void leaveDuel(){
        duel = null;
    }

    public boolean isDuelling(){
        if (duel != null){
            return true;
        }
        return false;
    }
}
