import java.util.Scanner;

public class Main {
    public static void anounceDeveloperTeaTime() {
        System.out.println("Waiting for developer tea time...");
        System.out.println("Type in a random and press Enter to start developer tea time.");
        
        Scanner input = new Scanner(System.in);
        input.next();
        System.out.println("It's developer tea time!");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to your new job");

        anounceDeveloperTeaTime();

        System.out.println("Write code");
        System.out.println("Review code");

        anounceDeveloperTeaTime();

        System.out.println("Get promoted!");
    }
}
