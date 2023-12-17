package reflection.barracksWars.core.factories;

import reflection.barracksWars.interfaces.Unit;
import reflection.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"reflection.barracksWars.models.units.";


	@Override
	public Unit createUnit(String unitType) {

		try {
			Class unitClazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<Unit> constructor = unitClazz.getDeclaredConstructor();
			return constructor.newInstance();

 		} catch (ClassNotFoundException | NoSuchMethodException
				| InvocationTargetException | InstantiationException
				| IllegalAccessException e) {

			e.printStackTrace();
			return null;
		}


	}
}
