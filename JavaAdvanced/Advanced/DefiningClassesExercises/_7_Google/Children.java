package JavaAdvanced.DefiningClassesExercises._7_Google;

public class Children {
    String childrenName;
    String childrenBirthday;

    public Children(String childrenName, String childrenBirthday) {
        this.childrenName = childrenName;
        this.childrenBirthday = childrenBirthday;
    }

    public String getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(String childrenName) {
        this.childrenName = childrenName;
    }

    public String getChildrenBirthday() {
        return childrenBirthday;
    }

    public void setChildrenBirthday(String childrenBirthday) {
        this.childrenBirthday = childrenBirthday;
    }
    @Override
    public String toString() {
        return String.format("%s %s\n",getChildrenName(),getChildrenBirthday());
    }
}
