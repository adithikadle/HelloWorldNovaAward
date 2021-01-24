package com.nova5;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber5a {

    // setting minimum and maximum numbers
    private static final int MIN=1;
    private static final int MAX=10;

    public static void main(String[] args) {
        /**
         * generate a random whole number between minimum and maximum bounds to be used inside the loop.
         * This the number users are trying to guess.
         */
        int correctNum = ThreadLocalRandom.current().nextInt(MIN,MAX + 1);
        boolean shouldContinue = true;

        // keeps track of number of attempts
        int attempt = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            //asks for user input
            int userInput = -1;
            System.out.println("Guess a number between 1 and 10:");
            attempt = attempt + 1;

            /**
             * This makes sure that if the person enters anything that isn't a whole number (a letter or decimal, etc.)
             * the program asks them to retry.
             */
            try {
                userInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                String invalidUserInput=scanner.next();
                System.out.println("Please enter only whole numbers. Your input, \"" + invalidUserInput + "\" is not valid. Try again!");
                continue;
            }

            if (userInput > MAX || userInput < MIN){
                System.out.println("Your number is above ten or below one. Enter within parameters.");
            } else if (userInput < correctNum) {
                System.out.println("Your number is too low.");
            } else if (userInput > correctNum) {
                System.out.println("Your number is too high.");
            } else if (userInput == correctNum){
                System.out.println("You guessed correct, and took " + attempt + " attempts! ");
                // Once the correct number is guessed, the loop control variable is set to false to exit the loop.
                shouldContinue = false;
            }

        } while (shouldContinue == true);

        // This closes the user input scanner.
        scanner.close();
    }
}