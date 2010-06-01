import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;


public class CellComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	
	private final Cell cell;
	private Dimension playerDimensions = new Dimension(10, 10);
	
	public CellComponent(Cell cell) {
		this.cell = cell;
		setPreferredSize(new Dimension(50, 50));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (cell.isWall()) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.GREEN);
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (cell.hasPlayer()) {
			g.setColor(Color.BLUE);
			g.fillRect(getWidth()/2 - (int) (playerDimensions.getWidth() / 2), 
					   getHeight()/2 - (int) (playerDimensions.getHeight() / 2), 
					   playerDimensions.width, 
					   playerDimensions.height);
		}
		if (cell.getMember() != null) {
			paintMembers(cell.getMember(), g);
		}
	}

	private void paintMembers(Unit member, Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 5, getHeight());
		g.fillRect(getWidth() - 5, 0, 5, getHeight());
		g.fillRect(0, getHeight() - 5, getWidth(), 5);
	}
}
