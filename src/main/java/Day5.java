import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * Created by siberis on 12/19/2016.
 */
public class Day5 {
    public String calculateHash(String s) {
        String output = "";
        int i = 0;
        while (true) {
            String res = Hashing.md5().newHasher().putString(s + i, Charset.defaultCharset()).hash().toString();
            if (res.startsWith("00000")) {
                output += res.charAt(5);
                if (output.length() == 8)
                    break;
            }
            i++;
        }
        System.out.println(output);

        return output;
    }

    public String calculateHash2(String s) {
        String output = "________";
        int i = 0;
        int find = 0;
        while (true) {
            String res = Hashing.md5().newHasher().putString(s + i, Charset.defaultCharset()).hash().toString();
            if (res.startsWith("00000")) {
                if (res.charAt(5) < 56) {
                    int pos = Integer.parseInt(res.charAt(5) + "");
                    if (output.charAt(pos) == '_')
                        find++;
                    else {
                        i++;
                        continue;
                    }
                    output = output.substring(0, pos) + res.charAt(6) + output.substring(pos + 1);
                    if (find == 8)
                        break;
                }
            }
            i++;
        }
        System.out.println(output);

        return output;
    }
}
