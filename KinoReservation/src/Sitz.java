import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Sitz extends Button
{

	private Boolean hasReservation;
	private int x;
	private int y;
	private int xLength;
	private int yLength;
	private Graphics2D g;
	private Rectangle2D rect;
	
	public Rectangle2D getRect() {
		return rect;
	}

	public void setRect(Rectangle2D rect) {
		this.rect = rect;
	}

	public Sitz(int x, int y, int xLength, int yLength) 
	{
		super();
		this.x = x;
		this.y = y;
		this.xLength = xLength;
		this.yLength = yLength;
		hasReservation = false;
	}
	
	public void drawSeat(Graphics g)
	{
		rect = new Rectangle(x, y, xLength, yLength);
		this.g = (Graphics2D) g;
		((Graphics2D) g).draw(rect);
		
		if(hasReservation)
		{
			g.setColor(Color.black);
			((Graphics2D) g).fill(rect);
		}
	}
	
	public void repaint()
	{
		drawSeat(this.g);
	}
	
	
	public void reserve()
	{
		hasReservation = !hasReservation;
		repaint();
		System.out.println("filled x: "+x+"filled y: "+y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	
}
