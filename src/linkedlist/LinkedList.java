package linkedlist;

public interface LinkedList {

    /**
     * Insert at the end of the linked list
     * @param data Data to be held by the node
     */
    void insert(Object data);

    /**
     * Insert at the beginning of the linked list
     * @param data Data to be held by the node
     */
    void insertAtStart(Object data);

    /**
     * Insert at specified position within the linked list
     * @param index Position to be inserted at
     * @param data Data to be held by the node
     */
    void insert(int index, Object data);

    /**
     * Delete first element
     * @throws IllegalStateException If list is empty
     */
    void removeFromStart();

    /**
     * Remove last element
     * @throws IllegalStateException If list is empty
     */
    void removeLast();

    /**
     * Remove element from index
     * @param index Position to remove from
     * @throws IllegalStateException If list is empty
     * @throws IndexOutOfBoundsException If index invalid
     */
    void remove(int index);

    /**
     * Print all elements contained within the linked list
     */
    void display();

    /**
     * Reverse the underlying list
     */
    void reverse();

    /**
     * Count number of elements within the list
     * @return int Count of elements
     */
    int count();

    /**
     * Get Data at i
     * @param index index of list to fetch from
     * @return Object data
     * @throws IndexOutOfBoundsException If index invalid
     */
    Object get(int index);

    /**
     * Empty the linked list
     */
    void empty();
}
