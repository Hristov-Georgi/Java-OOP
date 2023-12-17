package reflection.barracksWars.core.commands;

import reflection.barracksWars.interfaces.Repository;
import reflection.barracksWars.interfaces.UnitFactory;

public class Report extends Command {

    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = getRepository().getStatistics();
        return output;
    }
}
