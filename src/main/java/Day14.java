import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by siberis on 12/20/2016.
 */
public class Day14 {
    public int computeLastIndex(String salt) {
        int i = 0;
        int found = 0;
        while (true) {
            String hash = Hashing.md5().newHasher().putString(salt + i, Charset.defaultCharset()).hash().toString();
            String seq = findSequence(hash);
            if (seq != null) {
                for (int j = i + 1; j < i + 1001; ++j) {
                    if (Hashing.md5().newHasher().putString(salt + j, Charset.defaultCharset()).hash().toString().contains(seq)) {
                        found++;
                        break;
                    }
                }
            }
            if (found == 64)
                break;
            i++;
        }
        return i;
    }

    private String findSequence(String s) {
        for (int i = 0; i < s.length() - 2; ++i) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == s.charAt(i + 2))
                return "" + s.charAt(i) + s.charAt(i) + s.charAt(i) + s.charAt(i) + s.charAt(i);
        }
        return null;
    }

    public int computeLastIndexExtra(String salt) {
        int i = 0;
        int found = 0;
        String innerHash;
        Map<String, String> cache = Maps.newHashMap();
        while (true) {
            String hash;

            if (cache.containsKey(salt + i))
                hash = cache.get(salt + i);
            else {
                hash = Hashing.md5().newHasher().putString(salt + i, Charset.defaultCharset()).hash().toString();
                for (int k = 0; k < 2016; k++) {
                    hash = Hashing.md5().newHasher().putString(hash, Charset.defaultCharset()).hash().toString();
                }
            }
            String seq = findSequence(hash);
            if (seq != null) {
                for (int j = i + 1; j < i + 1001; ++j) {
                    innerHash = salt + j;
                    if (cache.containsKey(innerHash))
                        innerHash = cache.get(innerHash);
                    else {
                        innerHash = Hashing.md5().newHasher().putString(innerHash, Charset.defaultCharset()).hash().toString();
                        for (int k = 0; k < 2016; k++) {
                            innerHash = Hashing.md5().newHasher().putString(innerHash, Charset.defaultCharset()).hash().toString();
                        }
                        cache.put(salt + j, innerHash);
                    }
                    if (innerHash.toString().contains(seq)) {
                        found++;
                        System.out.println(found);
                        break;
                    }
                }
            }
            if (found == 64)
                break;
            i++;
            System.out.println(i);
        }
        return i;
    }
}
