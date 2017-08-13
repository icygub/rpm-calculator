package sample;

public class RPNStack {

    private Node tail;
    private int size;

    public RPNStack() {
        tail = null;
        size = 0;
    }

    public double push(double data) {
        Node node = new Node(data);
        if(size == 0) {
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
            return 0;
        } else if(size == 1){
            popped = tail.data;
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
            return 0; //this will be displayed in the Y register
        } else {
            return tail.data;
        }
    }

    /**
     * Returns the value before the tail.
     * @return
     */
    public double peekBefore() {
        if(size == 0 || size == 1)
            return 0;
        else
            return tail.prev.data;
    }

    public double calculateOperation(char operator) {
        double result = 0;

        //minimum two numbers in the stack
        if(tail != null && tail.prev != null) {
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

    /**
     * This method is only for unit testing purposes
     * @return
     */
    public Node getTail() {
        return tail;
    }
}
