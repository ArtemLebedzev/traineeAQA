package Task_2;

interface Shape {
    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();
    void setFillColor(String color);
    void setBorderColor(String color);

    default double validateDimension(double dimension){ //double нужен в целом только для круга, но мы люди ленивые)
        if (dimension <= 0) {
            throw new IllegalArgumentException("Величина должна быть больше нуля");
        }
        return dimension;
    }

    default void printDetails() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границ: " + getBorderColor());
    }
}

