import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day8 {
    public String rect(String s, String in) {
        int size = in.indexOf("\n") + 1;
        StringBuilder out = new StringBuilder(in);
        Pattern pattern = Pattern.compile("rect (\\d+)x(\\d+)");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        int x = Integer.parseInt(matcher.group(1));
        int y = Integer.parseInt(matcher.group(2));
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                out.setCharAt(i + size * j, '#');
            }
        }
        return out.toString();
    }

    public String rc(String s, String in) {
        int sizeX = in.indexOf("\n") + 1;
        int sizeY = (int) in.chars().filter(i -> i == '\n').count();
        StringBuilder out = new StringBuilder(in);
        Pattern pattern = Pattern.compile("rotate column x=(\\d+) by (\\d+)");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        int x = Integer.parseInt(matcher.group(1));
        int y = Integer.parseInt(matcher.group(2));
        for (int j = 0; j < y; j++) {
            char last = out.charAt(x + sizeX * sizeY);
            for (int i = sizeY; i > 0; i--) {
                out.setCharAt(x + sizeX * i, out.charAt(x + sizeX * (i - 1)));
            }
            out.setCharAt(x, last);
        }
        return out.toString();
    }

    public String rr(String s, String in) {
        int sizeX = in.indexOf("\n") + 1;
        int sizeY = (int) in.chars().filter(i -> i == '\n').count();
        StringBuilder out = new StringBuilder(in);
        Pattern pattern = Pattern.compile("rotate row y=(\\d+) by (\\d+)");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        int x = Integer.parseInt(matcher.group(2));
        int y = Integer.parseInt(matcher.group(1));
        for (int j = 0; j < x; j++) {
            char last = out.charAt((y + 1) * sizeX - 2);
            for (int i = sizeX - 2; i > 0; i--) {
                out.setCharAt(y * sizeX + i, out.charAt(y * sizeX + (i - 1)));
            }
            out.setCharAt(y * sizeX, last);
        }
        return out.toString();
    }

    public String draw(String data, String in) {
        String[] inst = data.split("\n");
        StringBuilder sb = new StringBuilder(in);
        Pattern rect = Pattern.compile("rect (\\d+)x(\\d+)");
        Pattern rc = Pattern.compile("rotate column x=(\\d+) by (\\d+)");
        Pattern rr = Pattern.compile("rotate row y=(\\d+) by (\\d+)");
        for (String ins : inst) {
            if (rect.matcher(ins).matches()) {
                sb = new StringBuilder(rect(ins, sb.toString()));
            } else if (rc.matcher(ins).matches()) {
                sb = new StringBuilder(rc(ins, sb.toString()));
            } else {
                sb = new StringBuilder(rr(ins, sb.toString()));
            }
        }
        return sb.toString();
    }
}
