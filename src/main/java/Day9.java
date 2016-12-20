import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day9 {
    public String uncompress(String text) {
        String out = text;
        Pattern pattern = Pattern.compile("\\((\\d+)x(\\d+)\\)");
        for (int i = 0; i < out.length(); i++) {
            if (out.charAt(i) == '(') {
                int end = out.indexOf(')', i);
                String p = out.substring(i, end + 1);
                String rest = out.substring(end + 1);
                String extra = "";
                if (pattern.matcher(p).matches()) {
                    String prev = out.substring(0, i);
                    Matcher matcher = pattern.matcher(p);
                    matcher.find();
                    int ch = Integer.parseInt(matcher.group(1));
                    int times = Integer.parseInt(matcher.group(2));
                    String rep = rest.substring(0, ch);
                    rest = rest.substring(ch);
                    for (int j = 0; j < times; ++j) {
                        extra = extra + rep;
                    }
                    out = prev + extra + rest;
                }
                i = i + extra.length() - 1;
            }
        }

        return out;
    }

    public String uncompress2(String text) {
        StringBuilder out = new StringBuilder(text);
        Pattern pattern = Pattern.compile("\\((\\d+)x(\\d+)\\)");
        for (int i = 0; i < out.length(); i++) {
            if (out.charAt(i) == '(') {
                int end = out.indexOf(")", i);
                String p = out.substring(i, end + 1);
                String rest = out.substring(end + 1);
                StringBuilder extra = new StringBuilder();
                if (pattern.matcher(p).matches()) {
                    String prev = out.substring(0, i);
                    Matcher matcher = pattern.matcher(p);
                    matcher.find();
                    int ch = Integer.parseInt(matcher.group(1));
                    int times = Integer.parseInt(matcher.group(2));
                    String rep = rest.substring(0, ch);
                    rep = uncompress2(rep);
                    rest = rest.substring(ch);
                    for (int j = 0; j < times; ++j) {
                        extra.append(rep);
                    }
                    out.delete(0, out.length());
                    out.append(prev).append(extra).append(rest);
                }
                i = i + extra.length() - 1;
            }
        }

        return out.toString();
    }

    public long uncompress2size(String text) {
        StringBuilder out = new StringBuilder(text);
        Pattern pattern = Pattern.compile("\\((\\d+)x(\\d+)\\)");
        long total = 0;
        for (int i = 0; i < out.length(); i++) {
            if (out.charAt(i) == '(') {
                int end = out.indexOf(")", i);
                String p = out.substring(i, end + 1);
                String rest = out.substring(end + 1);
                long extra = 0;
                if (pattern.matcher(p).matches()) {
                    Matcher matcher = pattern.matcher(p);
                    matcher.find();
                    int ch = Integer.parseInt(matcher.group(1));
                    long times = Integer.parseInt(matcher.group(2));
                    String rep = rest.substring(0, ch);
                    long repSize = uncompress2size(rep);
                    rest = rest.substring(ch);
                    extra = repSize * times;
                    total += extra;
                    out.delete(0, out.length());
                    out.append(rest);
                }
                i = -1;
            } else {
                total++;
            }
        }

        return total;
    }
}
