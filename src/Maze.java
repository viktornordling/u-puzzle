import java.awt.Point;


public class Maze {

	private final Cell[][] cells;
	
	private Point playerPosition = new Point(1, 1);
	
	public Maze(int rows, int columns) {
		 cells = new Cell[rows][columns];

		 initAllCellsAsNeutral(rows, columns);
		 initWalls(rows, columns);
	}

	private void initWalls(int rows, int columns) {
		for (int i = 0; i < columns; i++) {
			 cells[0][i] = Cell.WALL;
			 cells[rows - 1][i] = Cell.WALL;
		 }
		 for (int i = 0; i < rows; i++) {
			 cells[i][0] = Cell.WALL;
			 cells[i][columns  -1 ] = Cell.WALL;
		 }
	}

	private void initAllCellsAsNeutral(int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			 for (int j = 0; j < columns; j++) {
				 cells[i][j] = new Cell(false);
			 }
		 }
	}

	public Point getPlayerPosition() {
		return new Point(playerPosition);
	}

	public void moveUp() {
		moveTo(new Point(playerPosition.x, playerPosition.y - 1), Direction.SOUTH);
 	}

	public void moveDown() {
		moveTo(new Point(playerPosition.x, playerPosition.y + 1), Direction.NORTH);		
	}

	public void moveLeft() {
		moveTo(new Point(playerPosition.x - 1 , playerPosition.y), Direction.EAST);
	}

	public void moveRight() {
		moveTo(new Point(playerPosition.x + 1, playerPosition.y), Direction.WEST);		
	}
	
	private void moveTo(Point destinationPoint, Direction direction) {
		Cell destinationCell = getCell(destinationPoint);
		if (!destinationCell.allows(direction)) return;
		Unit member = getCell(playerPosition).getMember();
		destinationCell.add(member);
		
		playerPosition = destinationPoint;
	}

	public void add(Unit unit, Point point) {
		getCell(point).add(unit);
	}

	private Cell getCell(Point point) {
		return cells[point.y][point.x];
	}

	public Unit getMember(Point point) {
		return getCell(point).getMember();
	}

}
