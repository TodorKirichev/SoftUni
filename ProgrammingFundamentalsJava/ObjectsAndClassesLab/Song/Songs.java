package ObjectsAndClassesLab.Song;

public class Songs {
    String typeList;
    String name;
    String time;

    public String getTypeList() {
        return typeList;
    }

    public String getName() {
        return name;
    }
    public Songs (String typeList,String name,String time) {
        this.typeList = typeList;
        this.name = name;
        this.time = time;
    }
}
