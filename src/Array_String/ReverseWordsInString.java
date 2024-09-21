package Array_String;

public class ReverseWordsInString {
    public static void main(String[] args) {

        String s = "the sky is blue";
        System.out.println(new ReverseWordsInString().reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] sa = s.split(" ");
        int left = 0, right = sa.length - 1;
        while (left < right) {
            String t = sa[left];
            sa[left] = sa[right];
            sa[right] = t;
            left++;
            right--;
        }
        return String.join(" ", sa);

    }
}
