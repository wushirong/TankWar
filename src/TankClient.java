import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;



public class TankClient extends Frame {
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(150, 150, 50, 50);
		g.setColor(c);
	}

	public void lauchFrame() {
		this.setLocation(400, 300);
		this.setSize(800, 600);
		this.setName("TankWar");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setResizable(false);
		this.setBackground(Color.GREEN);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}
