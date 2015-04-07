package bowling;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class FrameTest {
    private Frame frame;

    @Before
    public void setUp() throws Exception {
        frame = new Frame();
    }

    @Test
    public void shouldRoll() {
        frame.roll(5);
    }

    @Test
    public void shouldKnowPoints() {
        frame.roll(5);
        assertEquals(5, frame.getPoints());

        frame.roll(4);
        assertEquals(9, frame.getPoints());
    }

    @Test
    public void shouldEndAfterTwoRolls() {
        frame.roll(5);
        frame.roll(5);

        assertTrue(frame.hasEnded());
    }

    @Test
    public void shouldNotEndWithoutRoll() {
        assertFalse(frame.hasEnded());
    }

    @Test
    public void shouldEndOnStrike() {
        frame.roll(10);
        assertTrue(frame.hasEnded());
    }

    @Test
    public void shouldStrike() {
        frame.roll(10);
        assertTrue(frame.isStrike());
    }

    @Test
    public void shouldNotStrike() {
        frame.roll(5);
        assertFalse(frame.isStrike());
        frame.roll(5);
        assertFalse(frame.isStrike());
    }

    @Test
    public void shouldSpare() {
        frame.roll(3);
        frame.roll(7);
        assertTrue(frame.isSpare());
    }

    @Test
    public void shouldNotSpare() {
        frame.roll(10);
        assertFalse(frame.isSpare());
    }

    @Test
    public void shouldIgnoreMoreThanTwoRolls() {
        frame.roll(1);
        frame.roll(2);
        frame.roll(3);
        assertEquals(3, frame.getPoints());

        frame = new Frame();
        frame.roll(10);
        frame.roll(2);
        assertEquals(10, frame.getPoints());
    }
}
