import com.google.common.collect.Lists;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by siberis on 12/21/2016.
 */
public class Day15 {
    public int findTime(String input) {
        List<Integer> positions = Lists.newArrayList();
        List<Integer> initial = Lists.newArrayList();
        processInput(input, positions, initial);
        int i=0;
        boolean flag=false;
        while(true)
        {
            flag=true;
            for(int j=0;j<positions.size();j++)
            {
                if((i+j+1+initial.get(j))%positions.get(j)!=0)
                {
                    flag=false;
                    break;
                }
            }
            if(flag)
                break;
            i++;
        }
        return i;
    }

    private void processInput(String input, List<Integer> positions, List<Integer> initial) {
        String[] defs = input.split("\n");
        Pattern pattern = Pattern.compile("Disc #(\\d+) has (\\d+) positions; at time=0, it is at position (\\d+).");
        for (String def : defs) {
            Matcher matcher = pattern.matcher(def);
            matcher.find();
            int pos = Integer.parseInt(matcher.group(2));
            int init = Integer.parseInt(matcher.group(3));
            positions.add(pos);
            initial.add(init);
        }
    }
}
