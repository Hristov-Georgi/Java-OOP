package reflection.barracksWars.core;



import reflection.barracksWars.core.commands.Command;
import reflection.barracksWars.interfaces.Repository;
import reflection.barracksWars.interfaces.UnitFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Engine implements Runnable {
	private static final String DEFAULT_COMMANDS_PATH = "reflection.barracksWars.core.commands.";

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) {
		String result = "";

		try {

			String commandClassName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);

			Class clazz = Class.forName(DEFAULT_COMMANDS_PATH + commandClassName);

			Constructor<Command> constructor = clazz.getDeclaredConstructor(String[].class,
					Repository.class, UnitFactory.class);

			Command createInstance = constructor.newInstance(data, this.repository, this.unitFactory);

			Method method = clazz.getDeclaredMethod("execute");

			try {
				result = (String) method.invoke(createInstance);
			} catch (InvocationTargetException ex) {
				System.out.print(ex.getCause().getMessage());

			}

		} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex){

			ex.printStackTrace();
		}

		return result;

	}

}
