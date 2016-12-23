import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by siberis on 12/22/2016.
 */
public class Day22 {

    class Node {
        int aval;
        int used;

        public Node(int aval, int used) {
            this.aval = aval;
            this.used = used;
        }
    }

    public int calculatePairs(String data, int x, int y) {
        String[] nodes = data.split("\n");
        Node[][] map = parseInput(nodes, x, y);
        int res = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    for (int l = 0; l < y; l++) {
                        if (!(i == k && j == l)) {
                            if (map[i][j].used > 0 && map[i][j].used < map[k][l].aval) {
                                res++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private Node[][] parseInput(String[] nodes, int x, int y) {
        Node[][] map = new Node[x][y];
        Pattern pattern = Pattern.compile("/dev/grid/node-x(\\d+)-y(\\d+)");
        for (int i = 2; i < nodes.length; ++i) {
            String line = nodes[i];
            line = line.replaceAll("( )+", " ");
            String[] nodeData = line.split(" ");
            Matcher matcher = pattern.matcher(nodeData[0]);
            matcher.find();
            int px = Integer.parseInt(matcher.group(1));
            int py = Integer.parseInt(matcher.group(2));
            int us = Integer.parseInt(nodeData[2].substring(0, nodeData[2].length() - 1));
            int av = Integer.parseInt(nodeData[3].substring(0, nodeData[3].length() - 1));
            map[px][py] = new Node(av, us);
        }
        return map;
    }

    private int check(Node[][] map, int i, int j) {
        int res = 0;
        if (i - 1 >= 0) {
            if (map[i - 1][j].used > 0 && map[i][j].aval > map[i - 1][j].used) {
                System.out.println(i + "," + j + "<-" + (i - 1) + "," + j);
                res++;
            }
        }
        if (i + 1 < map.length) {
            if (map[i + 1][j].used > 0 && map[i][j].aval > map[i + 1][j].used) {
                System.out.println(i + "," + j + "<-" + (i + 1) + "," + j);
                res++;
            }
        }
        if (j - 1 >= 0) {
            if (map[i][j - 1].used > 0 && map[i][j].aval > map[i][j - 1].used) {
                System.out.println(i + "," + j + "<-" + i + "," + (j - 1));
                res++;
            }
        }
        if (j + 1 < map[i].length) {
            if (map[i][j + 1].used > 0 && map[i][j].aval > map[i][j + 1].used) {
                System.out.println(i + "," + j + "<-" + i + "," + (j + 1));
                res++;
            }
        }
        return res;
    }
}
