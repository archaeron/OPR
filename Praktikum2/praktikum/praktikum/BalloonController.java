package praktikum;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class BalloonController extends Applet implements KeyListener
{

	Balloon balloon1;
	Balloon balloon2;
	BombsCounter counter1;
	BombsCounter counter2;
	Lava lava;
	
	List<Canvas> canvasObjects;
	
	public BalloonController()
	{
		addKeyListener(this);
		balloon1 = new Balloon(100, 50, Color.red);
		balloon2 = new Balloon(50, 100, Color.blue);
		counter1 = new BombsCounter(0, 0);
		counter2 = new BombsCounter(550, 0);
		lava = new Lava();
		//canvasObjects = new List<Canvas>();
		//canvasObjects.add(lava);
	}
	
	private static final long serialVersionUID = 7201997499909924120L;

	public void paint(Graphics g)
	{
		balloon1.paint(g);
		balloon2.paint(g);
		counter1.paint(g);
		counter2.paint(g);
		lava.paint(g);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		String key = KeyEvent.getKeyText(e.getKeyCode());
		switch(key)
		{
			case "W":
				balloon1.up();
				break;
			case "D":
				balloon1.right();
				break;
			case "S":
				balloon1.down();
				break;
			case "A":
				balloon1.left();
				break;
			case "I":
				balloon2.up();
				break;
			case "L":
				balloon2.right();
				break;
			case "K":
				balloon2.down();
				break;
			case "J":
				balloon2.left();
				break;
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
	}

}
