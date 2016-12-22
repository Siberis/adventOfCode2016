import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siberis on 12/21/2016.
 */
public class Day19 {
    public int computeElf(int i) {
        int k = 1;
        int a = 1;
        int b = i;
        int c = i;
        int d = 0;
        while (true) {
            k++;
            if (c == 3) return b;
            if (c % 2 == 0) {
                c = c / 2;
                b -= Math.pow(2, k - 2);
            } else {
                c = c / 2;
                a += Math.pow(2, k - 1);
            }
            if (a == b)
                break;
        }
        return a;
    }

    public int computeElf2(int i) {
        boolean[] map = new boolean[i];
        int c = i;
        boolean f = i % 2 == 1;
        boolean ov = false;
        int mm = ((int) i / 2);
        for (int zz = 0; zz < i / 2; ++zz) {
            map[mm] = true;
            c--;
            if (f) mm += 2;
            else mm += 1;
            if (f && !ov && mm - 2 != i - 1)
                zz--;
            if (mm >= i)
                ov = true;
            mm = mm % i;
            f = !f;
        }
        List<Integer> res = Lists.newArrayList();
        for (int x = 0; x < i; ++x) {
            if (!map[x]) {
                res.add(x);
            }
        }
        while (res.size() > 3) {
            f = res.size() % 2 == 1;
            ov = false;
            map = new boolean[res.size()];
            mm = ((int) res.size() / 2);
            int xx = c;
            for (int zz = 0; zz < res.size() / 2; ++zz) {
                map[mm] = true;
                xx -= 2;
                c--;
                if (f) mm += 2;
                else mm += 1;
                if (f && !ov && mm - 2 != res.size() - 1)
                    zz--;
                if (mm >= i)
                    ov = true;
                mm = mm % res.size();
                f = !f;
            }
            int oldsize = res.size();
            ArrayList<Integer> ress = Lists.newArrayList();
            for (int x = 0; x < oldsize; ++x) {
                if (!map[x]) {
                    ress.add(res.get(x));
                }
            }
            res = ress;
        }
        if (res.size() == 3) return res.get(2) + 1;
        if (res.size() == 2) return res.get(0) + 1;
        return res.get(0) + 1;
    }
}
