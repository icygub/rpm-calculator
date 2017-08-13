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
            tail.setNext(node);
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
            return 0;
        } else if(size == 1){
            popped = tail.data;
            head = null;
            tail = null;
            //now there is no data in the stack
        } else {
            popped = tail.data;
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
        size--;
        return popped;
    }

    public double peek() {
        if(size == 0) {
            System.out.println("At the if statement");
            return 0; //this will be displayed in the Y register
        }

        else {
            System.out.println("At the else statement");
            return tail.data;
        }

    }

    public double peekBefore() {
        if(size == 0 || size == 1)
            return 0;
        else
            return tail.prev.data;
    }

    public double calculateOperation(char operator) {
        double result = 0;
        if(tail != null && tail.prev != null) { //minimum two numbers in the stack
            double first = pop();
            double second = pop();

            switch(operator) {
                case '+':   result = push(second + first);
                            break;
                case '-':   result = push(second - first);
                            break;
                case '*':   result = push(second * first);
                            break;
                case '/':   result = push(second / first);
                            break;
                default:    System.out.println("Invalid operator");
                            break;
            }
        }

        return result;
    }

    public void clearStack() {
        while(size > 0) {
            pop();
        }
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }
}
