package io.github.rishabh22.arrays;

public class SelectionSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
        int[] toSort = arr.clone();

        for (int i = 0; i < toSort.length - 1; i++) {
            int selectedIndex = i;
            for (int j = i + 1; j < toSort.length; j++) {
                if (toSort[j] < toSort[selectedIndex]) {
                    selectedIndex = j;
                }
            }
            int temp = toSort[i];
            toSort[i] = toSort[selectedIndex];
            toSort[selectedIndex] = temp;

        }
        return toSort;
    }
}
