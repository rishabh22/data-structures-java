package linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

class LinkedListTest {

    LinkedList linkedList;

    @Test
    void testSinglyLinkedList() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream osPrintStream = new PrintStream(baos);
        linkedList = new SinglyLinkedList(osPrintStream);
        StringBuilder expectedDisplay = new StringBuilder();

        //Test count of empty list
        Assertions.assertEquals(0, linkedList.count());

        //Test get from
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));

        //Check display of empty list
        linkedList.display();
        expectedDisplay.append("Current List: ").append(System.lineSeparator());
        Assertions.assertEquals(expectedDisplay.toString(), new String(baos.toByteArray()));

        //Trying to remove last from empty list
        Assertions.assertThrows(IllegalStateException.class, () -> linkedList.removeLast());

        //Trying to remove first from empty list
        Assertions.assertThrows(IllegalStateException.class, () -> linkedList.removeFromStart());

        //Trying to remove from position n of empty list
        Assertions.assertThrows(IllegalStateException.class, () -> linkedList.remove(1));


        //Test Insertion
        linkedList.insert(1);
        Assertions.assertEquals(1, linkedList.get(0));

        //Test Insertion
        linkedList.insert(3);
        Assertions.assertEquals(3, linkedList.get(linkedList.count() - 1));

        //Test Insertion
        linkedList.insert(7);
        Assertions.assertEquals(7, linkedList.get(linkedList.count() - 1));

        //Test Insertion
        linkedList.insert(-2);
        Assertions.assertEquals(-2, linkedList.get(linkedList.count() - 1));

        //Test Insertion
        linkedList.insert(5);
        Assertions.assertEquals(5, linkedList.get(linkedList.count() - 1));

        //Test Count
        Assertions.assertEquals(5, linkedList.count());

        //Test Get at index
        Assertions.assertEquals(3, linkedList.get(1));


        //Test Insertion
        linkedList.insertAtStart(10);
        Assertions.assertEquals(10, linkedList.get(0));


        //Test Insertion at index 0
        linkedList.insert(0, -1);
        Assertions.assertEquals(-1, linkedList.get(0));

        //Test Insertion at new index
        linkedList.insert(linkedList.count(), -10);
        Assertions.assertEquals(-10, linkedList.get(linkedList.count() - 1));

        //Test Insertion at last existing index
        linkedList.insert(linkedList.count() - 1, -100);
        Assertions.assertEquals(-100, linkedList.get(linkedList.count() - 2));

        //Test Insertion in middle
        linkedList.insert(4, -7);
        Assertions.assertEquals(-7, linkedList.get(4));


        //Test Display
        linkedList.display();
        expectedDisplay.append("Current List: -1 10 1 3 -7 7 -2 5 -100 -10 ").append(System.lineSeparator());
        Assertions.assertEquals(expectedDisplay.toString(), new String(baos.toByteArray()));


        //Test Delete from beginning
        linkedList.removeFromStart();
        linkedList.display();
        expectedDisplay.append("Current List: 10 1 3 -7 7 -2 5 -100 -10 ").append(System.lineSeparator());
        Assertions.assertEquals(expectedDisplay.toString(), new String(baos.toByteArray()));

        //Test Delete from end
        linkedList.removeLast();
        linkedList.display();
        expectedDisplay.append("Current List: 10 1 3 -7 7 -2 5 -100 ").append(System.lineSeparator());
        Assertions.assertEquals(expectedDisplay.toString(), new String(baos.toByteArray()));

        //Test Insertion
        linkedList.insert(6);
        Assertions.assertEquals(6, linkedList.get(linkedList.count() - 1));

        //Test List Reversal
        linkedList.reverse();
        linkedList.display();
        expectedDisplay.append("Current List: 6 -100 5 -2 7 -7 3 1 10 ").append(System.lineSeparator());
        Assertions.assertEquals(expectedDisplay.toString(), new String(baos.toByteArray()));

        //Test Insertion in middle
        linkedList.insert(1, -10);
        linkedList.display();
        expectedDisplay.append("Current List: 6 -10 -100 5 -2 7 -7 3 1 10 ").append(System.lineSeparator());
        Assertions.assertEquals(expectedDisplay.toString(), new String(baos.toByteArray()));


        //Test Delete at index
        linkedList.remove(2);
        linkedList.display();
        expectedDisplay.append("Current List: 6 -10 5 -2 7 -7 3 1 10 ").append(System.lineSeparator());
        Assertions.assertEquals(expectedDisplay.toString(), new String(baos.toByteArray()));

        linkedList.remove(0);
        linkedList.display();
        expectedDisplay.append("Current List: -10 5 -2 7 -7 3 1 10 ").append(System.lineSeparator());
        Assertions.assertEquals(expectedDisplay.toString(), new String(baos.toByteArray()));

        //Test remove at last index+1
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(linkedList.count()));

        //Test remove from last index
        linkedList.remove(linkedList.count()-1);
        linkedList.display();
        expectedDisplay.append("Current List: -10 5 -2 7 -7 3 1 ").append(System.lineSeparator());
        Assertions.assertEquals(expectedDisplay.toString(), new String(baos.toByteArray()));
    }
}