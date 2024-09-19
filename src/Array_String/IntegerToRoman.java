package Array_String;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 58;
        System.out.println(new IntegerToRoman().intToRoman(num));
    }

    /*public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return result.toString();

    }*/
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num >= values[i]) {
                sb.append(symbols[i]);
                num = num - values[i];
            } else {
                i++;
            }
        }
        return sb.toString();

    }
}
