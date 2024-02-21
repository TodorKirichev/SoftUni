package SoftUni.JavaAdvanced.OOP.PolymorphismLab._2_Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double getPerimeter() {
        return getPerimeter();
    }

    @Override
    public Double getArea() {
        return getArea();
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * radius * radius;
    }
}
