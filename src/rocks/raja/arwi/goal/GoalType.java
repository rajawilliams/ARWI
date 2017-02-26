package rocks.raja.arwi.goal;

import rocks.raja.api.misc.IStringSerializable;

public enum GoalType implements IStringSerializable {
	EXPERIMENT("experiment"),
	CREATECREATURES("create_creatures"),
	TAKEOVER("take_over");

	private String name;
	
	GoalType(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public boolean contains(String name) {
		for (GoalType type : values()) {
			if (type.name == name) {
				return true;
			}
		}
		return false;
	}
	
}
