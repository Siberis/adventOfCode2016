import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by siberis on 12/19/2016.
 */
public class Day3 {
    public int compute(String data) {
        int res = 0;
        List<String> list = Arrays.stream(data.split("\n")).map(s -> s.trim()).collect(Collectors.toList());
        for (String s : list) {
            List<Integer> values = Arrays.stream(s.split(" ")).map(a -> a.trim()).filter(x -> x.length() > 0).map(Integer::parseInt).sorted().collect(Collectors.toList());
            if (values.get(0) + values.get(1) > values.get(2))
                res++;
        }
        return res;
    }

    public int computeVerical(String data) {
        int res = 0;
        List<List<Integer>> state = new ArrayList<>();
        for (int i = 0; i < 3; i++) state.add(new ArrayList<>());
        List<String> list = Arrays.stream(data.split("\n")).map(s -> s.trim()).collect(Collectors.toList());
        int c = 0;
        for (String s : list) {
            List<Integer> values = Arrays.stream(s.split(" ")).map(a -> a.trim()).filter(x -> x.length() > 0).map(Integer::parseInt).collect(Collectors.toList());
            state.get(0).add(values.get(0));
            state.get(1).add(values.get(1));
            state.get(2).add(values.get(2));
            c++;
            if (c % 3 == 0) {
                for (int i = 0; i < 3; i++) {
                    state.get(i).sort(Integer::compareTo);
                    if (state.get(i).get(0) + state.get(i).get(1) > state.get(i).get(2))
                        res++;
                    state.get(i).clear();
                }

            }
        }
        return res;
    }

}
