package io.github.rishabh22.arrays;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{1,4,6,8,11}, 11));
    }

    /**
     * Function returning index of element to be searched for
     *
     * @param arr       The input array
     * @param searchFor Element to be searched for
     * @return int Index of found element -> -1 if not found
     */
    private int search(int[] arr, int searchFor) {
        int low = 0;
        int high = arr.length - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (searchFor == arr[middle]) {
                return middle;
            } else if (searchFor > arr[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
