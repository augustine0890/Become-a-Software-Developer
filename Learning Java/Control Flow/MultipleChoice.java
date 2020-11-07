import java.text.NumberFormat.Style;
import java.util.Scanner;

public class MultipleChoice {
    public static void main(String[] args) {
        String question = "What is the largest planet in our solar system?";
        String choiceOne = "Earth";
        String choiceTwo = "Saturn";
        String choiceThree = "Jupiter";

        String correctAnswer = choiceThree.toLowerCase();

        System.out.println(question);
        System.out.println("Choose one of following answer choices: " + choiceOne + ", " + choiceTwo + ", or " + choiceThree);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userAnswer = scanner.next();
            if (userAnswer.toLowerCase().equals(correctAnswer)) {
                System.out.println("Congrats! Your answer is correct.");
                break;
            }
            System.out.println("You are incorrect! Let's try again.");
        }
    }
}
