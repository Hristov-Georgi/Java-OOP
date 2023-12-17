package anotations.lab05CodingTracker;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Class<Tracker> clazz = Tracker.class;

        List<Author> methods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> m.getAnnotation(Author.class) != null)
                .map(e -> e.getAnnotation(Author.class))
                .collect(Collectors.toList());

        for (Author a : methods) {

            System.out.println(a.name());

        }

    }
}
