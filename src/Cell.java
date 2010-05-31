
public class Cell {

	public static final Cell WALL = new Cell(true);
	private final boolean wall;
	private Unit member;

	public Cell(boolean wall) {
		this.wall = wall;
	}

	public boolean allows(Direction direction, Unit newMember) {
		if (wall) {
			return false;
		}
		if (member == null) return true;
		return member.accepts(newMember, direction);
	}

	public boolean allows(Direction direction) {
		return allows(direction, null);
	}	

	public void add(Unit unit) {
		if (unit == null) return;
		this.member = unit;
	}

	public Unit getMember() {
		return member;
	}

	
}
