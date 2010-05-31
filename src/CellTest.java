import junit.framework.TestCase;


public class CellTest extends TestCase {

	public void testNorthFacingUnitAllowsFromNorth() {
		Cell c = new Cell(false);
		c.add(new Unit(Direction.NORTH, 0));
		assertTrue(c.allows(Direction.NORTH));
		assertFalse(c.allows(Direction.SOUTH));
		assertFalse(c.allows(Direction.EAST));
		assertFalse(c.allows(Direction.WEST));
	}
	
	public void testSmallUnitAllowedInBigUnit() {
		Cell c = new Cell(false);
		c.add(new Unit(Direction.NORTH, 0));
		assertTrue(c.allows(Direction.NORTH, new Unit(Direction.NORTH, 1)));		
	}
	
	public void testSameSizeUnitNotAllowed() {
		Cell c = new Cell(false);
		c.add(new Unit(Direction.NORTH, 0));
		assertFalse(c.allows(Direction.NORTH, new Unit(Direction.NORTH, 0)));		
	}	
}
