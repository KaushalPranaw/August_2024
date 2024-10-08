package Array_String;

import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(new ZigzagConversion().convert(s, numRows));

    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int i = 0;
        while (i < s.length()) {
            //populate top to bottom wala
            for (int index = 0; index < numRows && i < s.length(); index++) {
                rows[index].append(s.charAt(i));
                i++;
            }
            //zigzag wala
            for (int index = numRows - 2; index > 0 && i < s.length(); index--) {
                rows[index].append(s.charAt(i));
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row.toString());
        }
        return sb.toString();


    }
}
