package SoftUni.JavaAdvanced.OOP.WorkingWithAbstractionExercise._5_JediGalaxy;

public class Evil {
    private int row;
    private int col;

    public Evil(int[] evilData) {
        this.row = evilData[0];
        this.col = evilData[1];
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
