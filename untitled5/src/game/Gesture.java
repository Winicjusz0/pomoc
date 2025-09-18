package game;

public enum Gesture {
    ROCK,
    PAPER,
    SCISSORS;

    public static Gesture fromString(String letter){
        if (letter.equals("r")){
            return Gesture.ROCK;
        }
        if (letter.equals("p")){
            return Gesture.PAPER;
        }
        if (letter.equals("s")){
            return Gesture.SCISSORS;
        }
        return null;
    }

    public int compareWith(Gesture gesture){
        if (this.equals(ROCK)){
            if (gesture.equals(PAPER)){
                return -1;
            }
            if (gesture.equals(SCISSORS)){
                return 1;
            }
        }
        if (this.equals(PAPER)){
            if (gesture.equals(SCISSORS)){
                return -1;
            }
            if (gesture.equals(ROCK)){
                return 1;
            }
        }
        if (this.equals(SCISSORS)){
            if (gesture.equals(ROCK)){
                return -1;
            }
            if (gesture.equals(PAPER)){
                return 1;
            }
        }
        return 0;
    }
}