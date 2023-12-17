package reflection.lab02;

import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m -> !m.getName().equals("toString"))
                .sorted(new methodComparator())
                .forEach(e -> {
                    if (e.getName().startsWith("get")) {
                        printGetters(e);
                    } else if (e.getName().startsWith("set")) {
                       printSetters(e);
                    }
                });

    }

    private static void printGetters(Method method) {
        System.out.printf("%s will return class %s%n", method.getName(), method.getReturnType().getSimpleName());

    }

    private static void printSetters(Method method) {
        System.out.printf("%s and will set field of class %s%n",
            method.getName(), method.getParameterTypes()[0].getSimpleName());
    }

    private static class methodComparator implements Comparator<Method> {

        @Override
        public int compare(Method first, Method second) {

            boolean firstIsGetter = first.getName().startsWith("get");
            boolean secondIsGetter = second.getName().startsWith("get");

            if(firstIsGetter && secondIsGetter) {
                return first.getName().compareTo(second.getName());
            }

            boolean firstIsSetter = first.getName().startsWith("set");
            boolean secondIsSetter = second.getName().startsWith("set");

            if (firstIsSetter && secondIsSetter){
                return first.getName().compareTo(second.getName());
            }

            return Boolean.compare(secondIsGetter, firstIsGetter);
        }
    }


}
