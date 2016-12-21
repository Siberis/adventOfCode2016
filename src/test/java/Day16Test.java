import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siberis on 12/21/2016.
 */
public class Day16Test {
    @Test
    public void test1() {
        Day16 d = new Day16();
        Assert.assertEquals("01100", d.calculateChecksum("10000",20));
    }

    @Test
    public void FinalA() {
        Day16 d = new Day16();
        Assert.assertEquals("11100110111101110", d.calculateChecksum("10111100110001111",272));
    }
    @Test
    public void FinalB() {
        Day16 d = new Day16();
        Assert.assertEquals("10001101010000101", d.calculateChecksum("10111100110001111",35651584));
    }
}
