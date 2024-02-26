package SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;


import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.DrawingManager;
import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class DrawingManagerImpl implements DrawingManager {
    private Shape shape;


    @Override
    public void draw() {
        shape.draw();
    }
}
