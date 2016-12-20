import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by siberis on 12/19/2016.
 */
public class Day4 {
    public boolean test(String s) {
        int hashPos = s.indexOf("[");
        int endName = s.lastIndexOf("-");
        String id = s.substring(endName + 1, hashPos);
        String has = s.substring(hashPos + 1, s.length() - 1);
        String name = s.substring(0, endName).replace("-", "");
        List<Integer> hash = name.chars().mapToObj(x -> x).sorted().collect(Collectors.toList());
        Integer prev = null;
        int count = 0;
        Set<Map.Entry<Integer, Integer>> set = new HashSet<>();
        for (Integer i : hash) {
            if (prev != i) {
                set.add(new AbstractMap.SimpleImmutableEntry<>(prev, count));
                prev = i;
                count = 0;
            }
            count++;
        }
        set.add(new AbstractMap.SimpleImmutableEntry<>(prev, count));
        hash = set.stream().sorted((a, b) -> {
            int comp = -(a.getValue().compareTo(b.getValue()));
            if (comp == 0) {
                comp = a.getKey().compareTo(b.getKey());
            }
            return comp;
        }).map(e -> e.getKey()).collect(Collectors.toList());
        String res = "";
        for (Integer i : hash) {
            if (i == null) break;
            res += (char) i.intValue();
        }
        String substring = res.substring(0, has.length());
        return substring.equals(has);
    }

    public int computeSum(String s) {
        String[] rows = s.split("\n");
        int sum = 0;
        for (String r : rows) {
            int hashPos = r.indexOf("[");
            int endName = r.lastIndexOf("-");
            String id = r.substring(endName + 1, hashPos);
            if (test(r))
                sum += Integer.parseInt(id);
        }
        return sum;
    }

    public int decrypt(String s) {
        String[] rows = s.split("\n");
        int sum = 0;
        for (String r : rows) {
            int hashPos = r.indexOf("[");
            int endName = r.lastIndexOf("-");
            String id = r.substring(endName + 1, hashPos);
            String has = r.substring(hashPos + 1, r.length() - 1);
            String name = r.substring(0, endName);
            List<Integer> hash = name.chars().map(i -> 97 + (i + Integer.parseInt(id) % 26 -97) % 26).mapToObj(i -> i).collect(Collectors.toList());
            String res = "";
            for (Integer i : hash) {
                if (i == null) break;
                res += (char) i.intValue();
            }
            System.out.println(res + " " + id);
        }
        return 0;
    }

    public int rotate(String r) {
        int hashPos = r.indexOf("[");
        int endName = r.lastIndexOf("-");
        String id = r.substring(endName + 1, hashPos);
        String name = r.substring(0, endName);
        List<Integer> hash = name.chars().map(i -> 97 + (i + Integer.parseInt(id) % 26 -97) % 26).mapToObj(i -> i).collect(Collectors.toList());
        String res = "";
        for (Integer i : hash) {
            if (i == null) break;
            res += (char) i.intValue();
        }
        System.out.println(res);
        return 0;
    }
}
