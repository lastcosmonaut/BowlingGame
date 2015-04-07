package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    protected List<Integer> rolls = new ArrayList<Integer>();

    public void roll(int numberOfPins) {
        if (!hasEnded()) {
            rolls.add(numberOfPins);
        }
    }

    public int getPoints() {
        int points = 0;

        for (Integer roll : rolls) {
            points += roll;
        }

        return points;
    }

    public boolean hasEnded() {
        return rolls.size() == 2 || getPoints() == 10;
    }

    public boolean isStrike() {
        return !rolls.isEmpty() && rolls.get(0) == 10;
    }

    public boolean isSpare() {
        return rolls.size() == 2 && getPoints() == 10;
    }

    public int getPointsOfFirstRoll() {
        return rolls.isEmpty() ? 0 : rolls.get(0);
    }
}
