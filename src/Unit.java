
public class Unit {

	private final Direction facing;
	private final int size;
	private Unit containedUnit;

	public Unit(Direction facing, int size) {
		this.facing = facing;
		this.size = size;
	}

	public boolean accepts(Unit newMember, Direction direction) {
		if (!containedUnitAcceptsNewUnit(newMember, direction)) return false;
		if (!directionAllowed(direction)) return false;
		if (!sizeAllowed(newMember)) return false;
		return true;
	}

	private boolean containedUnitAcceptsNewUnit(Unit newMember, Direction direction) {
		if (containedUnit == null) return true;
		return containedUnit.accepts(newMember, direction);
	}

	private boolean sizeAllowed(Unit newMember) {
		if (newMember == null) return true;
		return newMember.getSize() > getSize();
	}

	private int getSize() {
		return size;
	}

	private boolean directionAllowed(Direction direction) {
		return facing == direction;
	}

	public void add(Unit small) {
		containedUnit = small;
	}

}
