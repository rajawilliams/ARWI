package rocks.raja.arwi.goal;

public class Goal {

	private GoalType type;
	
	public Goal(GoalType type) {
		this.type = type;
	}
	
	public boolean isGoal(String name) {
		return type.getName() == name;
	}

	public GoalType getType() {
		return type;
	}

	public void setType(GoalType type) {
		this.type = type;
	}
	
}
