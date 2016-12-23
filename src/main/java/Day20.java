/**
 * Created by siberis on 12/23/2016.
 */
public class Day20 {
    class Pair {
        long a;
        long b;
        Pair prev;
        Pair next;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        boolean canMerge(Pair p) {
            if (p.a + 1 <= a && a + 1 <= p.b)
                return true;
            if (p.a + 1 <= b && b + 1 <= p.b)
                return true;
            if (a + 1 <= p.a && p.a + 1 <= b)
                return true;
            if (a + 1 <= p.b && p.b + 1 <= b)
                return true;
            return false;
        }

        void merge(Pair p) {
            a = Math.min(a, p.a);
            b = Math.max(b, p.b);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    class MergeList {
        Pair first;

        public void add(Pair pair) {
            if (first == null) {
                first = pair;
                return;
            }
            Pair tmp = first;
            while (tmp != null) {
                if (tmp.canMerge(pair)) {
                    tmp.merge(pair);
                    Pair x = tmp.next;
                    while (x != null && tmp.canMerge(x)) {
                        tmp.merge(x);
                        tmp.next = x.next;
                        x.next.prev = tmp;
                        x = x.next;
                    }
                    return;
                } else {
                    if (tmp.a > pair.b + 1) {
                        pair.next = tmp;
                        tmp.prev = pair;
                        if (tmp == first) {
                            first = pair;
                        }
                        return;
                    }
                    Pair next = tmp.next;
                    if (next == null) {
                        tmp.next = pair;
                        return;
                    } else if (next.a >= pair.b + 1) {
                        tmp.next = pair;
                        next.prev = pair;
                        pair.next = next;
                        pair.prev = tmp;
                        return;
                    }
                }
                tmp = tmp.next;
            }
        }

        long findMin() {
            Pair x = first;
            for (long i = 0; i < 4294967295l; i++) {
                if (x == null) {
                    return i;
                }
                if (i < x.a)
                    return i;
                i = x.b;
                x = x.next;
            }
            return 4294967295l;
        }

        long countAllowed() {
            int res = 0;
            Pair x = first;
            for (long i = 0; i < 4294967295l; i++) {
                if (x == null) {
                    return i;
                }
                if (i < x.a)
                    res++;
                i = x.b;
                x = x.next;
            }
            return res;
        }
    }

    public long findMin(String data) {
        String[] lines = data.split("\n");
        MergeList list = new MergeList();
        for (String s : lines) {
            String[] vals = s.split("-");
            list.add(new Pair(Long.parseLong(vals[0]), Long.parseLong(vals[1])));
        }
        return list.findMin();
    }

    public long countAllowed(String data) {
        String[] lines = data.split("\n");
        MergeList list = new MergeList();
        for (String s : lines) {
            String[] vals = s.split("-");
            list.add(new Pair(Long.parseLong(vals[0]), Long.parseLong(vals[1])));
        }
        return list.countAllowed();
    }
}
