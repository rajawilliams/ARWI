package rocks.raja.arwi.command;

import rocks.raja.api.Debug;
import rocks.raja.arwi.app.ARWI;

public class MergeCreatureCommand implements ICommand {

	@Override
	public void execute(String[] args, Debug debug, ARWI control) {
		if (args.length <= 1) {
			new CommandException(getUsage(), debug);
		}
		
	}

	@Override
	public String getName() {
		return "merge_creature";
	}

	@Override
	public String getUsage() {
		return "merge_creature <creature> <class_name>";
	}

}
