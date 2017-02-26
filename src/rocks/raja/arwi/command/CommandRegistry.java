package rocks.raja.arwi.command;

public class CommandRegistry {

	static java.util.List<ICommand> command = new java.util.ArrayList<ICommand>();
	
	public static void register(ICommand command) {
		System.out.println(command.getName());
		CommandRegistry.command.add(command);
	}
	
	public static int indexOf(ICommand command) {
		return CommandRegistry.command.indexOf(command);
	}
	
	public static boolean contains(ICommand command) {
		return CommandRegistry.command.contains(command);
	}
	
	public static ICommand getCommandAtIndex(int index) {
		return command.get(index);
	}
	
	public static int getIndexFromName(String name) {
		for (int i = 0; i < command.size(); i++) {
			if (command.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
}
