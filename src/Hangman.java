package Hangman;

import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");

        // Етап 8: Головне меню
        while (true) {
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: > ");
            String action = scanner.nextLine().trim();

            if (action.equals("play")) {
                runGame(scanner);
            } else if (action.equals("exit")) {
                break;
            }
        }
    }

    public static void runGame(Scanner scanner) {
        // Етап 3: Список слів та випадковий вибір
        String[] words = {"python", "java", "javascript", "kotlin"};
        String targetWord = words[new Random().nextInt(words.length)];

        // Етап 5: Стан слова (що бачить гравець)
        StringBuilder hiddenWord = new StringBuilder("-".repeat(targetWord.length()));
        int lives = 8; // Етап 6: 8 спроб на помилки
        Set<Character> usedLetters = new HashSet<>();

        while (lives > 0) {
            System.out.println("\n" + hiddenWord);
            System.out.print("Input a letter: > ");
            String input = scanner.nextLine();

            // Етап 7: Валідація вводу
            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char letter = input.charAt(0);

            if (!(letter >= 'a' && letter <= 'z')) {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (usedLetters.contains(letter)) {
                System.out.println("You've already guessed this letter");
                continue;
            }

            usedLetters.add(letter);

            // Перевірка, чи є буква у слові
            if (targetWord.indexOf(letter) >= 0) {
                for (int i = 0; i < targetWord.length(); i++) {
                    if (targetWord.charAt(i) == letter) {
                        hiddenWord.setCharAt(i, letter);
                    }
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                lives--; // Зменшуємо життя тільки при помилці
            }

            // Перевірка на перемогу
            if (hiddenWord.toString().equals(targetWord)) {
                System.out.println(hiddenWord);
                System.out.println("You guessed the word " + targetWord + "!");
                System.out.println("You survived!");
                return;
            }
        }

        if (lives == 0) {
            System.out.println("You lost!");
        }
    }
}
