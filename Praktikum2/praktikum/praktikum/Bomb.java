package praktikum;

import java.awt.Color;
import java.awt.Graphics;

public class Bomb implements Canvas
{

	private int x;
	private int y;
	
	public Bomb(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(x, y, 25, 25);
		drop();
	}
	
	public void drop()
	{
		y = y + 15;
	}

	@Override
	public boolean hitsBalloon(Balloon b)
	{
		// TODO Auto-generated method stub
		return false;
	}
	
}
