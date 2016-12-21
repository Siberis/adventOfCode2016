import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siberis on 12/21/2016.
 */
public class Day17Test {
    @Test
    public void test1() {
        Day17 d = new Day17();
        Assert.assertEquals("DDRRRD", d.findPath("ihgpwlah"));
    }

    @Test
    public void test2() {
        Day17 d = new Day17();
        Assert.assertEquals("DDUDRLRRUDRD", d.findPath("kglvqrro"));
    }

    @Test
    public void test3() {
        Day17 d = new Day17();
        Assert.assertEquals("DRURDRUDDLLDLUURRDULRLDUUDDDRR", d.findPath("ulqzkmiv"));
    }
    @Test
    public void test1b() {
        Day17 d = new Day17();
        Assert.assertEquals(370, d.longestPath("ihgpwlah"));
    }

    @Test
    public void test2b() {
        Day17 d = new Day17();
        Assert.assertEquals(492, d.longestPath("kglvqrro"));
    }

    @Test
    public void test3b() {
        Day17 d = new Day17();
        Assert.assertEquals(830, d.longestPath("ulqzkmiv"));
    }
    @Test
    public void FinalA() {
        Day17 d = new Day17();
        Assert.assertEquals("DDURRLRRDD", d.findPath("bwnlcvfs"));
    }
    @Test
    public void FinalB() {
        Day17 d = new Day17();
        Assert.assertEquals(436, d.longestPath("bwnlcvfs"));
    }
}
