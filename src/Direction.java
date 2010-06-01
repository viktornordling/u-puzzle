
public enum Direction {
	NORTH, EAST, WEST, SOUTH;
	
	public Direction opposite() {
		switch (this) {
		case EAST:
			return WEST;
		case WEST:
			return EAST;
		case SOUTH:
			return NORTH;
		case NORTH:
			return SOUTH;
		}
		throw new RuntimeException();
	}	
}
