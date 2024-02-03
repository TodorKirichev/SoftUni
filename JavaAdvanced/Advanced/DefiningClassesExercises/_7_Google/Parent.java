package JavaAdvanced.DefiningClassesExercises._7_Google;

import javax.swing.plaf.PanelUI;

public class Parent {
    String parentName;
    String parentBirthday;

    public Parent(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentBirthday() {
        return parentBirthday;
    }

    public void setParentBirthday(String parentBirthday) {
        this.parentBirthday = parentBirthday;
    }
    @Override
    public String toString() {
        return String.format("%s %s\n",getParentName(),getParentBirthday());
    }
}
