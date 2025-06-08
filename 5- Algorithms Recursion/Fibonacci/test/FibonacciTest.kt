import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class FibonacciTest {

    @Test
    fun testFibonacciBaseCases() {
        assertEquals(0, fibonacciRecursive(0))
        assertEquals(1, fibonacciRecursive(1))
    }

    @Test
    fun testFibonacciSmallNumbers() {
        assertEquals(1, fibonacciRecursive(2))
        assertEquals(2, fibonacciRecursive(3))
        assertEquals(3, fibonacciRecursive(4))
        assertEquals(5, fibonacciRecursive(5))
    }

    @Test
    fun testFibonacciLargerNumbers() {
        assertEquals(13, fibonacciRecursive(7))
        assertEquals(21, fibonacciRecursive(8))
        assertEquals(34, fibonacciRecursive(9))
    }
}