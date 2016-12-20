import java.util.PriorityQueue;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day13 {

    class Field {
        int x;
        int y;
        int len;

        public Field(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Field{" +
                    "x=" + x +
                    ", y=" + y +
                    ", len=" + len +
                    '}';
        }
    }

    int mapSize = 100;
    int[][] map = new int[mapSize][mapSize];

    public int findPath(int x, int y, int number) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (isWall(i, j, number)) {
                    map[j][i] = -1;
                }
            }
        }
        int startX = 1;
        int startY = 1;
        PriorityQueue<Field> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.len, o2.len)));
        addField(startX - 1, startY, number, 1, queue);
        addField(startX + 1, startY, number, 1, queue);
        addField(startX, startY - 1, number, 1, queue);
        addField(startX, startY + 1, number, 1, queue);
        int len = 1;
        while (startX != x || startY != y) {
            Field cand = queue.poll();
            startX = cand.x;
            startY = cand.y;
            len = cand.len;
            addField(startX - 1, startY, number, len + 1, queue);
            addField(startX + 1, startY, number, len + 1, queue);
            addField(startX, startY - 1, number, len + 1, queue);
            addField(startX, startY + 1, number, len + 1, queue);
        }
        return len;
    }

    public int countReachable(int dist, int number) {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (isWall(i, j, number)) {
                    map[j][i] = -1;
                }
            }
        }
        int startX = 1;
        int startY = 1;
        PriorityQueue<Field> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.len, o2.len)));
        addField(startX, startY, number, 10000, queue);
        addField(startX - 1, startY, number, 1, queue);
        addField(startX + 1, startY, number, 1, queue);
        addField(startX, startY - 1, number, 1, queue);
        addField(startX, startY + 1, number, 1, queue);
        int len = 1;
        while (!queue.isEmpty()) {
            Field cand = queue.poll();
            startX = cand.x;
            startY = cand.y;
            len = cand.len;
            if (len < dist) {
                addField(startX - 1, startY, number, len + 1, queue);
                addField(startX + 1, startY, number, len + 1, queue);
                addField(startX, startY - 1, number, len + 1, queue);
                addField(startX, startY + 1, number, len + 1, queue);
            }
        }
        int count = 0;
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[j][i] > 0)
                    count++;
            }
        }
        return count;
    }

    private void addField(int x, int y, int number, int len, PriorityQueue<Field> queue) {
        if (!isWall(x, y, number) && x >= 0 && y >= 0) {
            if (map[y][x] == 0) {
                queue.add(new Field(x, y, len));
                map[y][x] = len;
            }
        }
    }

    private boolean isWall(int x, int y, int number) {
        int val = x * x + 3 * x + 2 * x * y + y + y * y;
        val += number;
        int count = 0;
        while (val > 0) {
            count = count + 1;
            val = val & (val - 1);
        }
        return count % 2 == 1;
    }
}
