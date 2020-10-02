package kyh.lectures.lecture8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Testing that addition works")
    void addition() {
        assertEquals(6, calculator.add(4, 2));
        assertEquals(5, calculator.add(5,0));
    }
    @Test
    @DisplayName("Testing that subtraction works")
    void subtraction(){
        assertEquals(0, calculator.sub(2,2));
        assertEquals(20, calculator.sub(15,-5));
    }
    @Test
    @DisplayName("Testing that multiplication works")
    void multiplication(){
        assertEquals(2, calculator.multi(1,2));
        assertEquals(-35, calculator.multi(-5, 7));
    }
    @Test
    @DisplayName("Testing that division works")
    void division(){
        assertEquals(1, calculator.div(2,2));
        assertEquals(1, calculator.div(2,2));
    }
    @Test
    @DisplayName("Testing that modulus works")
    void modulus(){
        assertEquals(0, calculator.mod(10,2));
        assertEquals(0,calculator.mod(20,2));
    }

    @Test
    @DisplayName("Testing that max works")
    void maxvalue(){
        assertEquals(10,calculator.max(10,5));
        assertEquals(10, calculator.max(10,5));
    }
}
