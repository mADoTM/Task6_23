package ru.vsu.cs.dolzhenkoms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double pow = readPow();
        double result = getTwoInPow(pow);

        printResult(result);
    }

    private static double getTwoInPow(double pow) {
        double mult = Math.log(2)*pow; double result = 1;

        for(int i = 0; i < pow; i++) {
            result += mult;
            mult *= Math.log(2)*pow/(i + 2);
        }

        return result;
    }

    private static double readPow() {
        double value = 0;
        Scanner scn = new Scanner(System.in);

        try{
            System.out.print("[SYSTEM] Enter value of Pow - ");
            value = scn.nextInt();
        }
        catch(Exception ex) {
            System.out.println("[SYSTEM] Entered wrong data. Pow sets in default value (0)");
        }

        return value;
    }

    private static void printResult(double result) {
        System.out.printf("[SYSTEM] The approximate result is - %s", result);
    }
}
