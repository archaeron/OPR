import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class KinoController extends Applet implements MouseListener{

	ArrayList<Sitzgruppe> sitzgruppen = new ArrayList<Sitzgruppe>();
	
	Sitzgruppe gruppe1, gruppe2, gruppe3, gruppe4, gruppe5, gruppe6, gruppe7;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public KinoController()
	{
		gruppe1 = new Sitzgruppe(4, 2, 10, 10);
		gruppe2 = new Sitzgruppe(16, 4, 100, 10);
		gruppe3 = new Sitzgruppe(4, 2, 430, 10);
		gruppe4 = new Sitzgruppe(2, 9, 40, 120);
		gruppe5 = new Sitzgruppe(14, 5, 120, 100);
		gruppe6 = new Sitzgruppe(2, 9, 440, 120);
		gruppe7 = new Sitzgruppe(10, 8, 150, 220);

		addMouseListener(this);
	}
	
	public void paint(Graphics g)
	{
		addSitzgruppen(g);
	}
	
	public void addSitzgruppen(Graphics g)
	{
		gruppe1.place(g, Color.blue);
		sitzgruppen.add(gruppe1);

		gruppe2.place(g, Color.gray);
		sitzgruppen.add(gruppe2);
		
		gruppe3.place(g, Color.magenta);
		sitzgruppen.add(gruppe3);
		
		gruppe4.place(g, Color.blue);
		sitzgruppen.add(gruppe4);
		
		gruppe5.place(g, Color.gray);
		sitzgruppen.add(gruppe5);
		
		gruppe6.place(g, Color.magenta);
		sitzgruppen.add(gruppe6);
		
		gruppe7.place(g, Color.gray);
		sitzgruppen.add(gruppe7);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(Sitzgruppe sz : sitzgruppen) {
	       for(Sitz sitz: sz.getSitze())
	       {
	    	   if(sitz.getRect().getBounds().contains(e.getPoint())) 
	    	   {
	    		   sitz.reserve();
	    		   repaint();
	    	   }
	       }
	    }
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
