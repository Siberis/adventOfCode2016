import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siberis on 12/21/2016.
 */
public class Day19Test {

    @Test
    public void test1() {
        Day19 d = new Day19();
        Assert.assertEquals(3, d.computeElf(5));
    }
    @Test
    public void test2() {
        Day19 d = new Day19();
        Assert.assertEquals(15, d.computeElf(15));
    }
    @Test
    public void test3() {
        Day19 d = new Day19();
        Assert.assertEquals(3, d.computeElf(17));
    }
    @Test
    public void test8() {
        Day19 d = new Day19();
        Assert.assertEquals(2, d.computeElf2(5));
    }
    @Test
    public void test4() {
        Day19 d = new Day19();
        Assert.assertEquals(6, d.computeElf2(15));
    }
    @Test
    public void test5() {
        Day19 d = new Day19();
        Assert.assertEquals(8, d.computeElf2(17));
    }
    @Test
    public void test6() {
        Day19 d = new Day19();
        Assert.assertEquals(15, d.computeElf2(21));
    }
    @Test
    public void test10() {
        Day19 d = new Day19();
        Assert.assertEquals(13, d.computeElf2(20));
    }
    @Test
    public void test7() {
        Day19 d = new Day19();
        Assert.assertEquals(9, d.computeElf2(9));
    }
    @Test
    public void test11() {
        Day19 d = new Day19();
        Assert.assertEquals(2, d.computeElf2(11));
    }
    @Test
    public void test12() {
        Day19 d = new Day19();
        Assert.assertEquals(5, d.computeElf2(7));
    }
    @Test
    public void FinalA() {
        Day19 d = new Day19();
        Assert.assertEquals(1834471, d.computeElf(3014387));
    }
    @Test
    public void FinalB() {
        Day19 d = new Day19();
        Assert.assertEquals(154439, d.computeElf2(3014387));
        Assert.fail();
    }
}
