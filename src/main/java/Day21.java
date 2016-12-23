import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by siberis on 12/22/2016.
 */
public class Day21 {

    public String transform(String text, String inst) {
        String[] lines = inst.split("\n");
        Pattern swap = Pattern.compile("swap position (\\d+) with position (\\d+)");
        Pattern swapLet = Pattern.compile("swap letter (\\w+) with letter (\\w+)");
        Pattern rotate = Pattern.compile("rotate ([a-z]+) (\\d+) step[s]?");
        Pattern rotateLet = Pattern.compile("rotate based on position of letter (\\w+)");
        Pattern reverse = Pattern.compile("reverse positions (\\d+) through (\\d+)");
        Pattern move = Pattern.compile("move position (\\d+) to position (\\d+)");
        StringBuilder sb = new StringBuilder(text);
        for (String line : lines) {
            if (swap.matcher(line).matches()) {
                Matcher matcher = swap.matcher(line);
                matcher.find();
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(2));
                swapPos(sb, a, b);
            } else if (swapLet.matcher(line).matches()) {
                Matcher matcher = swapLet.matcher(line);
                matcher.find();
                String a = matcher.group(1);
                String b = matcher.group(2);
                swapLetter(sb, a, b);
            } else if (rotate.matcher(line).matches()) {
                Matcher matcher = rotate.matcher(line);
                matcher.find();
                String a = matcher.group(1);
                int b = Integer.parseInt(matcher.group(2));
                if (a.charAt(0) == 'r') {
                    rotateRight(sb, b);
                } else {
                    rotateLeft(sb, b);
                }
            } else if (rotateLet.matcher(line).matches()) {
                Matcher matcher = rotateLet.matcher(line);
                matcher.find();
                String a = matcher.group(1);
                rotateLetter(sb, a);
            } else if (reverse.matcher(line).matches()) {
                Matcher matcher = reverse.matcher(line);
                matcher.find();
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(2));
                reverse(sb, a, b);
            } else if (move.matcher(line).matches()) {
                Matcher matcher = move.matcher(line);
                matcher.find();
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(2));
                move(sb, a, b);
            }
        }
        return sb.toString();
    }

    public String reverseTransform(String text, String inst) {
        String[] lines = inst.split("\n");
        Pattern swap = Pattern.compile("swap position (\\d+) with position (\\d+)");
        Pattern swapLet = Pattern.compile("swap letter (\\w+) with letter (\\w+)");
        Pattern rotate = Pattern.compile("rotate ([a-z]+) (\\d+) step[s]?");
        Pattern rotateLet = Pattern.compile("rotate based on position of letter (\\w+)");
        Pattern reverse = Pattern.compile("reverse positions (\\d+) through (\\d+)");
        Pattern move = Pattern.compile("move position (\\d+) to position (\\d+)");
        StringBuilder sb = new StringBuilder(text);
        for (int i = lines.length - 1; i >= 0; --i) {
            String line = lines[i];
            if (swap.matcher(line).matches()) {
                Matcher matcher = swap.matcher(line);
                matcher.find();
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(2));
                swapPos(sb, b, a);
            } else if (swapLet.matcher(line).matches()) {
                Matcher matcher = swapLet.matcher(line);
                matcher.find();
                String a = matcher.group(1);
                String b = matcher.group(2);
                swapLetter(sb, b, a);
            } else if (rotate.matcher(line).matches()) {
                Matcher matcher = rotate.matcher(line);
                matcher.find();
                String a = matcher.group(1);
                int b = Integer.parseInt(matcher.group(2));
                if (a.charAt(0) == 'r') {
                    rotateLeft(sb, b);
                } else {
                    rotateRight(sb, b);
                }
            } else if (rotateLet.matcher(line).matches()) {
                Matcher matcher = rotateLet.matcher(line);
                matcher.find();
                String a = matcher.group(1);
                rotateLetterRev(sb, a);
            } else if (reverse.matcher(line).matches()) {
                Matcher matcher = reverse.matcher(line);
                matcher.find();
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(2));
                reverse(sb, a, b);
            } else if (move.matcher(line).matches()) {
                Matcher matcher = move.matcher(line);
                matcher.find();
                int a = Integer.parseInt(matcher.group(1));
                int b = Integer.parseInt(matcher.group(2));
                move(sb, b, a);
            }
        }
        return sb.toString();
    }

    private void swapPos(StringBuilder sb, int a, int b) {
        char x = sb.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, x);
    }

    private void swapLetter(StringBuilder sb, String a, String b) {
        int x = sb.indexOf(a);
        int y = sb.indexOf(b);
        swapPos(sb, x, y);
    }

    private void rotateLeft(StringBuilder sb, int x) {
        for (int i = 0; i < x; i++) {
            char a = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(a);
        }
    }

    private void rotateRight(StringBuilder sb, int x) {
        for (int i = 0; i < x; i++) {
            char a = sb.charAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.insert(0, a);
        }
    }

    private void rotateLetter(StringBuilder sb, String x) {
        int pos = sb.indexOf(x);
        int extra = pos >= 4 ? 1 : 0;
        rotateRight(sb, 1);
        for (int i = 0; i < pos + extra; i++)
            rotateRight(sb, 1);
    }

    private void rotateLetterRev(StringBuilder sb, String x) {
        int[] map = new int[sb.length()];
        for (int i = 0; i < sb.length(); ++i) {
            int ex = i >= 4 ? 1 : 0;
            map[(i + i + ex + 1) % sb.length()] = i;
        }
        int pos = sb.indexOf(x);
        int pos2 = sb.indexOf(x);
        while (pos2 != map[pos]) {
            rotateLeft(sb, 1);
            pos2 = sb.indexOf(x);
        }
    }

    private void reverse(StringBuilder sb, int a, int b) {
        int x = a;
        int y = b;
        while (x < y) {
            swapPos(sb, x, y);
            x++;
            y--;
        }
    }

    private void move(StringBuilder sb, int a, int b) {
        char x = sb.charAt(a);
        sb.deleteCharAt(a);
        sb.insert(b, x);
    }
}
