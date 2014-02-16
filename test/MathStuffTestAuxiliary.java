//# BEGIN SKELETON

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test cases for auxiliary methods in {@code MathStuff}.
 *
 * <!--//# BEGIN TODO Name, student id, and date-->
 * <p>
 * <font color="red"><b>Replace this line</b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class MathStuffTestAuxiliary {

    //# BEGIN TODO Test cases for auxiliary functions
    /**
     * Invokes powerExponent(base, number) and checks for expected result.
     *
     * @param base the base
     * @param number the given number
     * @param expResult the expected result
     * @pre {@code 2 <= base && base ^ expResult = number}
     */
    private void checkPowerExponent(int base, int number, int expResult) {
        System.out.println("find power of(" + base + ", " + number + ")");
        int result = MathStuff.powerExponent(base, number);
        assertEquals("result", expResult, result);
    }

    /**
     * Invokes powerBase(exponent, number) and checks for expected result.
     *
     * @param base the base
     * @param number the given number
     * @param expResult the expected result
     * @pre {@code 1 <= exponent && expResult ^ exponent = number}
     */
    private void checkPowerBase(int exponent, int number, int expResult) {
        System.out.println("find base of(" + exponent + ", " + number + ")");
        int result = MathStuff.powerBase(exponent, number);
        assertEquals("result", expResult, result);
    }

    /**
     * general test small 2^2 for power find function
     */
    @Test
    public void testCheckPowerMinimal() {
        //expected 2^1 = 2, 1
        checkPowerExponent(2, 2, 1);
    }

    /**
     * general test small 3^3 for power find function
     */
    @Test
    public void testCheckPowerGeneral1() {
        checkPowerExponent(3, 27, 3);
    }

    /**
     * general test normal 5^6 for power find function
     */
    @Test
    public void testCheckPowerGeneral2() {
        checkPowerExponent(5, 15625, 6);
    }

    /**
     * general test big 8^7 for power find function
     */
    @Test
    public void testCheckPowerGeneral3() {
        //the base can be smaller, but the function works with every send base
        checkPowerExponent(8, 2097152, 7);
    }

    /**
     * general test big 808080808^1 for power find function
     */
    @Test
    public void testCheckPowerGeneral4() {
        //there can be a power to function, but it works with every send base
        checkPowerExponent(808080808, 808080808, 1);
    }

    /**
     * general test normal 12^4 for power function
     */
    @Test
    public void testCheckPowerGeneral5() {
        checkPowerExponent(12, 20736, 4);
    }

    /**
     * general test big for power find function
     */
    @Test
    public void testCheckPowerMaxPrime() {
        checkPowerExponent(2147483647, 2147483647, 1);
    }

    /**
     * test big primes for power find function
     */
    @Test
    public void testCheckPowerHighPrimes1() {
        checkPowerExponent(3727, 13890529, 2);
    }

    /**
     * test big primes for power find function
     */
    @Test
    public void testCheckPowerHighPrimes2() {
        checkPowerExponent(71, 1804229351, 5);
    }

    /**
     * test big, base find function 13469^2
     */
    @Test
    public void testCheckPowerGeneralBase1() {
        //there can be a power to function, but it works with every send base
        checkPowerBase(2, 181413961, 13469);
    }

    /**
     * test big, base find function 22171^2
     */
    @Test
    public void testCheckPowerGeneralBase2() {
        //there can be a power to function, but it works with every send base
        checkPowerBase(2, 491553241, 22171);
    }

    /**
     * test big, base find function 27271^2
     */
    @Test
    public void testCheckPowerGeneralBase3() {
        checkPowerBase(2, 743707441, 27271);
    }

    /**
     * test big, base find function 2857^2
     */
    @Test
    public void testCheckPowerGeneralBase4() {
        checkPowerBase(2, 8162449, 2857);
    }

    /**
     * test big primes, base find function
     */
    @Test
    public void testCheckPowerMaxPrimeBase() {
        //expected result is 1, because then the number itself is returned in
        //in the main function
        checkPowerBase(1, 2147483647, 1);
    }

    /**
     * test big primes, base find function
     */
    @Test
    public void testCheckPowerHighPrimesBase1() {
        checkPowerBase(2, 13890529, 3727);
    }

//# END TODO
}
//# END SKELETON
