package rocks.raja.arwi.command;

import rocks.raja.api.Debug;
import rocks.raja.arwi.app.ARWI;

public class StopCommand implements ICommand {

	@Override
	public void execute(String[] args, Debug debug, ARWI control) {
		control.stop();
	}

	@Override
	public String getName() {
		return "stop";
	}

	@Override
	public String getUsage() {
		return "stop";
	}

}
