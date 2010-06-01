
public class Cell {

	public static final Cell WALL = new Cell(true);
	private final boolean wall;
	private Unit member;
	private boolean hasPlayer;

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
		if (member == null) {
			member = unit;
		} else {
			member.add(unit);
		}
	}

	public Unit getMember() {
		return member;
	}

	public Unit getFollowers(Direction direction) {
		if (member == null) return member;
		return member.getFollowers(direction);
	}

	public boolean isWall() {
		return wall;
	}

	public boolean hasPlayer() {
		return hasPlayer;
	}
	
	public void setHasPlayer(boolean hasPlayer) {
		this.hasPlayer = hasPlayer;
	}

	public void remove(Unit leavingMember) {
		if (member == leavingMember) {
			member = null;
		} else if (member != null) {
			member.remove(leavingMember);
		}
	}
}
