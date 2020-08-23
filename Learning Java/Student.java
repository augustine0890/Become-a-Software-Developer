public class Student {
    public static String isStudent() {
        return "I'm a student.";
    }
    
    public static void Grading() {
        int grade = 85;

        if (grade > 80) {
            System.out.println("Good");
        }

        for(int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        
        while(grade < 90) {
            System.out.println("Go ahead!");
            grade++;
        }

        try {
            int d = grade / 0;
            System.out.println(d);
        } catch(Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}