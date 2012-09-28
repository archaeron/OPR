package praktikum;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BalloonController extends Applet implements KeyListener
{

	Balloon balloon1;
	Balloon balloon2;
	
	public BalloonController()
	{
		addKeyListener(this);
		balloon1 = new Balloon(100, 50, Color.red);
		balloon2 = new Balloon(50, 100, Color.blue);
	}
	
	private static final long serialVersionUID = 7201997499909924120L;

	public void paint(Graphics g)
	{
		balloon1.paint(g);
		balloon2.paint(g);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		String key = KeyEvent.getKeyText(e.getKeyCode());
		switch(key)
		{
			case "Up":
				balloon1.up();
				break;
			case "Right":
				balloon1.right();
				break;
			case "Down":
				balloon1.down();
				break;
			case "Left":
				balloon1.left();
				break;
			case "W":
				balloon2.up();
				break;
			case "D":
				balloon2.right();
				break;
			case "S":
				balloon2.down();
				break;
			case "A":
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
