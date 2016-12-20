import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day14Test {
    @Test
    public void test1() {
        Day14 d = new Day14();
        Assert.assertEquals(22728, d.computeLastIndex("abc"));
    }
    @Test
    public void test2() {
        Day14 d = new Day14();
        Assert.assertEquals(22551, d.computeLastIndexExtra("abc"));
    }

    @Test
    public void FinalA() {
        Day14 d = new Day14();
        Assert.assertEquals(15168, d.computeLastIndex("qzyelonm"));
    }

    @Test
    public void FinalB() {
        Day14 d = new Day14();
        Assert.assertEquals(20864, d.computeLastIndexExtra("qzyelonm"));
    }

}
