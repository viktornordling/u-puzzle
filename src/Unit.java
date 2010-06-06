
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

	public int getSize() {
		return size;
	}

	private boolean directionAllowed(Direction direction) {
		return facing == direction;
	}

	public void add(Unit unit) {
		if (!sizeAllowed(unit)) {
			throw new IllegalArgumentException("Cannot add " + unit + " to " + this);
		}
		if (containedUnit == null) {
			containedUnit = unit;
		} else {
			containedUnit.add(unit);
		}
	}

	public Unit getContainedUnit() {
		return containedUnit;
	}
	
	@Override
	public String toString() {
		return String.format("Direction [%s] Size [%s] Containing [%s]", facing, size, containedUnit);
	}

	public Unit getFollowers(Direction direction) {
		if (direction.opposite() != facing) {
			return this;
		} else if (containedUnit != null) {
			return containedUnit.getFollowers(direction);
		} else {
			return null;
		}
	}

	public void remove(Unit leavingMember) {
		if (containedUnit == leavingMember) {
			containedUnit = null;
		} else if (containedUnit != null) {
			containedUnit.remove(leavingMember);
		}
	}

	public Direction facing() {
		return facing;
	}
}
