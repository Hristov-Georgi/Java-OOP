package reflection.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;

		Field[] fields = richSoilLandClass.getDeclaredFields();

		String commands = scanner.nextLine();

		while (!commands.equals("HARVEST")) {

			switch (commands) {

				case "private":
					Arrays.stream(fields)
							.filter(f -> Modifier.isPrivate(f.getModifiers()))
							.forEach(Main::printClassFields);

					break;

				case "protected":

					Arrays.stream(fields)
							.filter(f -> Modifier.isProtected(f.getModifiers()))
							.forEach(Main::printClassFields);
					break;

				case "public":
					Field[] publicFields = richSoilLandClass.getFields();

					for (Field f : publicFields) {
						printClassFields(f);
					}
					break;

				case "all":
					for (Field field : fields) {
						printClassFields(field);
					}
					break;
			}

			commands = scanner.nextLine();
		}

	}

	private static void printClassFields(Field field) {

		System.out.printf("%s %s %s%n",
				Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());


	}
}
