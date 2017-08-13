package sample;

import static org.junit.Assert.*;

public class RPNStackTest {

    @org.junit.Test
    public void push() throws Exception { //testing complete
        RPNStack stack = new RPNStack();
        for (int i = 1; i < 8; i++) {
            stack.push(i);
            assertTrue(stack.getTail().data == i);
        }
    }

    @org.junit.Test
    public void pop() throws Exception { //testing complete
        RPNStack stack = new RPNStack();
        for (int i = 1; i < 8; i++) {
            stack.push(i);
        }

        for (int i = 7; i > 0; i--) {
            assertTrue(stack.getTail().data == i);
            stack.pop();
        }
    }

    @org.junit.Test
    public void peek() throws Exception {
        RPNStack stack = new RPNStack();
        for (int i = 1; i < 8; i++) {
            stack.push(i);
            assertTrue(stack.peek() == i);
        }
    }

    @org.junit.Test
    public void calculateOperation() throws Exception { //testing complete
        RPNStack stack = new RPNStack();
        stack.push(2);
        stack.push(3);
        assertTrue(stack.calculateOperation('-') == -1);

        stack.push(2.5);
        assertTrue(stack.calculateOperation('+') == 1.5);

        stack.push(12.5);
        assertTrue(stack.calculateOperation('+') == 14);

        stack.push(7);
        assertTrue(stack.calculateOperation('/') == 2);

        stack.push(2);
        assertTrue(stack.calculateOperation('*') == 4);
    }

    @org.junit.Test
    public void clearStack() throws Exception {
        RPNStack stack = new RPNStack();
        for (int i = 1; i < 8; i++) {
            stack.push(i);
        }

        stack.clearStack();
        assertTrue(stack.getTail() == null);
    }
}