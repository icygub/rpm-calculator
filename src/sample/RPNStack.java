package sample;

public class RPNStack {

    private Node head;
    private Node tail;
    private int size;

    public RPNStack() {
        head = null;
        tail = null;
        size = 0;
    }

    public double push(double data) {
        Node node = new Node(data);
        if(size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        size++;
        return tail.data;
    }

    public double pop() {
        double popped;
        if(size == 0) {
            System.out.println("Nothing to pop!");
            return -1.23456;
        } else if(size == 1){
            popped = tail.data;
            head = null;
            tail = null;
        } else {
            popped = tail.data;
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
        size--;
        return popped;
    }
}
