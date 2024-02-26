package SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape;

import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Render;
import SoftUni.JavaAdvanced.OOP.SOLID.solidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {


    private final Render render;

    public DrawingManagerImpl(Render render) {
        this.render = render;
    }


    @Override
    public void draw(Shape shape) {
        render.render(shape);
    }
}
