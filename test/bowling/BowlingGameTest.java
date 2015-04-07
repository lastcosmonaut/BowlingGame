package bowling;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() throws Exception {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void shouldHaveTenFrames() {
        assertEquals(10, bowlingGame.getFrames().size());
    }

    @Test
    public void shouldHaveTwoRollsPerFrame() {
        bowlingGame.roll(2);
        bowlingGame.roll(2);

        assertEquals(bowlingGame.getFrames().get(1), bowlingGame.getCurrentFrame());
        assertEquals(4, bowlingGame.getPoints());
    }

    @Test
    public void shouldHaveResult() {
        assertEquals(0, bowlingGame.getPoints());
    }

    @Test
    public void shouldGetPointsForThrow() {
        bowlingGame.roll(5);
        assertEquals(5, bowlingGame.getPoints());
    }

    @Test
    public void shouldCountSpare() {
        bowlingGame.roll(4);
        bowlingGame.roll(6);
        bowlingGame.roll(4);
        bowlingGame.roll(6);

        assertEquals(bowlingGame.getFrames().get(2), bowlingGame.getCurrentFrame());
        assertEquals(24, bowlingGame.getPoints());
    }

    @Test
    public void shouldCountStrike() {
        bowlingGame.roll(10);
        bowlingGame.roll(2);
        assertEquals(14, bowlingGame.getPoints());
        bowlingGame.roll(3);
        assertEquals(20, bowlingGame.getPoints());
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        assertEquals(80, bowlingGame.getPoints());
    }

    @Test
    public void shouldHaveFullPoints() {
        for (int i = 0; i < 12; i++) {
            bowlingGame.roll(10);
        }
        
        assertEquals(300, bowlingGame.getPoints());
    }
}
