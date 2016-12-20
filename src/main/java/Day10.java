import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day10 {
    Map<String, List<Integer>> botState = new HashMap<>();
    Map<String, List<String>> botDef = new HashMap<>();

    public int process(String inst) {
        for (int i = 0; i < 100; i++) {
            botState.put("o" + Integer.toString(i), new ArrayList<>());
        }
        for (int i = 0; i < 100; i++) {
            botDef.put("o" + Integer.toString(i), new ArrayList<>());
        }
        for (int i = 0; i < 300; i++) {
            botState.put(Integer.toString(i), new ArrayList<>());
        }
        for (int i = 0; i < 300; i++) {
            botDef.put(Integer.toString(i), new ArrayList<>());
        }
        init(inst);
        Map<String, List<Integer>> nextLoop = new HashMap<>();
        while (true) {
            botState.entrySet().stream().forEach(entry -> {
                if (entry.getValue().size() == 2 && entry.getKey().length() > 0) {
                    entry.getValue().sort(Integer::compareTo);
                    botState.get(botDef.get(entry.getKey()).get(0)).add(entry.getValue().get(0));
                    botState.get(botDef.get(entry.getKey()).get(1)).add(entry.getValue().get(1));
                    entry.getValue().clear();
                }
                nextLoop.put(entry.getKey(), entry.getValue());
            });
            botState.clear();
            botState.putAll(nextLoop);
            nextLoop.clear();
            long next = botState.entrySet().stream().filter(e -> e.getValue().size() == 2).count();
            if (next == 0) {
                break;
            }
        }
        return botState.get("o0").get(0)*botState.get("o1").get(0)*botState.get("o2").get(0);
    }

    private void init(String inst) {
        String[] lines = inst.split("\n");
        Pattern addVal = Pattern.compile("value (\\d+) goes to bot (\\d+)");
        Pattern logic = Pattern.compile("bot (\\d+) gives low to ([a-z]+) (\\d+) and high to ([a-z]+) (\\d+)");
        for (String line : lines) {
            if (addVal.matcher(line).matches()) {
                Matcher matcher = addVal.matcher(line);
                matcher.find();
                String id = matcher.group(2);
                Integer value = Integer.parseInt(matcher.group(1));
                if (!botState.containsKey(id)) botState.put(id, new ArrayList<>());
                botState.get(id).add(value);
            } else {
                Matcher matcher = logic.matcher(line);
                matcher.find();
                String id = matcher.group(1);
                String t1name = matcher.group(2);
                String t1id = matcher.group(3);
                String t2name = matcher.group(4);
                String t2id = matcher.group(5);
                List<String> target = new ArrayList<>();
                if (t1name.equals("bot")) {
                    target.add(t1id);
                } else {
                    target.add("o" + t1id);
                }
                if (t2name.equals("bot")) {
                    target.add(t2id);
                } else {
                    target.add("o" + t2id);
                }
                botDef.put(id, target);
            }
        }
    }

    public String find(String inst, List<Integer> target) {
        for (int i = 0; i < 300; i++) {
            botState.put(Integer.toString(i), new ArrayList<>());
        }
        for (int i = 0; i < 300; i++) {
            botDef.put(Integer.toString(i), new ArrayList<>());
        }
        init(inst);
        Map<String, List<Integer>> nextLoop = new HashMap<>();
        while (true) {
            for (Map.Entry<String, List<Integer>> entry : botState.entrySet()) {
                if (entry.getValue().size() == 2 && entry.getKey().length() > 0) {
                    entry.getValue().sort(Integer::compareTo);
                    if (entry.getValue().containsAll(target))
                        return entry.getKey();
                    botState.get(botDef.get(entry.getKey()).get(0)).add(entry.getValue().get(0));
                    botState.get(botDef.get(entry.getKey()).get(1)).add(entry.getValue().get(1));
                    entry.getValue().clear();
                }
                nextLoop.put(entry.getKey(), entry.getValue());
            }
            botState.clear();
            botState.putAll(nextLoop);
            nextLoop.clear();
            long next = botState.entrySet().stream().filter(e -> e.getValue().size() == 2).count();
            if (next == 0) {
                break;
            }
        }
        return "";
    }
}
