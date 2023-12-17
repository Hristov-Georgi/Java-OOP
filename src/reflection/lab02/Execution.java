package reflection.lab02;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Execution {
    public static void main(String[] args) {

        Class<Reflection> reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s will return class %s%n",
                        method.getName(), method.getReturnType().getSimpleName()));

        Arrays.stream(methods)
                .filter(m -> m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(method -> System.out.printf("%s and will set field of class %s%n",
                        method.getName(), method.getParameterTypes()[0].getSimpleName()));
    }
}
