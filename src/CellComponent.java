import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
		Graphics2D g2d = (Graphics2D) g.create();
		double step = Math.PI / 2;
		int steps = getSteps(member.facing());

		if (member.getSize() == 1) {
			g2d.scale(0.7, 0.7);
			g2d.translate(7, 10);
		}		
		
		if (steps > 0) {
			g2d.translate(getWidth() / 2, getHeight() / 2);
			g2d.rotate(step * steps);
			g2d.translate(-(getWidth() / 2), -(getHeight() / 2));
		}
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(1, 1, 4, getHeight() - 2);
		g2d.fillRect(getWidth() - 5, 1, 4, getHeight() - 2);
		g2d.fillRect(1, getHeight() - 5, getWidth() - 2, 4);
		
		g2d.dispose();
		if (member.getContainedUnit() != null) {
			paintMembers(member.getContainedUnit(), g);
		}
	}

	private int getSteps(Direction facing) {
		switch (facing) {
		case EAST:
			return 1;
		case SOUTH:
			return 2;
		case WEST:
			return 3;
		}
		return 0;
	}
}
