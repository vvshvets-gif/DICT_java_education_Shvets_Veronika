
package ChatBot;

import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        SendMessage("Hello! My name is PR_4_bot.");
        SendMessage("I was created in 2025.");
        SendMessage("Please, remind me your name.");
        var scanner = new Scanner(System.in);
        var name = scanner.nextLine();
        SendMessage(String.format("What a great name you have, %s!", name));
    }

    private static void SendMessage(String message) {
        System.out.println(message);
    }
}