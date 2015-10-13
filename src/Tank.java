import java.awt.*;
import java.awt.event.*;
public class Tank {
	int x, y;
	public static final int XSPEED = 5;
	public static final int YSPEED = 5;
	private boolean bL = false, bU = false, bR = false, bD = false;
	enum Direction {L, R, U, D, UL, UR, DL, DR, STOP};
	
	private Direction dir= Direction.STOP;
	
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED); 
		g.fillOval(x, y , 50, 50);
		g.setColor(c);
		move();
	}
	
	protected void move() {
		 switch(dir) {
		 case L:
			 x -= XSPEED;
			 break;
		 case R:
			 x += XSPEED;
			 break;
		 case U:
			 y -= YSPEED;
			 break;
		 case D:
			 y += YSPEED;
			 break;
		 case UL:
			 y -= YSPEED;
			 x -= XSPEED;
			 break;
		 case UR:
			 y -= YSPEED;
			 x += XSPEED;
			 break;
		 case DL:
			 y += YSPEED;
			 x -= XSPEED;
			 break;
		 case DR:
			 y += YSPEED;
			 x += XSPEED;
			 break;
		 case STOP:
			 break;
		 }
	}
	
	public void KeyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_RIGHT:
			bR = true;
			break;
		case KeyEvent.VK_LEFT: 
			bL = true;
			break;
		case KeyEvent.VK_UP: 
			bU = true;
			break;
		case KeyEvent.VK_DOWN: 
			bD = true;
			break;
		}
		locateDirection();
	}
	
	protected void locateDirection() {
		if(bR && !bL && !bU && !bD) dir = Direction.R;
		else if(!bR && bL && !bU && !bD) dir = Direction.L;
		else if(!bR && !bL && bU && !bD) dir = Direction.U;
		else if(!bR && !bL && !bU && bD) dir = Direction.D;
		else if(bR && !bL && bU && !bD) dir = Direction.UR;
		else if(bR && !bL && !bU && bD) dir = Direction.DR;
		else if(!bR && bL && bU && !bD) dir = Direction.UL;
		else if(!bR && bL && !bU && bD) dir = Direction.DL;
		else if(!bR && !bL && !bU && !bD) dir = Direction.STOP;
	}

	public void KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_RIGHT:
			bR = false;
			break;
		case KeyEvent.VK_LEFT: 
			bL = false;
			break;
		case KeyEvent.VK_UP: 
			bU = false;
			break;
		case KeyEvent.VK_DOWN: 
			bD = false;
			break;
		}
		locateDirection();
	}
}
