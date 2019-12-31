package io.github.rishabh22.arrays;

import io.github.rishabh22.SortStrategy;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

//Sorting using Command design pattern
//Controller not really a controller
public class SortController {
    Scanner scan;

    public SortController(InputStream inputStream, PrintStream printStream) {
        this.scan = new Scanner(inputStream);
        System.setOut(printStream);
    }

    Map<String, ISort> sortStrategyMap = Map.of(
            SortStrategy.BUBBLE.getValue(), new BubbleSort(),
            SortStrategy.SELECTION.getValue(), new SelectionSort(),
            SortStrategy.INSERTION.getValue(), new InsertionSort(),
            SortStrategy.MERGE.getValue(), new MergeSort(),
            SortStrategy.QUICK.getValue(), new QuickSort()
    );

    public void sort() {
        //Should ideally be delegated to the view layer
//        System.out.print("Please enter the strategy: ");
        String strategy = scan.next();
        if (!sortStrategyMap.containsKey(strategy)) {
            throw new IllegalArgumentException();
        }

//        System.out.println();

//        System.out.print("Please enter size of array: ");
        int size = scan.nextInt();
//        System.out.println();

        int[] numbers = new int[size];
//        System.out.print("Please enter the array to sort: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();
        }

//        System.out.print("Sorted: ");
        System.out.print(Arrays.toString(sortStrategyMap.get(strategy).sort(numbers)));
    }

    public static void main(String[] args) {
        SortController sortController = new SortController(System.in, System.out);
        sortController.sort();
    }
}
