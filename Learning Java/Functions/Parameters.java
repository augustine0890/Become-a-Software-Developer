public class Parameters {
    public static double calculateTotalMealPrice(double listedMealPrice, double tipRate, double taxRate) {
        double tip = tipRate * listedMealPrice;
        double tax = taxRate * listedMealPrice;
        double result = listedMealPrice + tip + tax;
        // System.out.println("Your total meal price is " + result);
        return result;

    }
    public static void main(String[] args) {
        double group1 = calculateTotalMealPrice(15, .2, 0.8);
        double group2 = calculateTotalMealPrice(17, .18, 0.8);
        double group3 = calculateTotalMealPrice(45, .15, 0.8);
        System.out.println("Your total meal price is $" + group3);

        double individualMealPrice = group3 / 5;
        System.out.println("Each person: $" + individualMealPrice);
    }
    
}
