package io.github.rishabh22.arrays;

import java.util.stream.IntStream;

public class MergeSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
        int[] toSort = arr.clone();
        sort(toSort, 0, toSort.length - 1);
        return toSort;
    }

    private void sort(int[] arr, int l, int r) {
        if (r > l) {
            int middle = (l + r) / 2;
            sort(arr, l, middle);
            sort(arr, middle + 1, r);
            merge(arr, l, middle, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] lTemp = new int[n1];
        int[] rTemp = new int[n2];

        IntStream.range(0, n1).forEach(i -> lTemp[i] = arr[l + i]);
        IntStream.range(0, n2).forEach(i -> rTemp[i] = arr[m + 1 + i]);

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (lTemp[i] <= rTemp[j]) {
                arr[k] = lTemp[i];
                i++;
            } else {
                arr[k] = rTemp[j];
                j++;
            }
            k++;
        }



        //Copy remaining elements from left temporary array
        while (i < n1)
        {
            arr[k] = lTemp[i];
            i++;
            k++;
        }

        //Copy remaining elements from right temporary array
        while (j < n2)
        {
            arr[k] = rTemp[j];
            j++;
            k++;
        }
    }
}
