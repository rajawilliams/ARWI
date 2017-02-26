package rocks.raja.arwi.command;

import rocks.raja.api.Debug;
import rocks.raja.arwi.app.ARWI;

public class TestCommand implements ICommand {

	public void execute(String[] args, Debug debug, ARWI control) {
		if (args.length == 0) {
			new CommandException(getUsage(), debug);
			return;
		}
		debug.Log(args[0], "STDOUT");
	}
	
	public String getName() {
		return "test";
	}

	@Override
	public String getUsage() {
		return "test <string>";
	}
}
