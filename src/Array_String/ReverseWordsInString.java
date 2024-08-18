package Array_String;

public class ReverseWordsInString {
    public static void main(String[] args) {

        String s = "the sky is blue";
        System.out.println(new ReverseWordsInString().reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] sArray = s.split(" ");
        int left = 0, right = sArray.length - 1;
        while (left < right) {
            String temp = sArray[left];
            sArray[left] = sArray[right];
            sArray[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", sArray);

    }
}
