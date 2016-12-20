import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day13Test {
    @Test
    public void test1() {
        Day13 d = new Day13();
        Assert.assertEquals(11, d.findPath(7, 4, 10));
    }

    @Test
    public void test2() {
        Day13 d = new Day13();
        Assert.assertEquals(6, d.countReachable(3, 10));
    }

    @Test
    public void FinalA() {
        Day13 d = new Day13();
        Assert.assertEquals(90, d.findPath(31, 39, 1352));
    }

    @Test
    public void FinalB() {
        Day13 d = new Day13();
        Assert.assertEquals(135, d.countReachable(50, 1352));
    }

}
