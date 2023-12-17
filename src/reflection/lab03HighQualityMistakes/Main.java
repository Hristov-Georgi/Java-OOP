package reflection.lab03HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> reflection = Reflection.class;

        Field[] refFields = reflection.getDeclaredFields();

        Arrays.stream(refFields)
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        Method[] refMethods = reflection.getDeclaredMethods();

        Arrays.stream(refMethods)
                .filter(method -> method.getName().startsWith("get"))
                .filter(m -> !Modifier.isPublic(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be public!%n", m.getName()));


        Arrays.stream(refMethods)
                .filter(method -> method.getName().startsWith("set"))
                .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.printf("%s have to be private!%n", m.getName()));
    }


}
