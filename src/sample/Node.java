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

    public void setPrev(double data) {
        prev = new Node(data);
    }

    public void setNext(double data) {
        next = new Node(data);
    }

    public void setNext(Node node) {
        next = node;
    }

}
