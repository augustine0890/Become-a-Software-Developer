import java.util.Scanner;

public class Variables {
    public static void main(String[] args) {
        int studentAge = 15;
        double studentGPA = 3.45;
        String studentFristName = "Augustine";
        String studentLastName = "Nguyen";
        char studentFirstInitial = studentFristName.charAt(0);
        char studentLastInitial = studentLastName.charAt(0);
        boolean hasPerfectAttendance = true;

        System.out.println(studentFristName + " " + 
            studentLastName + " has a GPA of " + studentGPA);
        System.out.println("What do you want to update it to? ");
        
        Scanner input = new Scanner(System.in);
        studentGPA = input.nextDouble();

        System.out.println(studentFristName + " " + 
            studentLastName + " now has a GPA of " + studentGPA);

        System.out.println(studentFristName);
        System.out.println(studentLastName);
        System.out.println(studentAge);
        System.out.println(studentGPA);
        System.out.println(studentFirstInitial);
        System.out.println(studentLastInitial);
        System.out.println(hasPerfectAttendance);
    }
}