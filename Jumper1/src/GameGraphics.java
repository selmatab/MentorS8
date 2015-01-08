import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameGraphics extends JPanel implements ActionListener {
	private Timer animation;
	private Body player;
	Body[] elements;
	int elementsCount;
	protected int width=500;
	protected int height=500;
	int counter=0;
//	protected Rect rect1;
//	protected Rect rect2;
//	protected Rect rect3;

	public GameGraphics(){
		super();
		animation=new Timer(17,this);
		player=new Oval(250,400,20,30,Color.BLUE,0,15,0,0,500,400);
		
		
		elements=new Body[5];
		elements[0]=new Rect(600,400,25,40,Color.CYAN,-3,0,-100,0,500,400);
		elements[1]=new Rect(800,400,25,30,Color.CYAN,-3,0,-100,0,500,400);
		elements[2]=new Rect(1000,400,25,33,Color.CYAN,-3,0,-100,0,500,400);
		elements[3]=new Rect(1200,400,25,39,Color.CYAN,-3,0,-100,0,500,400);
		elements[4]=new Rect(1400,400,25,40,Color.CYAN,-3,0,-100,0,500,400);
		
		animation.start();
		addKeyListener(new KeyHandler());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			this.setBackground(new Color(184, 242, 245));
			player.draw(g);
//			boole
//			for (int i=0; i < elementsCount; i++)
//			{
//				elements[i].draw(g);
//			}
			g.setColor(Color.GREEN);
			g.fillRect(0, 400, 500+1000, 100);
			g.setColor(Color.BLACK);
			for(int i=0;i<5;i++){
				elements[i].draw(g);
				elements[i].reset();
			
			
//				if(stop==false)
//				{
//					
//				}
			}
			
			for(int i=0;i<elements.length;i++)
			{
				if(player.checkCollision(elements[i])==true){
					animation.stop();
				}
			
				if(elements[i].getX()<player.getX()){
					counter++;
			}
			}
		}
		
private class KeyHandler extends KeyAdapter{
	@Override
	public void keyTyped(KeyEvent e) {
		player.jump();
	}
}
}

		
	

