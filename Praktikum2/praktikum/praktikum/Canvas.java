package praktikum;

import java.awt.Graphics;

public interface Canvas
{
	void paint(Graphics g);
	boolean hitsBalloon(Balloon b);
}
