import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by siberis on 12/21/2016.
 */
public class Day17 {
    class Field {
        String code;
        String path;
        int x;
        int y;

        public Field(String path, String code, int x, int y) {
            this.path = path;
            this.code = code;
            this.x = x;
            this.y = y;
        }
    }

    public String findPath(String password) {
        List<List<Field>> list = Lists.newArrayList();
        list.add(Lists.newArrayList());
        String dir = "UDLR";
        list.get(0).add(new Field("", Hashing.md5().newHasher().putString(password + "" + "", Charset.defaultCharset()).hash().toString(), 0, 0));
        int i = 0;
        boolean end = false;
        Field field = null;
        while (true) {
            list.add(Lists.newArrayList());
            for (int j = 0; j < list.get(i).size(); ++j) {
                field = list.get(i).get(j);
                if (field.x == 3 && field.y == 3) {
                    end = true;
                    break;
                }
                if (isOpen(0, field.code) && field.y > 0) {
                    list.get(i + 1).add(new Field(
                            field.path + dir.charAt(0),
                            Hashing.md5().newHasher().putString(password + field.path + dir.charAt(0), Charset.defaultCharset()).hash().toString(),
                            field.x, field.y - 1));
                }
                if (isOpen(1, field.code) && field.y < 3) {
                    list.get(i + 1).add(new Field(
                            field.path + dir.charAt(1),
                            Hashing.md5().newHasher().putString(password + field.path + dir.charAt(1), Charset.defaultCharset()).hash().toString(),
                            field.x, field.y + 1));
                }
                if (isOpen(2, field.code) && field.x > 0) {
                    list.get(i + 1).add(new Field(
                            field.path + dir.charAt(2),
                            Hashing.md5().newHasher().putString(password + field.path + dir.charAt(2), Charset.defaultCharset()).hash().toString(),
                            field.x - 1, field.y));
                }
                if (isOpen(3, field.code) && field.x < 3) {
                    list.get(i + 1).add(new Field(
                            field.path + dir.charAt(3),
                            Hashing.md5().newHasher().putString(password + field.path + dir.charAt(3), Charset.defaultCharset()).hash().toString(),
                            field.x + 1, field.y));
                }
            }
            if (end) {
                break;
            }
            if (i > 0)
                list.get(i - 1).clear();
            i++;
        }
        return field.path;
    }
    public int longestPath(String password) {
        List<List<Field>> list = Lists.newArrayList();
        list.add(Lists.newArrayList());
        String dir = "UDLR";
        list.get(0).add(new Field("", Hashing.md5().newHasher().putString(password + "" + "", Charset.defaultCharset()).hash().toString(), 0, 0));
        int i = 0;
        boolean end = false;
        Field field = null;
        int max=0;
        while (true) {
            list.add(Lists.newArrayList());
            end=true;
            for (int j = 0; j < list.get(i).size(); ++j) {
                end=false;
                field = list.get(i).get(j);
                if (field.x == 3 && field.y == 3) {
                    if(max<field.path.length())
                        max=field.path.length();
                    continue;
                }
                if (isOpen(0, field.code) && field.y > 0) {
                    list.get(i + 1).add(new Field(
                            field.path + dir.charAt(0),
                            Hashing.md5().newHasher().putString(password + field.path + dir.charAt(0), Charset.defaultCharset()).hash().toString(),
                            field.x, field.y - 1));
                }
                if (isOpen(1, field.code) && field.y < 3) {
                    list.get(i + 1).add(new Field(
                            field.path + dir.charAt(1),
                            Hashing.md5().newHasher().putString(password + field.path + dir.charAt(1), Charset.defaultCharset()).hash().toString(),
                            field.x, field.y + 1));
                }
                if (isOpen(2, field.code) && field.x > 0) {
                    list.get(i + 1).add(new Field(
                            field.path + dir.charAt(2),
                            Hashing.md5().newHasher().putString(password + field.path + dir.charAt(2), Charset.defaultCharset()).hash().toString(),
                            field.x - 1, field.y));
                }
                if (isOpen(3, field.code) && field.x < 3) {
                    list.get(i + 1).add(new Field(
                            field.path + dir.charAt(3),
                            Hashing.md5().newHasher().putString(password + field.path + dir.charAt(3), Charset.defaultCharset()).hash().toString(),
                            field.x + 1, field.y));
                }
            }
            if (end) {
                break;
            }
            if (i > 0)
                list.get(i - 1).clear();
            i++;
        }
        return max;
    }
    private boolean isOpen(int pos, String code) {
        if (code.charAt(pos) == 'b' || code.charAt(pos) == 'c' || code.charAt(pos) == 'd' || code.charAt(pos) == 'e' || code.charAt(pos) == 'f')
            return true;
        return false;
    }
}
