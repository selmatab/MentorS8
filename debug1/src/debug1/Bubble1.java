package debug1;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Klasa za crtanje i pomijeranje kruga, gdje je event handler napisan u inner klasi
 * 
 * @author Selma
 *
 */
public class Bubble1 {
	private static int x = 400;
	private static int y = 300;
	private static int frameX = 0;
	private static int frameY = 0;

	/**
	 * Kreiramo frame na koji lijepi panel i testira ga
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Moving Circle");
		window.setSize(800, 600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(600, 300);
		myPanel panel = new myPanel();
		window.setContentPane(panel);
		panel.addKeyListener(new myKeyListener());
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		window.setVisible(true);
		Timer timer = new Timer(15, panel);
		timer.start();

	}

	/**
	 * Inner klasa myPanel kojoj overrideamo metode po potrebi
	 * 
	 * @author Selma
	 *
	 */
	public static class myPanel extends JPanel implements ActionListener {
		@Override
		/**
		 * metoda za crtanje kruga
		 */
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillOval(x, y, 50, 50);
		}

		/**
		 * metoda za pomijeranje kruga
		 */

		@Override
		public void actionPerformed(ActionEvent arg0) {
			x += frameX;
			y += frameY;
			repaint();
		}

	}

	/**
	 * Inner klasa gdje su napisane komande za arrow tipke
	 * 
	 * @author Selma
	 *
	 */
	public static class myKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				frameX = -1;
				frameY = 0;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				frameX = 1;
				frameY = 0;
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				frameY = -1;
				frameX = 0;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				frameY = 1;
				frameX = 0;
			}
		}

	}

}