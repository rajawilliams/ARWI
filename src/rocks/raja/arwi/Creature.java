package rocks.raja.arwi;

import java.util.Hashtable;

import rocks.raja.api.Debug;
import rocks.raja.api.Instructions;
import rocks.raja.arwi.app.ARWI;

public class Creature {

	Debug console;
	
	public Hashtable<String, Instructions> classes = new Hashtable<String, Instructions>();
	
	public Creature(Debug debug) {
		this.console = debug;
	}
	
	
	public Creature init(ARWI arwi) {
		console.Log("Creating new Instructions", "STDOUT");
		classes.put("ARWI", new Instructions(ARWI.class, arwi));
		console.Log("Created copy of " + ARWI.toStaticString(), "STDOUT");
		return this;
	}
	
	
	public void set(String key, Instructions value) {
		classes.put(key, value);
	}
}
