import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siberis on 12/21/2016.
 */
public class Day15Test {
    @Test
    public void test1() {
        Day15 d = new Day15();
        String input="Disc #1 has 5 positions; at time=0, it is at position 4.\n" +
                "Disc #2 has 2 positions; at time=0, it is at position 1.";
        Assert.assertEquals(5, d.findTime(input));
    }

    @Test
    public void FinalA() {
        Day15 d = new Day15();
        String input="Disc #1 has 13 positions; at time=0, it is at position 11.\n" +
                "Disc #2 has 5 positions; at time=0, it is at position 0.\n" +
                "Disc #3 has 17 positions; at time=0, it is at position 11.\n" +
                "Disc #4 has 3 positions; at time=0, it is at position 0.\n" +
                "Disc #5 has 7 positions; at time=0, it is at position 2.\n" +
                "Disc #6 has 19 positions; at time=0, it is at position 17.";
        Assert.assertEquals(122318, d.findTime(input));
    }
    @Test
    public void FinalB() {
        Day15 d = new Day15();
        String input="Disc #1 has 13 positions; at time=0, it is at position 11.\n" +
                "Disc #2 has 5 positions; at time=0, it is at position 0.\n" +
                "Disc #3 has 17 positions; at time=0, it is at position 11.\n" +
                "Disc #4 has 3 positions; at time=0, it is at position 0.\n" +
                "Disc #5 has 7 positions; at time=0, it is at position 2.\n" +
                "Disc #6 has 19 positions; at time=0, it is at position 17.\n" +
                "Disc #7 has 11 positions; at time=0, it is at position 0.";
        Assert.assertEquals(3208583, d.findTime(input));
    }
}
