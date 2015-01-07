import java.awt.Color;
import java.awt.Graphics;



	public class Rect extends Body{

		public Rect(int x, int y, int width, int height, Color color, int speedX,
				int speedY,int minX,int minY,int maxX,int maxY) {
			super(x, y, width, height, color, speedX, speedY,minX,minY,maxX,maxY);
		
		}

		@Override
		public void draw(Graphics g) {
			super.draw(g);
			g.setColor(Color.CYAN);
			g.fillRect(super.getX(),super.getY(), getWidth(), getHeight());
		}

}
