package Hangman;
import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");
        String[] words = {"python", "java", "javascript", "kotlin"};
        String targetWord = words[new Random().nextInt(words.length)];

        System.out.print("Guess the word: > ");
        String guess = scanner.nextLine();

        if (guess.equals(targetWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}