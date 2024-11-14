package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int a[] = {2, 31, 2, 56, 7, 4};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pi = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pi) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        i++;
        a[high] = a[i];
        a[i] = pi;
        return i;
    }
}
