package rocks.raja.arwi.command;

import rocks.raja.api.Debug;
import rocks.raja.arwi.Creature;
import rocks.raja.arwi.app.ARWI;

public class CreateCreatureCommand implements ICommand {

	@Override
	public void execute(String[] args, Debug debug, ARWI control) {
		if (args.length == 0) {
			new CommandException(getUsage(), debug);
			return;
		}
		control.creature.put(args[0], new Creature(debug).init(control));
	}

	@Override
	public String getName() {
		return "create_creature";
	}

	@Override
	public String getUsage() {
		return "create_creature <name>";
	}

}
