
public class Point {
private int x;
private int y;

public Point(int x,int y){
	this.x=x;
	this.y=y;
}

public int getX() {
	return x;
}


public void setX(int x) {
	this.x = x;
}

public void setY(int y) {
	this.y = y;
}

public int getY() {
	return y;
}

public void move(int speedX,int speedY){
	this.x+=speedX;
	this.y+=speedY;
	
}

public int getDistance(Point other){
	int result,dX,dY;
	dX=(this.x-other.x)*(this.x-other.x);
	dY=(this.y-other.y)*(this.y-other.y);
	result=(int)(Math.sqrt(dX+dY));
	return result;
}


}
