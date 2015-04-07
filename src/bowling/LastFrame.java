package bowling;

public class LastFrame extends Frame {
    @Override
    public boolean hasEnded() {
        boolean hasEnded = false;

        if (rolls.size()==2 && !isSpare() && !isStrike()) {
            hasEnded = true;
        } else if (rolls.size() == 3 && (isSpare() || isStrike())) {
            hasEnded = true;
        }

        return hasEnded;
    }
}
