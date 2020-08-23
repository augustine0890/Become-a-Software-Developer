import java.util.ArrayList;

public class LearnJava {
    public static void main(final String[] args) {
        final int a = 5;
        final char b = 'i';
        final long c = 500;
        final double d = 4.5;

        final String name = "Augustine";
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());

        final String exclaim = addExclamationPoint("Amazing");
        System.out.println(exclaim);

        final Student v = new Student();
        final String student = v.isStudent();
        System.out.println(student);

        v.Grading();
        
        final ArrayList arr = new ArrayList<>();
    }

    public static String addExclamationPoint(final String s) {
        return s + "!";
    }
}