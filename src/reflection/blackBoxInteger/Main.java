package reflection.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        Constructor<BlackBoxInt> blackBoxIntConstructor = blackBoxIntClass.getDeclaredConstructor();
        blackBoxIntConstructor.setAccessible(true);

        BlackBoxInt createInstance = blackBoxIntConstructor.newInstance();

        Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] command = input.split("_");
            String commandName = command[0];
            int value = Integer.parseInt(command[1]);

            Method getMethod = blackBoxIntClass.getDeclaredMethod(commandName, int.class);
            getMethod.setAccessible(true);
            getMethod.invoke(createInstance, value);

            System.out.println(innerValue.get(createInstance));

            input = scanner.nextLine();
        }

    }
}
