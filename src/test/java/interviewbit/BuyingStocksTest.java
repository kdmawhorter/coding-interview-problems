package interviewbit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuyingStocksTest {
    
    private static final int[] TEST_0_NULL = null;
    private static final int[] TEST_1_EMPTY = {};
    private static final int[] TEST_2_ONE_ELEM = {10};
    private static final int[] TEST_3_TWO_ELEM_INC = {1, 10};
    private static final int[] TEST_4_TWO_ELEM_DEC = {10, 1};
    private static final int[] TEST_5_THREE_ELEM_INC = {1, 3, 10};
    private static final int[] TEST_6_THREE_ELEM_DEC = {1, 10, 1};
    private static final int[] TEST_7_SMALL_TEST = {3, 1, 4, 8, 2};
    private static final int[] TEST_8_INTERNET_TEST_I = {7, 2, 4, 8, 7};
    private static final int[] TEST_9_INTERNET_TEST_II = {1, 2, 1, 2};
    private static final int[] TEST_10_ALL_DECREASING = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final int[] TEST_11_Pairs = {1, 2, 1, 3, 1, 4, 1, 4, 1, 3, 1, 2};
    private BuyingStocks buyingStocks;
    
    @BeforeEach
    void init() {
        buyingStocks = new BuyingStocks();
    }
    
    @Test
    void bestTimeToBuy_2Test() {
        assertEquals(0, buyingStocks.bestTimeToBuy_2(TEST_0_NULL), 
                "Test 0 - Null");
        assertEquals(0, buyingStocks.bestTimeToBuy_2(TEST_1_EMPTY), 
                "Test 1 - Empty");
        assertEquals(0, buyingStocks.bestTimeToBuy_2(TEST_2_ONE_ELEM), 
                "Test 2 - One Elem");
        assertEquals(9, buyingStocks.bestTimeToBuy_2(TEST_3_TWO_ELEM_INC), 
                "Test 3 - Two Elem Inc");
        assertEquals(0, buyingStocks.bestTimeToBuy_2(TEST_4_TWO_ELEM_DEC), 
                "Test 4 - Two Elem Dec");
        assertEquals(9, buyingStocks.bestTimeToBuy_2(TEST_5_THREE_ELEM_INC), 
                "Test 5 - Three Elem Inc");
        assertEquals(9, buyingStocks.bestTimeToBuy_2(TEST_6_THREE_ELEM_DEC), 
                "Test 6 - Three Elem Dec");
        assertEquals(7, buyingStocks.bestTimeToBuy_2(TEST_7_SMALL_TEST), 
                "Test 7 - Small Test");
        assertEquals(6, buyingStocks.bestTimeToBuy_2(TEST_8_INTERNET_TEST_I),
                "Test 8 - Internet Test I");
        assertEquals(2, buyingStocks.bestTimeToBuy_2(TEST_9_INTERNET_TEST_II),
                "Test 9 - Internet Test II");
        assertEquals(0, buyingStocks.bestTimeToBuy_2(TEST_10_ALL_DECREASING),
                "Test 10 - All decreasing");
        assertEquals(6, buyingStocks.bestTimeToBuy_2(TEST_11_Pairs),
                "Test 11 - Pairs");
    }

    @Test
    void bestTimeToBuy_3Test() {
        assertEquals(0, buyingStocks.bestTimeToBuy_3(TEST_0_NULL),
                "Test 0 - Null");
        assertEquals(0, buyingStocks.bestTimeToBuy_3(TEST_1_EMPTY),
                "Test 1 - Empty");
        assertEquals(0, buyingStocks.bestTimeToBuy_3(TEST_2_ONE_ELEM),
                "Test 2 - One Elem");
        assertEquals(9, buyingStocks.bestTimeToBuy_3(TEST_3_TWO_ELEM_INC),
                "Test 3 - Two Elem Inc");
        assertEquals(0, buyingStocks.bestTimeToBuy_3(TEST_4_TWO_ELEM_DEC),
                "Test 4 - Two Elem Dec");
        assertEquals(9, buyingStocks.bestTimeToBuy_3(TEST_5_THREE_ELEM_INC),
                "Test 5 - Three Elem Inc");
        assertEquals(9, buyingStocks.bestTimeToBuy_3(TEST_6_THREE_ELEM_DEC),
                "Test 6 - Three Elem Dec");
        assertEquals(7, buyingStocks.bestTimeToBuy_3(TEST_7_SMALL_TEST),
                "Test 7 - Small Test");
        assertEquals(6, buyingStocks.bestTimeToBuy_3(TEST_8_INTERNET_TEST_I),
                "Test 8 - Internet Test I");
        assertEquals(2, buyingStocks.bestTimeToBuy_3(TEST_9_INTERNET_TEST_II),
                "Test 9 - Internet Test II");
        assertEquals(0, buyingStocks.bestTimeToBuy_3(TEST_10_ALL_DECREASING),
                "Test 10 - All decreasing");
        assertEquals(6, buyingStocks.bestTimeToBuy_3(TEST_11_Pairs),
                "Test 11 - Pairs");
    }
}
