import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siberis on 12/19/2016.
 */
public class Day5Test {
    @Test
    public void Test1() {
        Day5 d = new Day5();
        Assert.assertEquals("1a3099aa", d.calculateHash("uqwqemis"));
    }
    @Test
    public void Test2() {
        Day5 d = new Day5();
        Assert.assertEquals("18f47a30", d.calculateHash("abc"));
    }
    @Test
    public void Test3() {
        Day5 d = new Day5();
        Assert.assertEquals("05ace8e3", d.calculateHash2("abc"));
    }
    @Test
    public void Test4() {
        Day5 d = new Day5();
        Assert.assertEquals("694190cd", d.calculateHash2("uqwqemis"));
    }
}
