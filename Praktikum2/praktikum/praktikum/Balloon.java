package praktikum;

import java.awt.Color;
import java.awt.Graphics;

public class Balloon
{
	private int x;
	private int y;
	private Color mainColor;
	private Color ropeColor = new Color(184, 134, 11);
	private Color basketColor = new Color(160, 82, 45);
	private int size = 200;
	private int step = 5;
	
	public Balloon(int x, int y, Color c)
	{
		this.x = x;
		this.y = y;
		mainColor = c;
	}
	
	public void paint(Graphics g)
	{
		g.setColor(ropeColor);
		g.drawLine(x, y + size / 6 * 3, x + size / 3, y + size / 3 * 4);
		g.drawLine(x + size, y + size / 6 * 3, x + size / 3 * 2, y + size / 3 * 4);
		g.setColor(basketColor);
		g.fillRect(x + size / 3, y + size / 3 * 4, size / 3, size / 3);
		g.setColor(mainColor);
		g.fillOval(x, y, size, size);
	}
	
	public void up()
	{
		y = y - step;
	}
	
	public void down()
	{
		y = y + step;
	}
	
	public void right()
	{
		x = x + step;
	}
	
	public void left()
	{
		x = x - step;
	}
	
}
