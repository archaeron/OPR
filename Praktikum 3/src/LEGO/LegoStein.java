package LEGO;

import java.awt.Color;
import java.awt.Graphics;

public class LegoStein
{
	public int length;
	private int x;
	private int y;
	private Graphics g;
	private Color c;
	
	public static final int width = 10;
	
	public LegoStein(int length)
	{
		this.length = length;
		switch(length)
		{
			case 1:
				c = Color.yellow;
				break;
			case 2:
				c = Color.blue;
				break;
			case 3:
				c = Color.red;
				break;
			case 4:
				c = Color.green;
				break;
			case 5:
				c = Color.cyan;
				break;
			case 6:
				c = Color.magenta;
				break;
		}
	}
	
	public LegoStein(int length, int x, int y)
	{
		this(length);
		place(x, y);
		
	}
	
	public void place(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getWidth()
	{
		return width*length;
	}
	
	public void paint(Graphics g)
	{
		this.g = g;
		g.setColor(c);
		g.fillRect(x, y, getWidth(), width);
		g.setColor(Color.black);
		g.drawRect(x, y, getWidth(), width);
	}
	
	public void repaint()
	{
		paint(g);
	}
}
