package io.github.rishabh22.arrays;

public class InsertionSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
        int[] toSort = arr.clone();

        for (int i = 1; i < toSort.length; i++) {
            int j = i - 1;
            int key = toSort[i];
            while (j >= 0 && toSort[j] > key) {
                toSort[j + 1] = toSort[j];
                j--;
            }
            toSort[j + 1] = key;
        }
        return toSort;
    }
}