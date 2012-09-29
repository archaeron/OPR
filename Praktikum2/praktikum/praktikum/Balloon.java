package praktikum;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Balloon
{
	private int x;
	private int y;
	private Color mainColor;
	private Color ropeColor = new Color(184, 134, 11);
	private Color basketColor = new Color(160, 82, 45);
	private Graphics g;
	private int size = 100;
	private int step = 15;
	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private BombsCounter bombsCounter;
	private String playerName;

	public Balloon(int x, int y, Color c, String playerName)
	{
		this.x = x;
		this.y = y;
		mainColor = c;
		this.playerName = playerName;
	}
	
	public void setCounter(BombsCounter bombsCounter)
	{
		this.bombsCounter = bombsCounter;
	}
	
	public void paint(Graphics g)
	{
		move();
		this.g = g;
		g.setColor(ropeColor);
		g.drawLine(x, y + size / 6 * 3, x + size / 3, y + size / 3 * 4);
		g.drawLine(x + size, y + size / 6 * 3, x + size / 3 * 2, y + size / 3 * 4);
		g.setColor(basketColor);
		g.fillRect(x + size / 3, y + size / 3 * 4, size / 3, size / 3);
		g.setColor(mainColor);
		g.fillOval(x, y, size, size);
	}
	
	public void move()
	{
		if(upPressed) y = y - step;
		if(downPressed) y = y + step;
		if(leftPressed) x = x - step;
		if(rightPressed) x = x + step;
	}
	
	public void repaint()
	{
		paint(g);
	}
	
	public void explode()
	{
		g.setColor(Color.red);
		g.fillRect(0, 0, 600, 600);
		g.setColor(Color.white);
		g.drawString("Game over, "+playerName+", you lose!!!", 100, 250);
	}
	
	public int getYBottom()
	{
		return (y + size / 3 * 4) + size / 3;
	}
	
	public int getXMiddle()
	{
		return (x + size / 3);
	}
	
	public void up(boolean pressed)
	{
		upPressed = pressed;
	}

	public void down(boolean pressed)
	{
		downPressed = pressed;
	}

	public void right(boolean pressed)
	{
		rightPressed = pressed;
	}

	public void left(boolean pressed)
	{
		leftPressed = pressed;
	}
	
	public Bomb dropBomb()
	{
		if(bombsCounter.getBombs() > 0)
		{
			bombsCounter.dropBomb();
			Bomb bomb = new Bomb(x, y);
			return bomb;
		}
		else
		{
			return null;
		}
	}
	
}
