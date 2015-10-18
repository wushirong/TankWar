import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Missile {

	int x, y;
	public static final int radius = 10;
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	Tank.Direction dir;
	
	private TankClient tc;
	private boolean live = true;
	

	public Missile(int x, int y, Tank.Direction dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public Missile(int x, int y, Tank.Direction dir, TankClient tc) {
		this(x, y, dir);
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		if(!live) {
			tc.missile.remove(this);
			return;
		}
		
		Color c = g.getColor();
		g.setColor(Color.black);
		g.fillOval(x - radius/2, y - radius/2, radius, radius);
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
			live = false;
			tc.missile.remove(this);
		}
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, radius, radius);
	}
	
	public boolean hitTank(Tank t) {
		if(this.getRect().intersects(t.getRect()) && t.isLive()) {
			t.setLive(false);
			this.live = false;   
			Explode e = new Explode(x, y, tc);
			tc.explodes.add(e);
			return true;
		}
		
		return false; 
	}
	
	public boolean isLive() {
		return live;
	}
}
  