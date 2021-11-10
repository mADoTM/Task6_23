package ru.vsu.cs.dolzhenkoms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double pow = readPow();

        double sumOfSequence = getSumOfSequence(pow);
        double sumOfSequenceMoreThanEpsilon = getSumOfSequenceMoreThanEpsilon(pow, Math.E);
        double sumOfSequenceMoreThanEpsilonDividedBy10 = getSumOfSequenceMoreThanEpsilon(pow, Math.E / 10);
        double exactValue = getExactValueOfSequence(pow);

        printResult(sumOfSequence, sumOfSequenceMoreThanEpsilon, sumOfSequenceMoreThanEpsilonDividedBy10, exactValue);
    }

    private static double getExactValueOfSequence(double pow) {
        return Math.pow(2,pow);
    }

    private static double getSumOfSequence(double pow) {
        double term = 1; double sum = term;

        for(int i = 0; i < pow; i++) {
            term *= Math.log(2)*pow/(i+1);
            sum += term;
        }

        return sum;
    }

    private static double getSumOfSequenceMoreThanEpsilon(double pow, double e) {
        double term = 1; double sum = 0;

        for(int i = 0; i < pow; i++) {
            if(term > e) {
                sum += term;
            }
            term *= Math.log(2)*pow/(i+1);
        }

        return sum;
    }

    private static double readPow() {
        double value = 0;
        Scanner scn = new Scanner(System.in);

        try{
            System.out.print("[SYSTEM] Enter value of Pow - ");
            value = scn.nextInt();
        }
        catch(Exception ex) {
            System.out.println("[SYSTEM] Your entered value contains forbidden symbols. You must enter only integer number. Pow sets in default value (0)");
        }

        return value;
    }

    private static void printResult(double sumOfSequence, double sumOfSequenceMoreThanEpsilon, double sumOfSequenceMoreThanEpsilonDividedBy10, double exactValue) {
        System.out.printf("[SYSTEM] Sum of sequence - %s \n", sumOfSequence);
        System.out.printf("[SYSTEM] Sum of sequence, where every term more than Epsilon - %s \n", sumOfSequenceMoreThanEpsilon);
        System.out.printf("[SYSTEM] Sum of sequence, where every term more than Epsilon / 10 - %s \n", sumOfSequenceMoreThanEpsilonDividedBy10);
        System.out.printf("[SYSTEM] Exact value of sequence - %s \n", exactValue);
    }
}
