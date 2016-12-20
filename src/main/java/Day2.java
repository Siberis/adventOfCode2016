/**
 * Created by siberis on 12/19/2016.
 */
public class Day2 {
    public String compute(String keypad1, String instruction) {
        int x = 1;
        int y = 1;
        String res = "";
        String[] rows = keypad1.split("\n");
        for (int i = 0; i < rows.length; i++) {
            rows[i] = rows[i].replace(" ", "");
        }
        String[] inst = instruction.split("\n");
        for (int i = 0; i < inst.length; i++) {
            for (int j = 0; j < inst[i].length(); j++) {
                switch (inst[i].charAt(j)) {
                    case 'U':
                        if (x > 0) x--;
                        break;
                    case 'D':
                        if (x < rows[0].length() - 1) x++;
                        break;
                    case 'L':
                        if (y > 0) y--;
                        break;
                    case 'R':
                        if (y < rows[0].length() - 1) y++;
                        break;
                }
            }
            res += rows[x].charAt(y);
        }
        return res;
    }

    public String computeExtra(int startX,int startY, String keypad1, String instruction) {
        int x = startX;
        int y = startY;
        String res = "";
        String[] rows = keypad1.split("\n");
        for (int i = 0; i < rows.length; i++) {
            rows[i] = rows[i].replace("  ", "_");
            rows[i] = rows[i].replace(" ", "");
        }
        String[] inst = instruction.split("\n");
        for (int i = 0; i < inst.length; i++) {
            for (int j = 0; j < inst[i].length(); j++) {
                switch (inst[i].charAt(j)) {
                    case 'U':
                        if (x > 0 && rows[x - 1].charAt(y) != '_') x--;
                        break;
                    case 'D':
                        if (x < rows[0].length() - 1 && rows[x + 1].charAt(y) != '_') x++;
                        break;
                    case 'L':
                        if (y > 0 && rows[x].charAt(y - 1) != '_') y--;
                        break;
                    case 'R':
                        if (y < rows[0].length() - 1 && rows[x].charAt(y + 1) != '_') y++;
                        break;
                }
            }
            res += rows[x].charAt(y);
        }
        return res;
    }
}
