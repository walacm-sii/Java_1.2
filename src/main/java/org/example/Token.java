package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Token {

    private final Scanner scanner;

    private final Integer[] availableLengths = {5, 10, 15};

    private final String characterForToken = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";

    public Token() {
        scanner = new Scanner(System.in);
    }

    public String tokenGenerator() {
        int length = getNumberFromUser();
        StringBuilder token = new StringBuilder();
        for(int i = 0; i < length; i++) {
            token.append(characterForToken.charAt(new Random().nextInt(characterForToken.length())));
        }
        return token.toString();
    }

    private int getNumberFromUser() {
        int number;
        while(true) {

            System.out.printf("How many character token you want: %s?\n", Arrays.toString(availableLengths));
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            number = scanner.nextInt();

            if(Arrays.asList(availableLengths).contains(number)) {
                break;
            } else {
                System.out.println("Wrong number!");
            }
        }
        return number;
    }
}
