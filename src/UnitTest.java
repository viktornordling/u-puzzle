import junit.framework.TestCase;


public class UnitTest extends TestCase {

	public void testNormalUnitWithSmallUnitAcceptsMiniUnit() {
		Unit normal = new Unit(Direction.NORTH, 0);
		Unit small = new Unit(Direction.NORTH, 1);
		Unit mini = new Unit(Direction.NORTH, 2);
		
		normal.add(small);
		assertFalse(normal.accepts(small, Direction.NORTH));
		assertTrue(normal.accepts(mini, Direction.NORTH));
	}
}
