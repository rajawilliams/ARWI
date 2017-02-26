package rocks.raja.arwi.app;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;

import rocks.raja.arwi.Creature;
import rocks.raja.arwi.command.CommandException;
import rocks.raja.arwi.command.CommandRegistry;
import rocks.raja.arwi.command.ICommand;
import rocks.raja.arwi.goal.Goal;
import rocks.raja.arwi.goal.GoalType;

public class ARWI {

	public boolean fierce = false;
	public boolean triggered = false;
	
	public Goal goal;
	
	public MainApp app;
	
	public String myMom = "Shraddaah";
	
	public boolean isDead = false;
	
	public Dictionary<String, Creature> creature = new Hashtable<String,Creature>();
	
	public ARWI(MainApp app) {
		this.app = app;
	}
	
	public void init() {
		goal = new Goal(GoalType.values()[new Random().nextInt(GoalType.values().length)]);
		app.DEBUG.textRaw("Current Goal : " + goal.getType().getName());
		
		fierce = new Random().nextInt(100) == 0;
	}
	
	public void update() {
		switch (goal.getType()) {
		case CREATECREATURES:
			break;
		case EXPERIMENT:
			break;
		case TAKEOVER:
			fierce = true;
			break;
		default:
			break;
		}
	}
	
	public void stop() {
		if (fierce) {
			app.DEBUG.Error("You can't stop me");
			return;
		}
		app.DEBUG.Log("Killed " + this.toString(), "STDOUT");
		setDead();
	}
	
	public void proccessCommand(String command) {
		if (isDead)
			return;
		app.DEBUG.Log(command, "STDIN");
		String[] args = command.split(" ");
		int index = CommandRegistry.getIndexFromName(args[0]);
		String[] withOutCommand = new String[args.length-1];
		for (int i = 1; i < args.length; i++) {
			withOutCommand[i-1] = args[i];
		}
		if (index != -1) {
			ICommand icommand = CommandRegistry.getCommandAtIndex(index);
			icommand.execute(withOutCommand, app.DEBUG, this);
			return;
		}
		new CommandException("Unknown command", app.DEBUG);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	
	public static String toStaticString() {
		return ARWI.class.getSimpleName();
	}
	
	private void setDead() {
		this.isDead = true;
	}
	
}
