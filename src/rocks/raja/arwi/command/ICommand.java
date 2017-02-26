package rocks.raja.arwi.command;

import rocks.raja.api.Debug;
import rocks.raja.arwi.app.ARWI;

public interface ICommand {

	void execute(String[] args, Debug debug, ARWI control);
	
	String getName();
	
	String getUsage();
}
