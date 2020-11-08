public class SalaryCalculator {
    public static double calculateYearlySalary(double hoursPerWeek, double amountPerHour, int vacations) {
        if (hoursPerWeek < 0) {
            System.out.println("Invalid hours number.");
            return -1;
        }

        if (amountPerHour < 0) {
            System.out.println("Invalid amount number.");
            return -1;
        }

        double yearlySalary = (hoursPerWeek * amountPerHour * 52) - (vacations * 8 * amountPerHour);
        return yearlySalary;
    }
    public static void main(String[] args) {
        double salary = calculateYearlySalary(40, 110_000, 0);
        System.out.println(salary);
    }
}
