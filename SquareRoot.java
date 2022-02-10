import java.util.InputMismatchException;
import java.util.Scanner;
/*

Title: SquareRoot

Abstract: Approximates a square root of a whole number

Author: Reece Whitelaw

Date: 9/10/2021

 */
public class SquareRoot {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        float guessnum = 0;
        float initialguess;
        float secondguess;
        int counter = 1;
        boolean done = false;
        System.out.println("This program estimates square roots.");
        System.out.println("Please enter a whole number: ");
        while (!done) {
            try {
                guessnum = in.nextInt();
                done = true;
            } catch (InputMismatchException e) {
                in.nextLine();
                System.out.println("Please enter a whole number (no words, just numbers): ");
            }
        }
            initialguess = guessnum;
            secondguess = initialguess + 1;
            if (done = true) {
                System.out.println("Initial guess: " + initialguess);
                while (((secondguess - initialguess) / secondguess) > 0.01) {
                    System.out.println("Guess " + counter + ": " + ((initialguess + (guessnum / initialguess)) / 2));
                    secondguess = initialguess;
                    initialguess = ((initialguess + (guessnum / initialguess)) / 2);
                }
                System.out.print("\nThe estimated square root of " + (int)guessnum + " is " + (double)Math.round(initialguess * 100d) / 100d);
            }

    }
}