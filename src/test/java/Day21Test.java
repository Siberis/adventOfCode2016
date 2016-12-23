import org.junit.Assert;
import org.junit.Test;

/**
 * Created by siberis on 12/22/2016.
 */
public class Day21Test {
    @Test
    public void test1() {
        Day21 d = new Day21();
        String inst = "swap position 4 with position 0\n" +
                "swap letter d with letter b\n" +
                "reverse positions 0 through 4\n" +
                "rotate left 1 step\n" +
                "move position 1 to position 4\n" +
                "move position 3 to position 0\n" +
                "rotate based on position of letter b\n" +
                "rotate based on position of letter d";
        Assert.assertEquals("decab", d.transform("abcde", inst));
    }
    @Test
    public void test2() {
        Day21 d = new Day21();
        String inst = "swap position 4 with position 0\n" +
                "swap letter d with letter b\n" +
                "reverse positions 0 through 4\n" +
                "rotate left 1 step\n" +
                "move position 1 to position 4\n" +
                "move position 3 to position 0\n" +
                "rotate based on position of letter b\n" +
                "rotate based on position of letter d";
        Assert.assertEquals("abcde", d.reverseTransform("decab", inst));
    }
    @Test
    public void FinalA() {
        Day21 d = new Day21();
        Assert.assertEquals("ghfacdbe", d.transform("abcdefgh", data));
    }
    @Test
    public void FinalB() {
        Day21 d = new Day21();
        Assert.assertEquals("fhgcdaeb", d.reverseTransform("fbgdceah", data));
    }

    String data = "rotate based on position of letter d\n" +
            "move position 1 to position 6\n" +
            "swap position 3 with position 6\n" +
            "rotate based on position of letter c\n" +
            "swap position 0 with position 1\n" +
            "rotate right 5 steps\n" +
            "rotate left 3 steps\n" +
            "rotate based on position of letter b\n" +
            "swap position 0 with position 2\n" +
            "rotate based on position of letter g\n" +
            "rotate left 0 steps\n" +
            "reverse positions 0 through 3\n" +
            "rotate based on position of letter a\n" +
            "rotate based on position of letter h\n" +
            "rotate based on position of letter a\n" +
            "rotate based on position of letter g\n" +
            "rotate left 5 steps\n" +
            "move position 3 to position 7\n" +
            "rotate right 5 steps\n" +
            "rotate based on position of letter f\n" +
            "rotate right 7 steps\n" +
            "rotate based on position of letter a\n" +
            "rotate right 6 steps\n" +
            "rotate based on position of letter a\n" +
            "swap letter c with letter f\n" +
            "reverse positions 2 through 6\n" +
            "rotate left 1 step\n" +
            "reverse positions 3 through 5\n" +
            "rotate based on position of letter f\n" +
            "swap position 6 with position 5\n" +
            "swap letter h with letter e\n" +
            "move position 1 to position 3\n" +
            "swap letter c with letter h\n" +
            "reverse positions 4 through 7\n" +
            "swap letter f with letter h\n" +
            "rotate based on position of letter f\n" +
            "rotate based on position of letter g\n" +
            "reverse positions 3 through 4\n" +
            "rotate left 7 steps\n" +
            "swap letter h with letter a\n" +
            "rotate based on position of letter e\n" +
            "rotate based on position of letter f\n" +
            "rotate based on position of letter g\n" +
            "move position 5 to position 0\n" +
            "rotate based on position of letter c\n" +
            "reverse positions 3 through 6\n" +
            "rotate right 4 steps\n" +
            "move position 1 to position 2\n" +
            "reverse positions 3 through 6\n" +
            "swap letter g with letter a\n" +
            "rotate based on position of letter d\n" +
            "rotate based on position of letter a\n" +
            "swap position 0 with position 7\n" +
            "rotate left 7 steps\n" +
            "rotate right 2 steps\n" +
            "rotate right 6 steps\n" +
            "rotate based on position of letter b\n" +
            "rotate right 2 steps\n" +
            "swap position 7 with position 4\n" +
            "rotate left 4 steps\n" +
            "rotate left 3 steps\n" +
            "swap position 2 with position 7\n" +
            "move position 5 to position 4\n" +
            "rotate right 3 steps\n" +
            "rotate based on position of letter g\n" +
            "move position 1 to position 2\n" +
            "swap position 7 with position 0\n" +
            "move position 4 to position 6\n" +
            "move position 3 to position 0\n" +
            "rotate based on position of letter f\n" +
            "swap letter g with letter d\n" +
            "swap position 1 with position 5\n" +
            "reverse positions 0 through 2\n" +
            "swap position 7 with position 3\n" +
            "rotate based on position of letter g\n" +
            "swap letter c with letter a\n" +
            "rotate based on position of letter g\n" +
            "reverse positions 3 through 5\n" +
            "move position 6 to position 3\n" +
            "swap letter b with letter e\n" +
            "reverse positions 5 through 6\n" +
            "move position 6 to position 7\n" +
            "swap letter a with letter e\n" +
            "swap position 6 with position 2\n" +
            "move position 4 to position 5\n" +
            "rotate left 5 steps\n" +
            "swap letter a with letter d\n" +
            "swap letter e with letter g\n" +
            "swap position 3 with position 7\n" +
            "reverse positions 0 through 5\n" +
            "swap position 5 with position 7\n" +
            "swap position 1 with position 7\n" +
            "swap position 1 with position 7\n" +
            "rotate right 7 steps\n" +
            "swap letter f with letter a\n" +
            "reverse positions 0 through 7\n" +
            "rotate based on position of letter d\n" +
            "reverse positions 2 through 4\n" +
            "swap position 7 with position 1\n" +
            "swap letter a with letter h";
}
