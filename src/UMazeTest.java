import java.awt.Point;

import junit.framework.TestCase;


public class UMazeTest extends TestCase {
	
	public void testMovingIntoWallDoesNothing() {
		Maze maze = new Maze(4, 5);
		assertEquals(new Point(1, 1), maze.getPlayerPosition());
		maze.moveUp();
		assertEquals(new Point(1, 1), maze.getPlayerPosition());
		maze.moveLeft();
		assertEquals(new Point(1, 1), maze.getPlayerPosition());
		maze.moveDown();
		assertEquals(new Point(1, 2), maze.getPlayerPosition());
		maze.moveDown();
		assertEquals(new Point(1, 2), maze.getPlayerPosition());
		maze.moveRight();
		assertEquals(new Point(2, 2), maze.getPlayerPosition());		
		maze.moveRight();
		assertEquals(new Point(3, 2), maze.getPlayerPosition());		
		maze.moveRight();
		assertEquals(new Point(3, 2), maze.getPlayerPosition());				
	}
	
	public void testMoving() {
		Maze maze = new Maze(4, 5);
		assertEquals(new Point(1, 1), maze.getPlayerPosition());
		maze.moveDown();
		assertEquals(new Point(1, 2), maze.getPlayerPosition());
		maze.moveRight();
		assertEquals(new Point(2, 2), maze.getPlayerPosition());
		maze.moveUp();
		assertEquals(new Point(2, 1), maze.getPlayerPosition());
		maze.moveLeft();
		assertEquals(new Point(1, 1), maze.getPlayerPosition());		
	}
	
	public void testMoveUnit() {
		Maze maze = new Maze(4, 5);
		Unit unit = new Unit(Direction.NORTH, 0);
		maze.add(unit, new Point(1, 2));
		assertEquals(unit, maze.getMember(new Point(1, 2)));
		maze.moveDown();
		assertEquals(unit, maze.getMember(new Point(1, 2)));
		maze.moveRight();
		assertEquals(unit, maze.getMember(new Point(2, 2)));
	}
	
	public void testMoveSmallUnitIntoNormalUnit() {
		Maze maze = new Maze(4, 5);
		Unit normal = new Unit(Direction.NORTH, 0);
		Unit small = new Unit(Direction.NORTH, 1);
		maze.add(small, new Point(1, 1));
		maze.add(normal, new Point(1, 2));
		maze.moveDown();
		assertEquals(normal, maze.getMember(new Point(1, 2)));
	}	

}
