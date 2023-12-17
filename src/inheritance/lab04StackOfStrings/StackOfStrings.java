package inheritance.lab04StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {

    private ArrayList<String> data;
    private int index;

    public StackOfStrings() {
        this.data = new ArrayList<>();
        this.index = 0;
    }

    public void push(String item) {
        this.data.add(item);
        index++;
    }

    public String pop() {
        return this.data.remove(--index);
    }

    public String peek() {
        return this.data.get(this.index -1);
    }

    public boolean isEmpty() {
      return this.data.isEmpty();
    }
}
