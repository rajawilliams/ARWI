package rocks.raja.arwi.command;

import rocks.raja.api.Debug;
import rocks.raja.arwi.Creature;
import rocks.raja.arwi.app.ARWI;

public class EditCreatureCommand implements ICommand {

	@Override
	public void execute(String[] args, Debug debug, ARWI control) {
		if (args.length == 0) {
			new CommandException(getUsage(), debug);
			return;
		}
		Creature creature = control.creature.get(args[0]);
		if (creature != null && args[1] != null) {
			creature.classes.get(args[1]).values.put(args[2], Boolean.parseBoolean(args[3]));
		} else {
			new CommandException(getUsage(), debug);
		}
	}

	@Override
	public String getName() {
		return "edit_creature";
	}

	@Override
	public String getUsage() {
		return "edit_creature <creature> <class_name> <name> <value>";
	}

}
