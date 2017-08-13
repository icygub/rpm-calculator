package sample;

public class Node {

    Node prev;
    double data;
    Node next;

    public Node(double data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public void setNext(Node node) {
        next = node;
    }

}
