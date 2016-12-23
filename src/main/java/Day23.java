import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

/**
 * Created by siberis on 12/23/2016.
 */
public class Day23 {

    public int perform(String data, Map<String, Integer> registers) {
        String[] inst = data.split("\n");
        Set<Integer> toggled = Sets.newHashSet();
        int pos = 0;
        while (true) {
            for (; pos < inst.length; pos++) {
                if (inst[pos].startsWith("jnz")) {
                    if (toggled.contains(pos)) {
                        String[] x = inst[pos].split(" ");
                        if (registers.containsKey(x[2])) {
                            registers = cpy(registers, x[1], x[2]);
                        }
                    } else {
                        pos = jnzLogic(registers, inst[pos], pos);
                    }
                } else if (inst[pos].startsWith("inc")) {
                    if (toggled.contains(pos)) {
                        registers = dec(registers, "" + inst[pos].charAt(4));
                    } else {
                        registers = inc(registers, "" + inst[pos].charAt(4));
                    }
                } else if (inst[pos].startsWith("dec")) {
                    if (toggled.contains(pos)) {
                        registers = inc(registers, "" + inst[pos].charAt(4));
                    } else {
                        registers = dec(registers, "" + inst[pos].charAt(4));
                    }
                } else if (inst[pos].startsWith("tgl")) {
                    if (toggled.contains(pos)) {
                        registers = inc(registers, "" + inst[pos].charAt(4));
                    } else {
                        int x = registers.get("" + inst[pos].charAt(4));
                        if (!toggled.contains(pos + x)) {
                            toggled.add(pos + x);
                        } else {
                            toggled.remove(pos + x);
                        }
                    }
                } else if (inst[pos].startsWith("mul")) {
                    String[] x = inst[pos].split(" ");
                    int a = registers.get(x[1]);
                    int b = registers.get(x[2]);
                    registers.put(x[1], a * b);
                }else if (inst[pos].startsWith("add")) {
                    String[] x = inst[pos].split(" ");
                    int a = registers.get(x[1]);
                    int b = registers.get(x[2]);
                    registers.put(x[1], a + b);
                } else {
                    if (toggled.contains(pos)) {
                        pos = jnzLogic(registers, inst[pos], pos);
                    } else {
                        String[] x = inst[pos].split(" ");
                        registers = cpy(registers, x[1], x[2]);
                    }
                }
                System.out.println(registers);
            }
            if (pos >= inst.length)
                break;
        }
        return registers.get("a");

    }

    private int jnzLogic(Map<String, Integer> registers, String s, int pos) {
        String[] x = s.split(" ");
        if (registers.containsKey(x[1])) {
            if (registers.get(x[1]) != 0) {
                pos += Integer.parseInt(x[2]) - 1;
            }
        } else {
            if (!registers.containsKey(x[2])) {
                if (Integer.parseInt(x[1]) != 0) {
                    pos += Integer.parseInt(x[2]) - 1;
                }
            } else {
                if (Integer.parseInt(x[1]) != 0) {
                    pos += registers.get(x[2]) - 1;
                }
            }
        }
        return pos;
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
