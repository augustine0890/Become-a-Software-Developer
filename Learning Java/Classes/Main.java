public class Main {
    public static void main(String[] args) {
        Triangle triangleA = new Triangle(14, 8, 15, 8, 17);
        Triangle triangleB = new Triangle(3, 2.5, 3.5, 2.5, 3);

        double triangleAArea = triangleA.findArea();
        System.out.println("The area of triangle A: " + triangleAArea);
        System.out.println("The base of triangle A: " + triangleA.base);

        double triangleBArea = triangleB.findArea();
        System.out.println("The area of triangle B: " + triangleBArea);
        System.out.println("Number of sides: " + triangleB.numOfSides);

    }
}
