package Leetcode.Array_String;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(new HIndex().hIndex(citations));

    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        //sbse phle ek array bana lege with size n+1
        int countArray[] = new int[n + 1];

        //ab hum countArray populate krege by checking each elements in citations
        //mtlb if citation[0]=2 to hum countArray[2]++ kr dege
        //agar citation[i]>n to hum countArray k last index ko hi update krege

        for (int citation : citations) {
            //agar citation[i]>n to hum countArray k last index ko hi update krege
            if (citation > n) {
                countArray[n]++;
            } else {
                //mtlb if citation[0]=2 to hum countArray[2]++ kr dege
                countArray[citation]++;
            }
        }

        //count variable lege
        //aur countArray ko ulta traverse krege
        //check krte hai agar
        // if lastIndex =5 and countArray[lastIndex]=3 means 3 ya 3 se jyada papers hai jinki value  6 ya 6 se jyada h
        int count = 0;
        for (int i = countArray.length - 1; i >= 0; i--) {
            count = count + countArray[i];
            if (count >= i) {
                return i;
            }
        }
        return -1;
    }

    /*public int hIndex(int[] citations) {
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
    }*/
}
