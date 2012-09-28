package praktikum;

import java.awt.Graphics;

public class BombsCounter
{
	private int points = 30;
	private static final int pointsBombRatio = 15;
	private int x;
	private int y;
	
	public BombsCounter(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getPoints()
	{
		return points % pointsBombRatio;
	}
	
	public int getBombs()
	{
		return points / pointsBombRatio;
	}
	
	public void paint(Graphics g)
	{
		g.drawRect(x, y, 50, 30);
		g.drawString("" + getPoints() + "/" + getBombs(), x + 10, y + 20);
	}
}
