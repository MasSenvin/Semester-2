package vscode.Modul11;

import java.util.NoSuchElementException;
import java.util.LinkedList;

public class Stack<T> {
   
    private LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public void push(T element) {
        stack.addFirst(element);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return stack.removeFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

