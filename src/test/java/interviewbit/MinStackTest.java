package interviewbit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinStackTest {

    private MinStack<Integer> minStack;

    @BeforeEach
    void init() {
        minStack = new MinStack<>();
    }

    @Test
    void minStackTest() {
        minStack.push(18);
        assertEquals(18, minStack.top(), "Insert 18 - top");
        assertEquals(18, minStack.getMin(), "Insert 18 - peekMin");
        minStack.push(16);
        assertEquals(16, minStack.top(), "Insert 16 - top");
        assertEquals(16, minStack.getMin(), "Insert 16 - peekMin");
        minStack.push(15);
        assertEquals(15, minStack.top(), "Insert 15 - top");
        assertEquals(15, minStack.getMin(), "Insert 15 - peekMin");
        minStack.push(19);
        assertEquals(19, minStack.top(), "Insert 19 - top");
        assertEquals(15, minStack.getMin(), "Insert 19 - peekMin");
        minStack.push(26);
        assertEquals(26, minStack.top(), "Insert 26 - top");
        assertEquals(15, minStack.getMin(), "Insert 26 - peekMin");
        minStack.push(13);
        assertEquals(13, minStack.top(), "Insert 13 - top");
        assertEquals(13, minStack.getMin(), "Insert 13 - peekMin");

        assertEquals(13, minStack.pop(), "Pop 13");
        assertEquals(26, minStack.top(), "Pop 13 - top");
        assertEquals(15, minStack.getMin(), "Pop 13 - peekMin");

        assertEquals(26, minStack.pop(), "Pop 26");
        assertEquals(19, minStack.top(), "Pop 26 - top");
        assertEquals(15, minStack.getMin(), "Pop 26 - peekMin");

        assertEquals(19, minStack.pop(), "Pop 19");
        assertEquals(15, minStack.top(), "Pop 19 - top");
        assertEquals(15, minStack.getMin(), "Pop 19 - peekMin");

        assertEquals(15, minStack.pop(), "Pop 15");
        assertEquals(16, minStack.top(), "Pop 15 - top");
        assertEquals(16, minStack.getMin(), "Pop 15 - peekMin");

        assertEquals(16, minStack.pop(), "Pop 16");
        assertEquals(18, minStack.top(), "Pop 16 - top");
        assertEquals(18, minStack.getMin(), "Pop 16 - peekMin");

        assertEquals(18, minStack.pop(), "Pop 18");
        assertNull(minStack.top(), "Pop 18 - top");
        assertNull(minStack.getMin(), "Pop 18 - peekMin");
        assertNull(minStack.pop(), "Pop Empty");
    }
}
