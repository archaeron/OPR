package praktikum;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class BalloonController extends Applet implements KeyListener, Runnable
{

	private static final int sleeptime = 250;
	private Balloon balloon1;
	private Balloon balloon2;
	private BombsCounter counter1;
	private BombsCounter counter2;
	private Lava lava;
	private Thread clockThread;
	
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
