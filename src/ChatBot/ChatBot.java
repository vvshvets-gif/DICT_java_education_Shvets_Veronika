
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
        SendMessage("Let me guess your age.");
        SendMessage("Enter remainders of dividing your age by 3, 5 and 7.");
        var age1 = scanner.nextInt();
        var age2 = scanner.nextInt();
        var age3 = scanner.nextInt();
        var age = CalculateAge(age1, age2, age3);
        SendMessage(String.format("Your age is %d; that's a good time to start programming!", age));
        SendMessage("Now I will prove to you that I can count to any number you want!");
        var length = scanner.nextInt();
        for (int i = 0; i < length; i++) {
            SendMessage(String.format("%d !", i));
        }
        var questions = new Question[]{
                new Question(
                        "Choose correct answer!",
                        new Answer[]{
                                new Answer("Wrong answer.", false),
                                new Answer("Wrong answer.", false),
                                new Answer("Correct answer.", true),
                                new Answer("Wrong answer.", false)
                        }
                )
        };
        for (Question question : questions) {
            SendMessage(question.question);
            for (int i = 0; i < question.answers.length; i++) {
                var answer = question.answers[i];
                var answerIndex = i;
                SendMessage(String.format("%d. %s", ++answerIndex, answer.answer));
            }
            while (true) {
                var index = scanner.nextInt();
                if (index >= 1 && index <= question.answers.length) {
                    var answer = question.answers[index - 1];
                    if (answer.isCorrect) {
                        SendMessage("Correct!");
                        break;
                    } else {
                        SendMessage("Wrong!");
                    }
                }
            }
        }
        SendMessage("Goodbye, have a nice day!");
    }

    private static void SendMessage(String message) {
        System.out.println(message);
    }

    private static int CalculateAge(int age1, int age2, int age3) {
        var remainder3 = age1 % 3;
        var remainder5 = age2 % 5;
        var remainder7 = age3 % 7;
        var age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        return age;
    }

    static class Question {
        public String question;
        public Answer[] answers;

        Question(String question, Answer[] answers) {
            this.question = question;
            this.answers = answers;
        }
    }

    static class Answer {
        public String answer;
        public boolean isCorrect;

        Answer(String answer, boolean isCorrect) {
            this.answer = answer;
            this.isCorrect = isCorrect;
        }
    }
}