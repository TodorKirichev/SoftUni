
import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public void push(String element) {
        data.add(element);
    }
    public String pop() {
        String element = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        return element;
    }
    public String peek() {
        return data.get(data.size() - 1);
    }
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
