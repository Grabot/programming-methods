//# BEGIN SKELETON

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for top-level methods in {@code MathStuff}.
 *
 * <!--//# BEGIN TODO Name, student id, and date-->
 * <p>
 * <font color="green"><b>
 * Sander Kools 0848523 Group 1 Wesselink 16-02-2014
 * </b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class MathStuffTestTopLevel {

    // Test cases for power(int, int).
    /**
     * Invokes power(a, b) and checks for expected result.
     *
     * @param a the base
     * @param b the exponent
     * @param expResult the expected result
     * @pre {@code 0 <= b && expResult = a ^ b}
     */
    private void checkPower(int a, int b, long expResult) {
        System.out.println("power(" + a + ", " + b + ")");
        long result = MathStuff.power(a, b);
        assertEquals("result", expResult, result);
    }

    /**
     * Smallest exponent.
     */
    @Test
    public void testPower0() {
        checkPower(0, 0, 1);
    }

    /**
     * Exponent 1.
     */
    @Test
    public void testPower1() {
        checkPower(2, 1, 2);
    }

    /**
     * Exponent 2.
     */
    @Test
    public void testPower2() {
        checkPower(3, 2, 9);
    }

    /**
     * Largest base and smallest exponent without overflow.
     */
    @Test(timeout = 100)
    public void testPowerSmallestNoOverflow() {
        int n = Integer.MAX_VALUE;
        checkPower(n, 1, n);
    }

    /**
     * Smallest base > 1 and largest exponent without overflow.
     */
    @Test(timeout = 100)
    public void testPowerLargestNoOverflow() {
        checkPower(2, 30, Integer.MAX_VALUE / 2 + 1);
    }

    /**
     * Largest base and smallest exponent > 1 with overflow.
     */
    @Test(timeout = 100)
    public void testPowerSmallestOverflow() {
        checkPower(46341, 2, Long.MAX_VALUE);
    }

    /**
     * Smallest base > 1 and smallest exponent with overflow.
     */
    @Test(timeout = 100)
    public void testPowerLargestOverflow() {
        checkPower(2, 31, Long.MAX_VALUE);
    }

    /**
     * Invokes {@code power(a, b)} and checks for expected exception.
     *
     * @param a base
     * @param b exponent
     * @param expected expected exception
     */
    private void checkPowerException(int a, int b, Class expected) {
        System.out.println("power(" + a + ", " + b + "), for exception");
        try {
            MathStuff.power(a, b);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    /**
     * Negative base, non-negative exponent.
     */
    @Test(timeout = 100)
    public void testPowerExceptionA() {
        checkPowerException(-1, 0, IllegalArgumentException.class);
    }

    /**
     * Negative exponent, non-negative base.
     */
    @Test(timeout = 100)
    public void testPowerExceptionB() {
        checkPowerException(0, -1, IllegalArgumentException.class);
    }

    // Test cases for power(Power)
    /**
     * Smoke test.
     */
    @Test
    public void testPowerPower() {
        System.out.println("power(new Power(3, 2))");
        MathStuff.Power p = new MathStuff.Power(3, 2);
        assertEquals("result", 3 * 3, MathStuff.power(p));
    }

    // Test cases for powerize(int)
    /**
     * Invokes powerize(power(expB, expE)) and checks for expected result.
     *
     * @param expB expected base
     * @param expE expected exponent
     * @pre {@code expB} is not a power with exponent greater than one
     */
    private void checkPowerize(int expB, int expE) {
        long n = MathStuff.power(expB, expE);
        System.out.println("powerize(" + n + ")");
        MathStuff.Power result = MathStuff.powerize((int) n);
        assertEquals("power", n, MathStuff.power(result));
        assertEquals("base", expB, result.base);
        assertEquals("exponent", expE, result.exponent);
    }

    /**
     * Invokes powerize functions and should throw an exception
     *
     * @param n
     * @param expected
     * @pre {@code n} is not a valid number for powerize function
     */
    private void checkPowerizeException(int n, Class expected) {
        System.out.println("powerize(" + n + "), for exception");
        try {
            MathStuff.powerize(n);
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

//# BEGIN TODO Implementations of test cases for powerize(int)
    /**
     * general test small 2^2
     */
    @Test
    public void testPowerizeGeneral1() {
        //4
        int b = 2;
        int e = 2;
        checkPowerize(b, e);
    }

    /**
     * general test small 2^3
     */
    @Test
    public void testPowerizeGeneral2() {
        //8
        int b = 2;
        int e = 3;
        checkPowerize(b, e);
    }

    /**
     * general test normal 7^3
     */
    @Test
    public void testPowerizeGeneral3() {
        //343
        int b = 7;
        int e = 3;
        checkPowerize(b, e);
    }

    /**
     * general test normal 3^8
     */
    @Test
    public void testPowerizeGeneral4() {
        //3561
        int b = 3;
        int e = 8;
        checkPowerize(b, e);
    }

    /**
     * general test big 2^30
     */
    @Test
    public void testPowerizeGeneral5() {
        //1073741824
        int b = 2;
        int e = 30;
        checkPowerize(b, e);
    }

    /**
     * general small 3^3
     */
    @Test
    public void testPowerizeGeneral6() {
        //81
        int b = 3;
        int e = 3;
        checkPowerize(b, e);
    }

    /**
     * general test big 71^3
     */
    @Test
    public void testPowerizeGeneral7() {
        //5041
        int b = 71;
        int e = 3;
        checkPowerize(b, e);
    }

    /**
     * general test big 71^5
     */
    @Test
    public void testPowerizeGeneral8() {
        int b = 71;
        int e = 5;
        checkPowerize(b, e);
    }

    /**
     * general test big 80^2
     */
    @Test
    public void testPowerizeGeneral9() {
        int b = 80;
        int e = 2;
        checkPowerize(b, e);
    }

    /**
     * general test big 6^2
     */
    @Test
    public void testPowerizeGeneral10() {
        int b = 6;
        int e = 2;
        checkPowerize(b, e);
    }

    /**
     * general test big 14^4
     */
    @Test
    public void testPowerizeGeneral11() {
        int b = 14;
        int e = 4;
        checkPowerize(b, e);
    }

    /**
     * high prime test big 3727^2
     */
    @Test
    public void testHighPrimeExponent1() {
        int b = 3727;
        int e = 2;
        checkPowerize(b, e);
    }

    /**
     * max value test big 2147483647
     */
    @Test
    public void testMaxValuePrime() {
        int b = 2147483647;
        int e = 1;
        checkPowerize(b, e);
    }

    /**
     * high value prime test big 7643^2
     */
    @Test
    public void testHighPrimeExponent2() {
        int b = 7643;
        int e = 2;
        checkPowerize(b, e);
    }

    /**
     * high value prime test big 197^3
     */
    @Test
    public void testHighPrimeExponent4() {
        int b = 197;
        int e = 3;
        checkPowerize(b, e);
    }

    /**
     * high value prime test big 38851^2
     */
    @Test
    public void testHighPrimeExponent3() {
        int b = 38851;
        int e = 2;
        checkPowerize(b, e);
    }

    /**
     * purposely trying to break the function by sending wrong values to see if
     * the correct catch gets thrown
     */
    @Test
    public void testIlligalArg() {
        checkPowerizeException(1, IllegalArgumentException.class);
    }

    /**
     * purposely trying to break the function by sending wrong values to see if
     * the correct catch gets thrown, this time negative values
     */
    @Test
    public void testIlligalArgNegative() {
        checkPowerizeException(-20, IllegalArgumentException.class);
    }
    //# END TODO

}
//# END SKELETON
