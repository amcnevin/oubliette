package org.technodrome.algos;

public class Collatz {

    // Collatz Sequence
    // if number is even, divide by 2
    // if number is odd, triple it and add 1

    //        { n/2     if (n % 2 == 0)
    // f(n) = {
    //        { 3n + 1  if (n % 2 == 1)

    // eventually the sequence arrives at 1
    // TODO add Memoization
    public void calculate(int n) {

        while(n != 1) {
            System.out.println(n);
            if (n % 2 == 0) {
                n = n /2;
            } else {
                n = 3*n + 1;
            }

        }
        System.out.println(n);
    }

    public static void main(String[] args) {
        Collatz collatz = new Collatz();
        collatz.calculate(6);
    }
}
