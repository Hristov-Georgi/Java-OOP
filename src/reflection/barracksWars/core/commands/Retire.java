package reflection.barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl;
import reflection.barracksWars.interfaces.Repository;
import reflection.barracksWars.interfaces.UnitFactory;

public class Retire extends Command {

    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitToRemove = getData()[1];
        getRepository().removeUnit(unitToRemove);
        return unitToRemove + " retired!";
    }
}

//If there are no such units currently in the repository print: "No such units in repository."
// If there is such a unit currently in the repository, print: "{UnitType} retired!"
