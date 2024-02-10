package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise._5_JediGalaxy;

public class Jedi {
    private int row;
    private int col;

    public Jedi(int[] jediData) {
        this.row = jediData[0];
        this.col = jediData[1];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
