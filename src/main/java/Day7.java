import java.util.ArrayList;
import java.util.List;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day7 {

    public boolean test(String s) {
        String[] parts = s.split("[\\[\\]]");
        boolean res = false;
        for (int i = 0; i < parts.length; ++i) {
            if (contains(parts[i])) {
                if (i % 2 == 1)
                    return false;
                res = true;
            }
        }
        return res;
    }

    private boolean contains(String part) {
        for (int i = 0; i < part.length() - 3; i++) {
            if (part.charAt(i) == part.charAt(i + 3) && part.charAt(i + 1) == part.charAt(i + 2) && part.charAt(i) != part.charAt(i + 1))
                return true;
        }
        return false;
    }

    public int count(String data) {
        String[] rows = data.split("\n");
        int res = 0;
        for (String s : rows)
            if (test(s))
                res++;
        return res;
    }

    public boolean test2(String s) {
        String[] parts = s.split("[\\[\\]]");
        boolean res = false;
        List<String> triples = new ArrayList<>();
        for (int i = 1; i < parts.length; i += 2) {
            triples.addAll(generateTriples(parts[i]));
        }
        for (int i = 0; i < parts.length; i += 2) {
            if (findTriples(parts[i], triples))
                return true;
        }
        return false;
    }

    private List<String> generateTriples(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 2) && s.charAt(i) != s.charAt(i + 1)) {
                res.add("" + s.charAt(i + 1) + s.charAt(i) + s.charAt(i + 1));
            }
        }
        return res;
    }

    private boolean findTriples(String s, List<String> triples) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; i++) {
            for (String x : triples) {
                if (s.charAt(i) == x.charAt(0)
                        && s.charAt(i + 1) == x.charAt(1)
                        && s.charAt(i + 2) == x.charAt(2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int count2(String data) {
        String[] rows = data.split("\n");
        int res = 0;
        for (String s : rows)
            if (test2(s))
                res++;
        return res;
    }
}
