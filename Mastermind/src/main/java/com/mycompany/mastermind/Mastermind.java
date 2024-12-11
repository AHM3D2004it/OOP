package com.mycompany.mastermind;

import java.util.*;

public class Mastermind {

    public static void main(String[] args) {

        List<String> colors = Arrays.asList("R", "P", "G", "Y", "O", "B");
        Collections.shuffle(colors);

        Scanner obj = new Scanner(System.in);
        System.out.println("Mastermind is a classic code-breaking game that challenges players' logical thinking and problem-solving skills. "
                + "\nOne player creates a secret code, while the other tries to guess it using strategy and deduction.");
        System.out.println("Guess the order of the 4 colors"  + " \nshuffled colors (Red, Purple, Green, Yellow, Orange, Black)!");

        int attempts = 0;
        while (attempts < 10) {
            System.out.println("Attempt " + (attempts + 1) + ":");
            System.out.println("Your guess: ");

            List<String> userGuess = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                System.out.print("Color " + (i + 1) + ": ");
                userGuess.add(obj.nextLine().toUpperCase().trim());
            }

            int blackPegs = 0, whitePegs = 0;
            for (int i = 0; i < 4; i++) {
                if (colors.get(i).equals(userGuess.get(i))) {
                    blackPegs++;
                } else if (colors.contains(userGuess.get(i).toUpperCase())) {
                    whitePegs++;
                }
            }

            System.out.println("Black pegs: " + blackPegs + ", White pegs: " + whitePegs);

            if (blackPegs == 4) {
                System.out.println("Congratulations! You cracked the code in " + (attempts+1) + " attempts.");
                break;
            }

            attempts++;
        }

        if (attempts == 10) {
            System.out.println("You ran out of attempts. The correct order was: " + colors);
        }
    }
}