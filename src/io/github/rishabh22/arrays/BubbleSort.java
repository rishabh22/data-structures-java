package io.github.rishabh22.arrays;

public class BubbleSort implements ISort {
    @Override
    //825 34 264 537 812
    public int[] sort(int[] arr) {
        int[] toSort = arr.clone();

        for (int i = 0; i < toSort.length; i++) {
            for (int j = 0; j < toSort.length - i - 1; j++) {
                if (toSort[j] > toSort[j+1]) {
                    int temp = toSort[j];
                    toSort[j] = toSort[j + 1];
                    toSort[j + 1] = temp;
                }
            }
        }
        return toSort;
    }
}
