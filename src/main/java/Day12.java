import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day12 {

    public int perform(String data,Map<String, Integer> registers) {
        String[] inst = data.split("\n");
        int pos = 0;
        while (true) {
            for (; pos < inst.length; pos++) {
                if (inst[pos].startsWith("jnz")) {
                    String[] x = inst[pos].split(" ");
                    if (registers.containsKey(x[1])) {
                        if (registers.get(x[1]) != 0) {
                            pos += Integer.parseInt(x[2])-1;
                        }
                    } else {
                        if (Integer.parseInt(x[1]) != 0) {
                            pos += Integer.parseInt(x[2])-1;
                        }
                    }
                } else if (inst[pos].startsWith("inc")) {
                    registers = inc(registers, "" + inst[pos].charAt(4));
                } else if (inst[pos].startsWith("dec")) {
                    registers = dec(registers, "" + inst[pos].charAt(4));
                } else {
                    String[] x = inst[pos].split(" ");
                    registers = cpy(registers, x[1], x[2]);
                }
            }
            if (pos >= inst.length)
                break;
        }
        return registers.get("a");

    }

    private Map<String, Integer> cpy(Map<String, Integer> regs, String from, String to) {
        Map<String, Integer> res = Maps.newHashMap();
        res.putAll(regs);
        if (res.containsKey(from)) {
            res.put(to, res.get(from));
        } else {
            res.put(to, Integer.parseInt(from));
        }
        return res;
    }

    private Map<String, Integer> inc(Map<String, Integer> regs, String r) {
        Map<String, Integer> res = Maps.newHashMap();
        res.putAll(regs);
        res.put(r, res.get(r) + 1);
        return res;
    }

    private Map<String, Integer> dec(Map<String, Integer> regs, String r) {
        Map<String, Integer> res = Maps.newHashMap();
        res.putAll(regs);
        res.put(r, res.get(r) - 1);
        return res;
    }
}
