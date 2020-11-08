import java.text.NumberFormat.Style;

public class Student {
    String firstName;
    String lastName;
    int expectedYearGraduate;
    double GPA;
    String major;

    public Student(String firstName, String lastName,
                    int expectedYearGraduate, double GPA, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.expectedYearGraduate = expectedYearGraduate;
        this.GPA = GPA;
        this.major = major;
    }

    public void incrementExpectedGraduationYear() {
        this.expectedYearGraduate += 1;
        System.out.println("Expected Year Graduate: " + this.expectedYearGraduate);
    }
}
