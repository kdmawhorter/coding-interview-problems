package interviewbit;

import java.util.Stack;

/**
 * A class capable of keeping a stack with push, pop, top (peek), getMin (like peekMin) all  in O(1). Answers the
 * problem posed at <a href="https://www.interviewbit.com/problems/min-stack/">Min Stack</a>
 * @param <T> An object which extends the comparable class.
 */
public class MinStack<T extends Comparable<T>> {

    private final Stack<T> elementStack,  minStack;

    /**
     * MinStack constructor.
     */
    MinStack() {
        elementStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Adds an element onto the end of the stack.
     * @param newElement The new element to be added to the stack.
     */
    public void push(T newElement) {
        elementStack.push(newElement);
        if (minStack.size()>0) {
            newElement = newElement.compareTo(minStack.peek())<0 ? newElement : minStack.peek();
        }
        minStack.push(newElement);
    }

    /**
     * Removes and returns the element at the end of the stack.
     * @return The element at the end of the stack.
     */
    public T pop() {
        if (elementStack.size()>0) {
            minStack.pop();
            return elementStack.pop();
        }
        return null;
    }

    /**
     * Returns but does not remove the element at the end of the stack.
     * @return The element at the end of the stack.
     */
    public T top() {
        return elementStack.size()>0 ? elementStack.peek() : null;
    }

    /**
     * Returns but does not remove the minimum element in the stack.
     * @return The minimum element in the stack.
     */
    public T getMin() {
        return minStack.size()>0 ? minStack.peek() : null;
    }
}
