package mypack.math;

import java.math.BigInteger;

/**
 * implementation of some mathematical utilities
 * @author msb
 * @version 1.0
 */
public class MyMath 
{
    ////////////// -fakultaet- //////////////	
    public static long fakultaet(long n) {
        long produkt = 1;
        for (int i = 2; i <= n; i++)
            produkt *= i;
        return produkt;
    }

    ////////////// -potenz (double, int)- //////////////		
    public static double potenz(double x, int n) {
        double produkt = 1;
        if (n >= 0)
            for (int i = 1; i <= n; i++)
                produkt *= x;
        else
            for (int i = 1; i <= (-1) * n; i++)
                produkt /= x;
        return produkt;
    }

    ////////////// -potenz (int, int)- //////////////	
    public static long potenz(int x, int n) {
        long produkt = 1;
        if (n < 0)
            throw new java.lang.IllegalArgumentException();
        for (int i = 1; i <= n; i++)
            produkt *= x;
        return produkt;
    }

    ////////////// -eigene BigInteger-Potenz- //////////////
    /**
     * calculates x^n for BigInteger values
     */
    public static BigInteger myPow(BigInteger base, int exponent) {
        if (exponent < 0)
            throw new IllegalArgumentException("Exponent darf nicht negativ sein");

        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < exponent; i++) {
            result = result.multiply(base);
        }
        return result;
    }

    ////////////// -ggT- //////////////	
    public static int ggT(int n, int m) {
        if (m < 1 || n < 1)
            throw new java.lang.IllegalArgumentException();

        int r;
        if (m < n) {
            r = m;
            m = n;
            n = r;
        }

        do {
            r = m % n;
            m = n;
            n = r;
        } while (r != 0);

        return m;
    }

    ////////////// -isPrime (int)- //////////////
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    ////////////// -isPrime (BigInteger)- //////////////	
    /**
     * test n to be a prime number (BigInteger version)
     */
    public static boolean isPrime(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) <= 0)
            return false;
        if (n.equals(BigInteger.TWO))
            return true;
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            return false;

        BigInteger i = BigInteger.valueOf(3);
        BigInteger sqrtN = n.sqrt().add(BigInteger.ONE);

        while (i.compareTo(sqrtN) <= 0) {
            if (n.mod(i).equals(BigInteger.ZERO))
                return false;
            i = i.add(BigInteger.TWO);
        }

        return true;
    }

    ////////////// -nächste Primzahl- //////////////
    /**
     * finds the next prime number after n
     */
    public static BigInteger nextPrime(BigInteger n) {
        if (n.compareTo(BigInteger.TWO) < 0)
            return BigInteger.TWO;

        BigInteger candidate = n.add(BigInteger.ONE);
        if (candidate.mod(BigInteger.TWO).equals(BigInteger.ZERO))
            candidate = candidate.add(BigInteger.ONE);

        while (!isPrime(candidate)) {
            candidate = candidate.add(BigInteger.TWO);
        }

        return candidate;
    }

    ////////////// -binomialCoefficient- //////////////	
    public static long binomialCoefficient(int n, int k) {
        if (n == 0 || k == 0 || n == k)
            return 1;
        else
            return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }

    ////////////// -getPascalArray- //////////////	
    public static long[][] getPascalArray(int length) {
        long[][] array = new long[length][];
        for (int i = 0; i <= length - 1; i++)
            array[i] = new long[i + 1];

        for (int zeile = 1; zeile <= length; zeile++)
            for (int spalte = 1; spalte <= zeile; spalte++)
                array[zeile - 1][spalte - 1] = binomialCoefficient(zeile - 1, spalte - 1);

        return array;
    }
}
