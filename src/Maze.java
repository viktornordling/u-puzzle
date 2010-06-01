import java.awt.Point;


public class Maze {

	private final Cell[][] cells;
	
	private Point playerPosition;
	
	public Maze(int rows, int columns) {
		 cells = new Cell[rows][columns];

		 initAllCellsAsNeutral(rows, columns);
		 initWalls(rows, columns);
		 setPlayerPosition(1, 1);
	}
	
	private void setPlayerPosition(Point point) {
		setPlayerPosition(point.x, point.y);
	}	

	private void setPlayerPosition(int x, int y) {
		if (playerPosition != null) {
			getCell(playerPosition).setHasPlayer(false);
		}
		playerPosition = new Point(x, y);		
		getCell(playerPosition).setHasPlayer(true);
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
	
	private void moveTo(Point destinationPoint, Direction fromDirection) {
		Cell destinationCell = getCell(destinationPoint);
		if (!destinationCell.allows(fromDirection)) return;
		Unit member = getCell(playerPosition).getFollowers(fromDirection);
		destinationCell.add(member);
		getCell(playerPosition).remove(member);
		setPlayerPosition(destinationPoint);
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

	public Unit getMember(int x, int y) {
		return getMember(new Point(x, y));
	}

	public Cell getCell(int row, int column) {
		return cells[row][column];
	}

}
