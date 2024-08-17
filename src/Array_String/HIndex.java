package Array_String;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(new HIndex().hIndex(citations));

    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] countArray = new int[n + 1];

        for (int citation : citations) {
            //if citation number is greater than size of array to last wale ko hi increment kr do
            if (citation > n) {
                countArray[n]++;
            } else {
                countArray[citation]++;
            }
        }

        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += countArray[i];
            if (count >= i)
                return i;
        }
        return -1;
    }
}
