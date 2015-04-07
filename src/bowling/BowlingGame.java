package bowling;


import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private List<Frame> frames;
    private int currentFrame;

    public BowlingGame() {
        frames = new ArrayList<Frame>();

        for (int i = 0; i < 9; i++) {
            frames.add(new Frame());
        }

        frames.add(new LastFrame());
    }

    public int getPoints() {
        int points = 0;

        for (int i = 0, framesSize = frames.size(); i < framesSize; i++) {
            Frame frame = frames.get(i);
            points += frame.getPoints();

            Frame nextFrame = i + 1 == framesSize ? new Frame() : frames.get(i + 1);

            if (frame.isSpare()) {
                points += nextFrame.getPointsOfFirstRoll();
            } else if (frame.isStrike()) {
                points += nextFrame.getPoints();

                if (nextFrame.isStrike()) {
                    Frame otherFrame = i + 2 == framesSize ? new Frame() : frames.get(i + 2);
                    points += otherFrame.getPointsOfFirstRoll();
                }
            }
        }

        return points;
    }

    public void roll(int numberOfPins) {
        Frame frame = frames.get(currentFrame);
        frame.roll(numberOfPins);

        if (frame.hasEnded()) {
            currentFrame++;
        }
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public Frame getCurrentFrame() {
        return frames.get(currentFrame);
    }
}
