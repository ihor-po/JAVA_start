package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final short ATTEMPS = 3;
        final int COMPUTER_NUMBER = getRandomIntNumberFromRange(0, 10);
        int userAttempts = 0;
        int userNumber;
        boolean userIsWin = false;


        showMessage("I have new number. You can try to guess it. You have " + ATTEMPS + "attemps!");

        while (userAttempts < ATTEMPS) {
            userNumber = getUserNuber();
            if (userNumber >= 0) {
                userIsWin = verifyNumbers(userNumber, COMPUTER_NUMBER);
                userAttempts++;
                if (userIsWin) {
                    break;
                }
            }
        }

        if (userIsWin) {
            showMessage("You won!");
        } else {
            showMessage("You loss!");
        }
    }

    /**
     * Show message in console
     *
     * @param message - message for showing
     */
    private static void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Get random integer number from range
     *
     * @param min - the number from
     * @param max - the number to
     * @return integer number
     */
    private static int getRandomIntNumberFromRange(int min, int max) {
        Random random = new Random();

        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Get user number from console
     *
     * @return integer
     */
    private static int getUserNuber() {
        int userNumber = -1;

        showMessage("Your number is....");

        Scanner in = new Scanner(System.in);

        if (in.hasNextInt()) {
            userNumber = in.nextInt();
        } else {
            showMessage("You don't entered number please try again");
        }

        return userNumber;
    }

    /**
     * Verify numbers
     *
     * @param userNumber - user number from console
     * @param computerNumber - computer number
     * @return boolean
     */
    private static boolean verifyNumbers(int userNumber, int computerNumber) {
        boolean result = userNumber == computerNumber;
        if (!result) {
            if (userNumber > computerNumber) {
                showMessage("Your number more than mine");
            } else {
                showMessage("Your number less than mine");
            }
        }
        return result;
    }
}
