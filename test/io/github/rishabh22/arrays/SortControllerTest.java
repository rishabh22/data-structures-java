package io.github.rishabh22.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SortControllerTest {

    //SortController sortController = new SortController();
    ByteArrayOutputStream baos;
    SortController sortController;

    static String inputString;
    static int[] expectedOutputArr;

    public SortControllerTest() {

    }

    @BeforeEach
    void setUp() {
        baos = new ByteArrayOutputStream();
    }

    @BeforeAll
    static void beforeAll() {
        Random random = new Random();
        int[] inputArr = new int[random.nextInt(10)];
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = random.nextInt(10);
        }
        inputString = Arrays.stream(inputArr).mapToObj(Integer::toString)
                .reduce(Integer.toString(inputArr.length), (str1, str2) -> str1 + " " + str2);
        expectedOutputArr = inputArr.clone();
        Arrays.sort(expectedOutputArr);
    }

    @Test
    public void testBubbleSort() {
        testSort("bubble");
    }

    @Test
    public void testSelectionSort() {
        testSort("selection");
    }

    @Test
    public void testInsertionSort() {
        testSort("insertion");
    }

    @Test
    public void testMergeSort() {
        testSort("merge");
    }

    @Test
    public void testQuickSort() {
        testSort("quick");
    }


    private void testSort(String sortType) {
        InputStream inputStream = new ByteArrayInputStream((sortType + " " + inputString).getBytes());

        sortController = new SortController(inputStream, new PrintStream(baos));
        sortController.sort();
        Assertions.assertEquals(Arrays.toString(expectedOutputArr), new String(baos.toByteArray()));
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}