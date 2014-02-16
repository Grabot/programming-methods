//# BEGIN SKELETON

import java.util.ArrayList;
import java.util.List;

/**
 * Library with static mathematical functions.
 *
 * <!--//# BEGIN TODO Name, student id, and date-->
 * <p>
 * <font color="green"><b>
 * Sander Kools 0848523 Group 1 Wesselink 16-02-2014
 * </b></font></p>
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public abstract class MathStuff {

    /**
     * Returns exponentiation, taking care of overflow.
     *
     * @param a the base
     * @param b the exponent
     * @pre {@code 0 <= a && 0 <= b}
     * @return {@code a ^ b} if {@code a ^ b <= Integer.MAX_VALUE} else
     * {@code Long.MAX_VALUE}
     * @throws IllegalArgumentException if precondition violated
     */
    public static long power(int a, int b) throws IllegalArgumentException {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("power: negative argument");
        }
        // 0 <= a && 0 <= b
        long x = a; // see invariant
        int k = b; // see invariant
        long result = 1L; // see invariant

        // invariant: 0 <= k <= b && result * x^k == a^b
        while (k != 0) {
            if (k % 2 == 0) { // even exponent
                if (x <= Integer.MAX_VALUE) {
                    x *= x;
                } else {
                    x = Long.MAX_VALUE;
                }
                k /= 2;
            } else { // odd exponent
                if (result <= Integer.MAX_VALUE && x <= Integer.MAX_VALUE) {
                    result *= x;
                } else {
                    result = Long.MAX_VALUE;
                }
                k -= 1;
            }
            // invariant holds again, k has decreased
        }
        // k == 0, hence result == a^b

        if (result > Integer.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return result;
    }

    /**
     * Record containing a base and an exponent.
     *
     * @inv {@code 0 <= base && 0 <= exponent}
     */
    public static class Power { // BEGIN RECORD TYPE

        /**
         * The base.
         */
        public int base;

        /**
         * The exponent.
         */
        public int exponent;

        /**
         * Constructs a Power with given base and exponent.
         *
         * @param base the base
         * @param exponent the exponent
         * @pre {@code 0 <= base && 0 <= exponent}
         * @post {@code \result.base == base && \result.exponent == exponent}
         */
        public Power(int base, int exponent) {
            this.base = base;
            this.exponent = exponent;
        }

    } // END RECORD TYPE

    /**
     * Returns exponentiation.
     *
     * @param p the base and exponent
     * @pre {@code p != null}
     * @return {@code power(p.base, p.exponent)}
     * @throws IllegalArgumentException if precondition violated
     */
    public static long power(Power p) throws IllegalArgumentException {
        return power(p.base, p.exponent);
    }

    /**
     * Writes a number as a power with maximal exponent.
     *
     * @param n the number to 'powerize'
     * @return power decomposition of {@code n} with maximal exponent
     * @throws IllegalArgumentException if precondition violated
     * @pre {@code 2 <= n}
     * @post {@code n == power(\result) &&
     *     (\forall int b, int e;
     *      2 <= b && 1 <= e && n == b ^ e;
     *      e <= \result.exponent)}
     */
    public static Power powerize(int n) throws IllegalArgumentException {
        //# BEGIN TODO Implementation of powerize
        if (n < 2) {
            throw new IllegalArgumentException("precondition "
                    + "violated, n is: " + n);
        }

        //initialize variables for the base and the exponent
        int exponent;
        int base;
        //base starts at 2, because you can always divide by 1, you only have to
        //use prime numbers but were not doing it right now, cause i don't know
        //how :'('' it uses 191 as max prime, because it's the first prime
        //where n^3 falls in the int.MaxValue 
        for (base = 2; base <= 191; base++) {
            //its divisable by the base, therefore this base could be the right
            //base, it is not possible that it has a higher base, so if this
            //is not the right one there is no base and exponent except for
            //the same number with exponent 1
            if ((n % base) == 0) {
                //find exponent
                exponent = powerExponent(base, n);
                if (!(exponent == 1)) {
                    return (new Power(base, exponent));
                }
            }
        }

        //no base small enough found, there are still possibilities for bases of
        //high primes with exponent of minimal 2 and maximum 3, so we do another
        //loop, the other way this time with exponent input and finding the base
        for (exponent = 2; exponent <= 3; exponent++) {
            base = powerBase(exponent, n);
            if (!(base == 1)) {
                return (new Power(base, exponent));
            }
        }

        return (new Power(n, 1));
        //# END TODO
    }

    //# BEGIN TODO Contracts and implementations of auxiliary functions.
    /**
     * find a number such that the given base to the power of the number is the
     * same as the given n, which is the number we want to find.
     *
     * @param base the base that has been found
     * @param n the number that was input
     * @return the maximal exponent of number {@code n} with base {@code}
     * @pre {@code base >= 2 && @code n >= 2}
     * @post {@code \result == {\int number == n{ \forall exponent; number =
     * numer/base, if number == 1(result = exponent) else if !(number % base)
     * == 0 (result = 1) } result = 1 }}
     */
    public static int powerExponent(int base, int n) {
        //initialize variable
        int number = n;
        for (int exponent = 1; exponent < 31; exponent++) {
            //divide further by the same base
            number = (number / base);
            if (number == 1) {
                //power found
                return exponent;
            } else if (!((number % base) == 0)) {
                //no power to be found
                return 1;
            }
        }
        //if no exponent is found we can guarentee that there is no base
        //therefore it is the number to the power 1
        return 1;
    }

    /**
     * find a number such that the number to the power of the given exponent is
     * equal to the number has to be found, then you have your base and exponent
     *
     * @param exponent
     * @param number
     * @return the base for the number with the given exponent
     * @post {@code \result == {\int high == n \int low == 0 \int mid \long
     * power {\while low <= (high-2); mid = (low + (high - low) / 2)
     * power = MathStuff.power(mid, exponent) if power == number(return mid)
     * else if power > number(high = mid) else if power < number(low = mid)}
     * return 1}}
     *
     */
    public static int powerBase(int exponent, int number) {
        //initialize variables, the power is a long in case it exceeds
        //the maximum int values.
        long power;
        int low = 0;
        int high = number;
        int mid;
        //a while loop that finds the base, when the value of low is less 
        //the the value of high - 2, there is no base with the given exponent
        //it then returns 1, this way we can identify when there is no base
        while (low <= (high - 2)) {
            mid = low + (high - low) / 2;
            //the number is tested by powering it to see if it will be correct
            power = power(mid, exponent);
            if (power == number) {
                return mid;
            } else if (power > number) {
                high = mid;
            } else if (power < number) {
                low = mid;
            }
        }
        return 1;
    }
    //# END TODO
}
//# END SKELETON
