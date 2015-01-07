import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class Body {
	private Point start;
	private Point center;
	private int width;
	private int height;
	private Color color;
	private int speedX;
	private int speedY;
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;

	public Body(int x, int y, int width, int height, Color color, int speedX,
			int speedY, int minX, int minY, int maxX, int maxY) {
		this.start = new Point(x, y);
		this.center = new Point(x + width / 2, y + height / 2);
		this.width = width;
		this.height = height;
		this.color = color;
		this.speedX = speedX;
		this.speedY = speedY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.minX = minX;
		this.minY = minY;

	}

	/**
	 * Metoda u kojoj se samo pomice tijelo, bez ponovnog iscrtavanja.
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		move();
		g.setColor(color);
		return;
	}

	public Point getStart() {
		return start;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return start.getX();
	}

	public int getY() {
		return start.getY();
	}

	/**
	 * Metoda koja provjerava koliziju tj da li se dva tijela dodiruju.
	 * 
	 * @param other
	 * @return
	 */
	public boolean checkCollision(Body other) {
		if ((this.center.getDistance(other.center) < this.height / 2
				+ other.height / 2)
				|| (this.center.getDistance(other.center) < this.width / 2
						+ other.width / 2))
			return true;

		return false;
	}

	/**
	 * metoda koja pomjera tijelo, vodeci racuna o okvirima u kojima je moguce
	 * pomjeriti tijelo.
	 */
	private void move() {
		if ((this.start.getX() + this.width + speedX) >= maxX && speedX >= 0) {
			speedX = 0;
			start.setX(maxX - width);
		}

		if (this.start.getX() + speedX <= minX && speedX <= 0) {
			speedX = 0;
			start.setX(minX);
		}
		if (this.start.getY() + this.height + speedY >= maxY && speedY >= 0) {
			speedY = 0;
			start.setY(maxY - height);
		}
		if (this.start.getX() + this.height + speedY <= minY && speedY <= 0) {
			speedY = 0;
			start.setY(minY);
		}

		this.start.move(speedX, speedY);
		this.center.move(speedX, speedY);
	}

	/**
	 * privatna klasa koja sluzi za stopiranje timera
	 * 
	 * @author selmatabakovic
	 *
	 */
	private class JumpHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			speedY = 5;
			Timer t = (Timer) e.getSource();
			t.stop();
		}
	}

	/**
	 * metoda za preskakanje i kreiranje novog timera koji ce omoguciti
	 * kontinuirano preskakanje
	 */
	public void jump() {
		if (start.getY() == maxY - height) {
			speedY = -5;
			Timer t1 = new Timer(300, new JumpHandler());
			t1.start();

		}
	}

	/**
	 * Metoda za resetovanje pozicije niza prepreka, tj. kada niz dodje do pocetka framea,
     * da ga ponovo pozicionira na kraj framea.
	 */
	public void reset() {
		if (this.start.getX() <= minX) {
			this.start.setX(maxX);
			this.center.setX(maxX + width / 2);
			
		}

	}

	
}
