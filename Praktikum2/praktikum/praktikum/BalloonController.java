package praktikum;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class BalloonController extends Applet implements KeyListener, Runnable
{

	private static final int sleeptime = 250;
	private Balloon balloon1;
	private Balloon balloon2;
	private BombsCounter counter1;
	private BombsCounter counter2;
	private Lava lava;
	private Thread clockThread;
	public static final int canvasWidth = 600;
	public static final int canvasHeight = 600;
	
	LinkedList<Bomb> bombsList;
	
	public BalloonController()
	{
		addKeyListener(this);
		balloon1 = new Balloon(100, 50, Color.red);
		counter1 = new BombsCounter(0, 0);
		balloon1.setCounter(counter1);
		
		balloon2 = new Balloon(50, 100, Color.blue);
		counter2 = new BombsCounter(550, 0);
		balloon2.setCounter(counter2);
		
		bombsList = new LinkedList<Bomb>();
		
		lava = new Lava();

	}
	
	public void start()
	{
		if (clockThread == null)
		{
	        clockThread = new Thread(this, "Clock");
	        clockThread.start();
	    }
	}
	
	public void stop()
	{
	    clockThread.stop();
	    clockThread = null;
	}
	
	private static final long serialVersionUID = 7201997499909924120L;

	public void paint(Graphics g)
	{
		balloon1.paint(g);
		balloon2.paint(g);
		counter1.paint(g);
		counter2.paint(g);
		lava.paint(g);
		System.out.println("repaint");
		for(Bomb b : bombsList)
		{
			b.paint(g);
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		String key = KeyEvent.getKeyText(e.getKeyCode());
		switch(key)
		{
			case "W":
				balloon1.up(true);
				break;
			case "D":
				balloon1.right(true);
				break;
			case "S":
				balloon1.down(true);
				break;
			case "A":
				balloon1.left(true);
				break;
			case "C":
				bombsList.add(balloon1.dropBomb());
				break;
			case "I":
				balloon2.up(true);
				break;
			case "L":
				balloon2.right(true);
				break;
			case "K":
				balloon2.down(true);
				break;
			case "J":
				balloon2.left(true);
				break;
			case "N":
				Bomb b = balloon2.dropBomb();
				if(b != null)
				{
					bombsList.add(b);
				}
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		String key = KeyEvent.getKeyText(e.getKeyCode());
		switch(key)
		{
			case "W":
				balloon1.up(false);
				break;
			case "D":
				balloon1.right(false);
				break;
			case "S":
				balloon1.down(false);
				break;
			case "A":
				balloon1.left(false);
				break;
			case "I":
				balloon2.up(false);
				break;
			case "L":
				balloon2.right(false);
				break;
			case "K":
				balloon2.down(false);
				break;
			case "J":
				balloon2.left(false);
				break;
		}
	}

	@Override
	public void run()
	{
	    while (clockThread != null) {
	        repaint();
	        try {
	            clockThread.sleep(sleeptime);
	        } catch (InterruptedException e){
	        }
	    }
	}

}
