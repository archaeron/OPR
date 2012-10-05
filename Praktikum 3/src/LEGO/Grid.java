package LEGO;

import java.awt.Color;
import java.awt.Graphics;

public class Grid
{
	int xSteps;
	int ySteps;
	int unitWidth;
	
	public Grid(int xSteps, int ySteps, int unitWidth)
	{
		this.xSteps = xSteps;
		this.ySteps = ySteps;
		this.unitWidth = unitWidth;
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		for(int i = 0; i <= xSteps; i++)
		{
			g.drawLine(i*unitWidth, 0, i*unitWidth, ySteps * unitWidth);
		}
		for(int i = 0; i <= ySteps; i++)
		{
			g.drawLine(0, i*unitWidth, xSteps * unitWidth, i*unitWidth);
		}
	}
	
	public int getWidth()
	{
		return xSteps * unitWidth;
	}
	
	public int getHeight()
	{
		return ySteps * unitWidth;
	}
}
