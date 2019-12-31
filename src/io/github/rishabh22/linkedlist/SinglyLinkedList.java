package io.github.rishabh22.linkedlist;

import java.io.PrintStream;

public class SinglyLinkedList implements LinkedList {

    private Node firstNode;

    public SinglyLinkedList(PrintStream printStream) {
        System.setOut(printStream);
    }

    @Override
    public void insert(Object data) {

        if (firstNode == null) {
            firstNode = new Node(data);
            return;
        }

        Node currentNode = firstNode;

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(new Node(data));
    }

    @Override
    public void insertAtStart(Object data) {
        Node newNode = new Node(data);
        newNode.setNext(firstNode);
        firstNode = newNode;
    }

    @Override
    public void insert(int index, Object data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0 && firstNode == null) {
            this.insert(data);
            return;
        }

        Node newNode = new Node(data);

        if (index == 0) {
            newNode.setNext(firstNode);
            firstNode = newNode;
            return;
        }

        Node currentNode = firstNode;
        int curIndex = 0;
        Node prevNode = null;
        while (currentNode != null) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            curIndex++;
            if (index == curIndex) {
                newNode.setNext(currentNode);
                prevNode.setNext(newNode);
                return;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void removeFromStart() {
        if (firstNode == null) {
            throw  new IllegalStateException("Trying to remove from empty list");
        }
        firstNode = firstNode.getNext();
    }

    @Override
    public void removeLast() {
        if (firstNode == null) {
            throw  new IllegalStateException("Trying to remove from empty list");
        }

        if (firstNode.getNext() == null) {
            firstNode = null;
            return;
        }
        Node currentNode = firstNode;
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(null);
    }

    @Override
    public void remove(int index) {
        if (firstNode == null) {
            throw  new IllegalStateException("Trying to remove from empty list");
        }

        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            firstNode = firstNode.getNext();
            return;
        }
        Node currentNode = firstNode.getNext();
        int curIndex = 1;
        Node prevNode = firstNode;
        while (currentNode != null) {
            if (index == curIndex) {
                prevNode.setNext(currentNode.getNext());
                return;
            }
            curIndex++;
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void display() {
        Node currentNode = firstNode;
        System.out.print("Current List: ");
        while (currentNode != null) {
            System.out.print(currentNode.getData() + " ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    @Override
    public void reverse() {
        if (firstNode == null || firstNode.getNext() == null) {
            return;
        }

        Node currentNode = firstNode;
        Node prevNode = null;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
        firstNode = prevNode;
    }

    @Override
    public int count() {
        Node currentNode = firstNode;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.getNext();
        }
        return count;
    }

    @Override
    public Object get(int index) {
        Node currentNode = firstNode;
        int count = 0;
        while (currentNode != null) {
            if (index == count) {
                return currentNode.getData();
            }
            count++;
            currentNode = currentNode.getNext();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void empty() {
        firstNode = null;
    }
}