package mypack.math;

import java.math.BigInteger;

public class TestMyMath {
    public static void main(String[] args) {
        System.out.println("2^10 = " + MyMath.myPow(BigInteger.valueOf(2), 10));
        System.out.println("Ist 97 eine Primzahl? " + MyMath.isPrime(BigInteger.valueOf(97)));
        System.out.println("Nächste Primzahl nach 100: " + MyMath.nextPrime(BigInteger.valueOf(100)));
    }
}
