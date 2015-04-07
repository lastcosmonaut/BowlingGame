package bowling;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class LastFrameTest {

    private LastFrame lastFrame;

    @Before
    public void setUp() throws Exception {
        lastFrame = new LastFrame();
    }

    @Test
    public void shouldEndWithTwoRolls() {
        lastFrame.roll(2);
        lastFrame.roll(2);
        assertTrue(lastFrame.hasEnded());
    }

    @Test
    public void shouldNotEndAfterSpare() {
        lastFrame.roll(3);
        lastFrame.roll(7);
        assertFalse(lastFrame.hasEnded());
    }

    @Test
    public void shouldNotEndAfterStrike() {
        lastFrame.roll(10);
        assertFalse(lastFrame.hasEnded());
        lastFrame.roll(10);
        assertFalse(lastFrame.hasEnded());
    }

    @Test
    public void shouldEndAfterThreeRollsWhenFirstWasStrike() {
        lastFrame.roll(10);
        lastFrame.roll(2);
        lastFrame.roll(2);
        assertTrue(lastFrame.hasEnded());
    }

    @Test
    public void shouldEndAfterThreeStrikes() {
        lastFrame.roll(10);
        lastFrame.roll(10);
        lastFrame.roll(10);
        assertTrue(lastFrame.hasEnded());
        assertEquals(30, lastFrame.getPoints());
    }
}
