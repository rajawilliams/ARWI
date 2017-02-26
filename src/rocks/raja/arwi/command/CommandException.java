package rocks.raja.arwi.command;

import rocks.raja.api.Debug;

/**
 * 
 * Command exception.
 * 
 * @author admin
 *
 */

public class CommandException {
	
	public CommandException(String reason, Debug debug) {
		debug.Error(reason);
	}

}
