package Leetcode.Array_String;

public class ExcelColumnName {
    public static void main(String[] args) {
        int number = 700;
        System.out.println(new ExcelColumnName().printExcelColumnName(number));
    }

    private String printExcelColumnName(int number) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int remainder = (number - 1) % 26;
            char letter = (char) (remainder + 'A');
            sb.insert(0, letter);
            number = (number - 1) / 26;

        }
        return sb.toString();
    }
}
