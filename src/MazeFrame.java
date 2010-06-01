import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class MazeFrame extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Maze maze;

	public MazeFrame() {
		setSize(500, 500);
		initMaze();		
		setVisible(true);
		addKeyListener(this);
		pack();
	}

	private void initMaze() {
		int rows = 4;
		int columns = 5;		
		maze = new Maze(rows, columns);
		maze.add(new Unit(Direction.NORTH, 0), new Point(1, 2));
		setLayout(new GridLayout(rows, columns));
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				add(new CellComponent(maze.getCell(i, j)));
			}
		}
	}
	
	public static void main(String[] args) {
		new MazeFrame();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			maze.moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			maze.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			maze.moveDown();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			maze.moveUp();
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
}
