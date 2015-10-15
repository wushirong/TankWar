import java.awt.Color;
import java.awt.Graphics;


public class Missile {
	int x, y;
	int radious = 5;
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	Tank.Direction dir;
	private boolean exist = true;
	private TankClient tc;
	
	public boolean isExist() {
		return exist;
	}

	public Missile(int x, int y, Tank.Direction dir, TankClient tc) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillOval(x - radious/2, y - radious/2, radious, radious);
		g.setColor(c);
		move();
		
	} 
	
	private void move() {
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
		if(x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_HEIGHT) {
			exist = false;
			tc.missile.remove(this);
		}
	}
}
