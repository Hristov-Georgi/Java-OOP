package inheritance.lab03RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList<T> extends ArrayList<T> {

    public T  getRandomElement() {
        int end = super.size();
        Random rnd = new Random();
        int index = rnd.nextInt(end);

        return remove(index);
    }
}
