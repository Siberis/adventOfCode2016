/**
 * Created by siberis on 12/21/2016.
 */
public class Day16 {
    public String calculateChecksum(String initial, int size) {
        StringBuilder sb = new StringBuilder(initial);
        while (sb.length() < size) {
            expandWithDragon(sb);
        }
        sb.delete(size, sb.length());
        do {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < sb.length() - 1; i += 2) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb2.append("1");
                } else {
                    sb2.append("0");
                }
            }
            sb = sb2;
        }
        while (sb.length() % 2 == 0);
        return sb.toString();
    }

    private void expandWithDragon(StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; --i) {
            if (sb.charAt(i) == '1') {
                sb2.append("0");
            } else {
                sb2.append("1");
            }
        }
        sb.append("0").append(sb2.toString());
    }
}
