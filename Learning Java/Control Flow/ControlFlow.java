import java.text.NumberFormat.Style;
import java.util.Scanner;

public class ControlFlow {
    public static void main(String[] args) {
        System.out.println("Pick a number between 1 and 10");
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();

        if (inputNum < 5) {
            System.out.println("Enjoy the good luck a friend brings you");
        } else {
            System.out.println("Your shoe selection will make make you very happy today");
        }

        boolean isOnRepeat = true;
        while (isOnRepeat) {
            System.out.println("Playing current song");
            System.out.println("Would you like to take this song off of repeat? If so, answer yes");
            String userInput = scanner.next();

            if (userInput.equals("yes")) {
                isOnRepeat = false;
            }
        }
        System.out.println("Playing next song");
    }
}
