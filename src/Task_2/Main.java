package Task_2;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5,"красный","черный");
        System.out.println("Круг:");
        circle.printDetails();

        Shape rectangle = new Rectangle(4, 7,"желтый","черный");
        System.out.println("\nПрямоугольник:");
        rectangle.printDetails();

        Shape triangle = new Triangle(3, 4, 5,"зеленый","черный");
        System.out.println("\nТреугольник:");
        triangle.printDetails();
    }
}
