package SoftUni.JavaAdvanced.OOP.EncapsulationExercises._1_ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        if (isValid(length,"Length")) {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (isValid(width,"Width")) {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (isValid(height,"Height")) {
            this.height = height;
        }
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }
    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }
    public double calculateVolume() {
        return length * width * height;
    }

    private boolean isValid(double size, String msg) {
        if (size <= 0 ) {
            throw new IllegalArgumentException(String.format("\n%s cannot be zero or negative.\n",msg));
        }
        return true;
    }
}
