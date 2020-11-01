package project_2;

public class StackedArrayList<T> {
    private class Node {
        // Data fields
        public T data;
        public Node next;
        // Constructor
        public Node(T theData) { data = theData; }
    }

    // Data fields
    private Node top;
    private int numOfItems;

    // Constructor
    public StackedArrayList() {}  // Default constructor
    public StackedArrayList(StackedArrayList<T> other) {  // Copy constructor
        numOfItems = other.numOfItems;
        if (numOfItems > 0) {
            top = new Node(other.top.data);
            Node p = top, q = other.top.next;
            while (q != null) {
                p.next = new Node(q.data);
                p = p.next;
                q = q.next;
            }
        }
    }

    // Methods

    /** Gets the top value in the stack.
     @return: the top value in the stack
     @throws Exception: empty stack
     */
    public T peek() throws Exception {
        if (empty()) { throw new Exception("Attempt to access item in empty stack."); }
        return top.data;
    }

    /** Removes and returns the top value in the stack.
     @return: the top value removed
     @throws Exception: empty stack
     */
    public T pop() throws Exception {
        if (empty()) { throw new Exception("Attempt to remove item from empty stack."); }
        T toBeRemoved = top.data;
        top = top.next;
        numOfItems--;
        return toBeRemoved;
    }

    /** Adds an item on top of the stack.
     @param item: the value to be added
     */
    public void push(T item) {
        Node newTop = new Node(item);
        newTop.next = top;
        top = newTop;
        numOfItems++;
    }

    /** Gets the number of items stored in the stack.
     @return: the number of items stored in the stack
     */
    public int size() {
        return numOfItems;
    }

    /** Tests whether the stack is empty.
     @return: {true} if the stack is empty; {false} otherwise
     */
    public boolean empty() {
        return numOfItems == 0;
    }
}
