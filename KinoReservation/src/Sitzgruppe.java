import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Sitzgruppe
{
	private int rows;
	private int cols;
	private int xPosition;
	private int yPosition;
	private Color c;
	private Graphics g;
	private static final int BoxLength = 20;
	private ArrayList<Sitz> sitze;
	

	public Sitzgruppe(int rows, int cols, int x, int y) 
	{
		super();
		this.setRows(rows);
		this.setCols(cols);
		sitze = new ArrayList<Sitz>();
	
		this.xPosition = x;
		this.yPosition = y;
		
		for(int j = 0; j < cols; j++)
		{
			for(int i = 0; i < rows; i++)
			{				
				sitze.add(new Sitz(xPosition + (BoxLength * i), yPosition, BoxLength, BoxLength));
			}
			yPosition = yPosition + BoxLength;
		}
	}

	
	public ArrayList<Sitz> getSitze() {
		return sitze;
	}


	public void setSitze(ArrayList<Sitz> sitze) {
		this.sitze = sitze;
	}




	public int getRows() 
	{
		return rows;
	}
	
	public void place(Graphics g, Color c)
	{
		this.c = c;
		this.g = g;

		for(Sitz sz: sitze)
		{			
			g.setColor(this.c);
			sz.drawSeat(g);
		}
		
	}
	
	public void paint(Graphics g)
	{
		
	}


	public void setRows(int rows) 
	{
		this.rows = rows;
	}


	public int getCols() 
	{
		return cols;
	}


	public void setCols(int cols) 
	{
		this.cols = cols;
	}
	

}
