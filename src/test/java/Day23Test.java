import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * Created by siberis on 12/23/2016.
 */
public class Day23Test {
    @Test
    public void test() {
        Day23 d = new Day23();
        String data = "cpy 2 a\n" +
                "tgl a\n" +
                "tgl a\n" +
                "tgl a\n" +
                "cpy 1 a\n" +
                "dec a\n" +
                "dec a";
        Map<String, Integer> registers = Maps.newHashMap();
        registers.put("a", 0);
        registers.put("b", 0);
        registers.put("c", 0);
        registers.put("d", 0);
        Assert.assertEquals(3, d.perform(data, registers));
    }

    @Test
    public void FinalA() {
        Day23 d = new Day23();
        String data = "cpy a b\n" +
                "dec b\n" +
                "cpy a d\n" +
                "cpy 0 a\n" +
                "cpy b c\n" +
                "inc a\n" +
                "dec c\n" +
                "jnz c -2\n" +
                "dec d\n" +
                "jnz d -5\n" +
                "dec b\n" +
                "cpy b c\n" +
                "cpy c d\n" +
                "dec d\n" +
                "inc c\n" +
                "jnz d -2\n" +
                "tgl c\n" +
                "cpy -16 c\n" +
                "jnz 1 c\n" +
                "cpy 95 c\n" +
                "jnz 95 d\n" +
                "inc a\n" +
                "inc d\n" +
                "jnz d -2\n" +
                "inc c\n" +
                "jnz c -5";
        Map<String, Integer> registers = Maps.newHashMap();
        registers.put("a", 7);
        registers.put("b", 0);
        registers.put("c", 0);
        registers.put("d", 0);
        Assert.assertEquals(14065, d.perform(data, registers));
    }

    @Test
    public void FinalB() {
        Day23 d = new Day23();
        String data = "cpy a b\n" +
                "dec b\n" +
                "cpy a d\n" +
                "cpy 0 a\n" +

                "cpy b e\n" +
                "mul e d\n" +
                "add a e\n" +
                "cpy 0 c\n" +
                "cpy 0 d\n" +
                "cpy 0 e\n" +

                "dec b\n" +
                "cpy b c\n" +
                "cpy c d\n" +
                "dec d\n" +
                "inc c\n" +
                "jnz d -2\n" +
                "tgl c\n" +
                "cpy -16 c\n" +
                "jnz 1 c\n" +
                "cpy 95 c\n" +
                "jnz 95 d\n" +
                "inc a\n" +
                "inc d\n" +
                "jnz d -2\n" +
                "inc c\n" +
                "jnz c -5";
        Map<String, Integer> registers = Maps.newHashMap();
        registers.put("a", 12);
        registers.put("b", 0);
        registers.put("c", 0);
        registers.put("d", 0);
        registers.put("e", 0);
        Assert.assertEquals(479010625, d.perform(data, registers));
    }
}
