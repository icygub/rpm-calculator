package sample;

import static org.junit.Assert.*;

public class RPNStackTest {
    @org.junit.Test
    public void push() throws Exception {
        RPNStack stack = new RPNStack();
        System.out.println(stack.push(1));
        System.out.println(stack.push(2));
        System.out.println(stack.push(3));
        System.out.println(stack.push(4));
        System.out.println(stack.push(5));
        System.out.println(stack.push(6));
        System.out.println(stack.push(7));

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    @org.junit.Test
    public void pop() throws Exception {
        char c = '/';
        System.out.println(c);
    }

    @org.junit.Test
    public void calculateOperation() throws Exception {
        String string = "hello.";
        String string2 = string.substring(string.length()-1, string.length());
        System.out.println(string2);
        double d = 1. + 2;
        System.out.println(d);
//        RPNStack stack = new RPNStack();
//        for (int i = 1; i < 6; i++) {
//            System.out.println(stack.push(i));
//
//        }
//        System.out.println("==============");

//        System.out.println(stack.pop());
//        System.out.println(stack.peek());

//        System.out.println(stack.peek());
//        System.out.println(stack.peekBefore());
//        System.out.println(stack.peek());
//        System.out.println(stack.peekBefore());


    }
}