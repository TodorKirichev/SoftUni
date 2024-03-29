package SoftUni.JavaAdvanced.OOP.PolymorphismLab._2_Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public abstract Double getPerimeter();

    public abstract Double getArea();


    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();

}
