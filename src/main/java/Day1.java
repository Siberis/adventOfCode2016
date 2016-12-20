import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by siberis on 12/19/2016.
 */
public class Day1 {
    public static void main(String[] args) {

    }

    public long compute(String s) {
        String[] tab = s.split(", ");
        int x = 0, y = 0;
        double alfa = 0.0;
        for (int i = 0; i < tab.length; ++i) {
            switch (tab[i].substring(0, 1)) {
                case "R":
                    alfa += Math.PI / 2;
                    break;
                case "L":
                    alfa -= Math.PI / 2;
                    break;
            }
            x += ((int) Math.sin(alfa)) * Integer.parseInt(tab[i].substring(1));
            y += ((int) Math.cos(alfa)) * Integer.parseInt(tab[i].substring(1));
        }
        return Math.abs(x) + Math.abs(y);
    }

    public long computeTwice(String s) {
        String[] tab = s.split(", ");
        Set<Map.Entry<Integer, Integer>> visited = new HashSet<>();
        int x = 0, y = 0;
        int dx = 0, dy = 0;
        double alfa = 0.0;
        for (int i = 0; i < tab.length; ++i) {
            switch (tab[i].substring(0, 1)) {
                case "R":
                    alfa += Math.PI / 2;
                    break;
                case "L":
                    alfa -= Math.PI / 2;
                    break;
            }
            dx = ((int) Math.sin(alfa)) * Integer.parseInt(tab[i].substring(1));
            dy = ((int) Math.cos(alfa)) * Integer.parseInt(tab[i].substring(1));
            if (dx != 0) {
                if (dx < 0) {
                    for (int j = dx; j != 0; j++)
                        if (!visited.add(new AbstractMap.SimpleEntry<>(x + j, y)))
                            return Math.abs(x + j) + Math.abs(y);
                } else {
                    for (int j = dx; j != 0; j--)
                        if (!visited.add(new AbstractMap.SimpleEntry<>(x + j, y)))
                            return Math.abs(x + j) + Math.abs(y);
                }
            } else {
                if (dy < 0) {
                    for (int j = dy; j != 0; j++)
                        if (!visited.add(new AbstractMap.SimpleEntry<>(x, y + j)))
                            return Math.abs(x) + Math.abs(y + j);
                } else {
                    for (int j = dy; j != 0; j--)
                        if (!visited.add(new AbstractMap.SimpleEntry<>(x, y + j)))
                            return Math.abs(x) + Math.abs(y + j);
                }
            }
            x += dx;
            y += dy;
        }
        return Math.abs(x) + Math.abs(y);
    }
}
