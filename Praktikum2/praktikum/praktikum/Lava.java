package praktikum;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Lava implements Canvas
{

	int[] terrainX;
	int[] terrainY;
	int resolution = 100;
	private int maxHeight = 50;
	Polygon terrainPolygon;
	
	public Lava()
	{
		terrainX = new int[resolution + 2];
		terrainY = new int[resolution + 2];
		
		for(int i = 0; i < resolution; i++)
		{
			terrainX[i] = (600/resolution)*i;
			terrainY[i] = 600-maxHeight + (int)(Math.random() * (600-maxHeight - 600-10));
		}
		
		terrainX[resolution] = 600;
		terrainY[resolution] = 600;
		terrainX[resolution + 1] = 0;
		terrainY[resolution + 1] = 600;

		terrainPolygon = new Polygon(terrainX, terrainY, resolution + 2);
	}
	
	public void checkCollision(Balloon b)
	{
		int checkX = b.getXMiddle() / (600 / resolution);
		if(!(b.getYBottom() < terrainY[checkX]))
		{
			b.explode();
		}
	}
	
	
	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.orange);
		
		//g.fillRect(0, 550, 600, 50);
		g.fillPolygon(terrainPolygon);
	}

	@Override
	public boolean hitsBalloon(Balloon b)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
