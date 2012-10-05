package LEGO;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class LegoController extends Applet implements KeyListener
{

	private static final long serialVersionUID = 1L;
	private Grid grid;
	private ArrayList<LegoStein> legoList;
	private ArrayList<BlackHole> blackListOfDeath;

	public LegoController()
	{
		addKeyListener(this);
		legoList = new ArrayList<LegoStein>();
		blackListOfDeath = new ArrayList<BlackHole>();
		grid = new Grid(50, 80, 10);
		Random rander = new Random();
		
		for(int i = 0; i < 1000; i++)
		{
			legoList.add(new LegoStein(rander.nextInt(6)+1));
		}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(0,0, grid.getWidth(), grid.getHeight());
		grid.paint(g);
		
		blackListOfDeath = placeStones(g);
	}
	
	public ArrayList<BlackHole> placeStones(Graphics g)
	{
		Stack<BlackHole> listOfBlackHolesOfDeath = new Stack<BlackHole>();
		int xPos = 0;
		int yPos = grid.getHeight() - LegoStein.width;
		for(int i = 0; i < legoList.size(); i++)
		{
			LegoStein stein = legoList.get(i);
			if(xPos + stein.getWidth() > grid.getWidth())
			{
				int blackHoleList = (grid.getWidth() - xPos) / LegoStein.width;
				if(blackHoleList > 0)
				{
					listOfBlackHolesOfDeath.push(new BlackHole(i, blackHoleList));
				}
				xPos = 0;
				yPos -= LegoStein.width;
			}
			stein.place(xPos, yPos);
			stein.paint(g);
			xPos += stein.getWidth();
		}
		return new ArrayList<BlackHole>(listOfBlackHolesOfDeath);
	}
	
	public void fillBlackHoles()
	{
		boolean comboBreaker = false;
		for(BlackHole blackHole: blackListOfDeath)
		{
			if(comboBreaker)
			{
				break;
			}
			
			for(int i = legoList.size() - 1; i >= 0; i--)
			{
				if(blackHole.width == legoList.get(i).length)
				{
					legoList.add(blackHole.posInList, legoList.remove(i));
					comboBreaker = true;
					repaint();
					break;
				}
			}
		}
	}
	
	public void fillBlackHolesInOrder()
	{
		boolean comboBreaker = false;
		for(BlackHole blackHole: blackListOfDeath)
		{
			if(comboBreaker)
			{
				break;
			}
			
			for(int i = blackHole.posInList; i < legoList.size(); i++)
			{
				if(blackHole.width == legoList.get(i).length)
				{
					legoList.add(blackHole.posInList, legoList.remove(i));
					comboBreaker = true;
					repaint();
					break;
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(KeyEvent.getKeyText(e.getKeyCode()) == "Enter")
		{
			fillBlackHoles();
		}
		else if(KeyEvent.getKeyText(e.getKeyCode()) == "Space")
		{
			fillBlackHolesInOrder();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
