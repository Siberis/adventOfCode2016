/**
 * Created by siberis on 12/21/2016.
 */
public class Day18 {
    public String generateMap(String firstRow, int rowsCount) {
        StringBuilder map = new StringBuilder(firstRow);
        map.append("\n");
        int width = firstRow.length();
        StringBuilder row = new StringBuilder(firstRow);
        StringBuilder newRow = null;
        for (int i = 0; i < rowsCount-1; ++i) {
            newRow = new StringBuilder();
            for (int j = 0; j < width; ++j) {
                if (j == 0) {
                    if ((row.charAt(j) == '^' && row.charAt(j + 1) == '^') ||
                            (row.charAt(j) == '.' && row.charAt(j + 1) == '^')) {
                        newRow.append("^");
                    } else {
                        newRow.append(".");
                    }
                } else if (j == width - 1) {
                    if ((row.charAt(j - 1) == '^' && row.charAt(j) == '^') ||
                            (row.charAt(j - 1) == '^' && row.charAt(j) == '.')) {
                        newRow.append("^");
                    } else {
                        newRow.append(".");
                    }
                } else {
                    if ((row.charAt(j - 1) == '^' && row.charAt(j) == '^' && row.charAt(j + 1) == '.') ||
                            (row.charAt(j - 1) == '.' && row.charAt(j) == '^' && row.charAt(j + 1) == '^') ||
                            (row.charAt(j - 1) == '^' && row.charAt(j) == '.' && row.charAt(j + 1) == '.') ||
                            (row.charAt(j - 1) == '.' && row.charAt(j) == '.' && row.charAt(j + 1) == '^')) {
                        newRow.append("^");
                    } else {
                        newRow.append(".");
                    }
                }
            }
            row=newRow;
            map.append(newRow).append("\n");
        }
        map.deleteCharAt(map.length()-1);
        return map.toString();
    }
}
