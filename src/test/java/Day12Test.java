import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day12Test {
    @Test
    public void test1() {
        Day12 d = new Day12();
        String data = "cpy 41 a\n" +
                "inc a\n" +
                "inc a\n" +
                "dec a\n" +
                "jnz a 2\n" +
                "dec a";

        Map<String, Integer> registers = Maps.newHashMap();
        registers.put("a", 0);
        registers.put("b", 0);
        registers.put("c", 0);
        registers.put("d", 0);
        Assert.assertEquals(42, d.perform(data,registers));
    }

    @Test
    public void FinalA() {
        Day12 d = new Day12();
        String data = "cpy 1 a\n" +
                "cpy 1 b\n" +
                "cpy 26 d\n" +
                "jnz c 2\n" +
                "jnz 1 5\n" +
                "cpy 7 c\n" +
                "inc d\n" +
                "dec c\n" +
                "jnz c -2\n" +
                "cpy a c\n" +
                "inc a\n" +
                "dec b\n" +
                "jnz b -2\n" +
                "cpy c b\n" +
                "dec d\n" +
                "jnz d -6\n" +
                "cpy 16 c\n" +
                "cpy 17 d\n" +
                "inc a\n" +
                "dec d\n" +
                "jnz d -2\n" +
                "dec c\n" +
                "jnz c -5";
        Map<String, Integer> registers = Maps.newHashMap();
        registers.put("a", 0);
        registers.put("b", 0);
        registers.put("c", 0);
        registers.put("d", 0);
        Assert.assertEquals(318083, d.perform(data,registers));
    }

    @Test
    public void FinalB() {
        Day12 d = new Day12();
        String data = "cpy 1 a\n" +
                "cpy 1 b\n" +
                "cpy 26 d\n" +
                "jnz c 2\n" +
                "jnz 1 5\n" +
                "cpy 7 c\n" +
                "inc d\n" +
                "dec c\n" +
                "jnz c -2\n" +
                "cpy a c\n" +
                "inc a\n" +
                "dec b\n" +
                "jnz b -2\n" +
                "cpy c b\n" +
                "dec d\n" +
                "jnz d -6\n" +
                "cpy 16 c\n" +
                "cpy 17 d\n" +
                "inc a\n" +
                "dec d\n" +
                "jnz d -2\n" +
                "dec c\n" +
                "jnz c -5";
        Map<String, Integer> registers = Maps.newHashMap();
        registers.put("a", 0);
        registers.put("b", 0);
        registers.put("c", 1);
        registers.put("d", 0);
        Assert.assertEquals(9227737, d.perform(data,registers));
    }
}
