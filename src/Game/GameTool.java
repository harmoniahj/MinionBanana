package Game; // 게임 기능 구현

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GameTool extends JFrame implements KeyListener, Runnable {
	Image m;
	Image imgbom;
	Image imgba;
	Image img_back;
	Image buffImage; 
	Graphics buffg;
	
	Rectangle Rect1, Rect2, Rect3;
	int width;
	int height;
	
	int x,y;
	int score, bascore, totscore;	
	int dead; 
	int bomeed,baeed; 
	long time,start, end;
	int cnt;
	
	ArrayList Bomb = new ArrayList();
	ArrayList Banana = new ArrayList();
	Bomm en;
	BANANA BBA;
	Thread th1;
	
	public GameTool() {	
		th1 = new Thread(this);
		init();
		th1.start();
		
		setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int xpos = (int) (screen.getWidth() / 2 - width / 2);
		int ypos = (int) (screen.getHeight() / 2 - height / 2);

		setBounds(xpos, ypos, width, height);
		
		setTitle("Minions game");
		setResizable(false);
		}
	
	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	
		x = 300;
		y = 520;
		
		width = 800;
		height = 600;
		
		m = new ImageIcon("img/m.png").getImage();
		imgbom = new ImageIcon("img/bom.png").getImage();
		img_back = new ImageIcon("img/back.jpg").getImage();
		imgba = new ImageIcon("img/ba.png").getImage();
		
		bascore = 0;
		totscore = 0;
		score = 0;
		dead = 1;
		bomeed = 5;
		baeed = 5;
	
		addKeyListener(this);
	}
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();	
		while(true) {
			try {
				BombProcess();
				BananaProcess();
				repaint();
				th1.sleep(20);
				cnt++;
				totscore = score + bascore;		
				if(dead <= 0) {
					end();
					}
				long end = System.currentTimeMillis();
				time = (end - start)/1000;
				}
			catch (Exception e) {
				e.printStackTrace();
				}
		}
	}
	
	public void BombProcess(){
		for (int i = 0 ; i < Bomb.size() ; ++i ){ 
			en = (Bomm)(Bomb.get(i)); 
			en.move(); 
			if(en.y >540){ 
				Bomb.remove(i); 
				}
			}
		
		Rect1 = new Rectangle(x, y, 70, 70);
		for (int i = 0 ; i < Bomb.size() ; ++i ){ 
			en = (Bomm)(Bomb.get(i));
			Rect2 = new Rectangle(en.x,en.y,40,70); 
			
			if(Rect1.intersects(Rect2)) {
				Bomb.remove(i);
				dead--;			
				}
			}
		
		if ( cnt % 120 == 0 ){ 
			double rx = Math.random() * 750;
			double ry = Math.random() * 700 +600;
			double rx1 = Math.random() * 750;
			double ry1 = Math.random() * 700 +600;
			double rx2 = Math.random() * 750;
			double ry2 = Math.random() * 700 +600;
			double rx3 = Math.random() * 750;
			double ry3 = Math.random() * 700 +600;
			
			en = new Bomm((int)rx, height-(int)ry,bomeed);
			Bomb.add(en);
			en = new Bomm((int)rx1, height-(int)ry1,bomeed);
			Bomb.add(en);
			en = new Bomm((int)rx2, height-(int)ry2,bomeed);
			Bomb.add(en);
			en = new Bomm((int)rx3, height-(int)ry3,bomeed);
			Bomb.add(en);
			}
		}
	
	public void BananaProcess(){
		
		for (int i = 0 ; i < Banana.size() ; ++i ){ 
			BBA = (BANANA)(Banana.get(i)); 
			
			BBA.move(); 
			if(BBA.y > 540){ 
				Banana.remove(i); 
				}
			}
			
			Rect1 = new Rectangle(x, y, 70, 70);
			for (int i = 0 ; i < Banana.size() ; ++i ){ 
				BBA = (BANANA)(Banana.get(i)); 
				Rect3 = new Rectangle(BBA.x,BBA.y,50,50); 
				
				if(Rect1.intersects(Rect3)) {
					Banana.remove(i);
					bascore += 10;
				}
			}
			
			if ( cnt % 300 == 0 ){
				double rx = Math.random() * 750;
				double ry = Math.random() * 700 +600;
				double rx1 = Math.random() * 750;
				double ry1 = Math.random() * 700 +600;
				double rx2 = Math.random() * 750;
				double ry2 = Math.random() * 700 +600;
				double rx3= Math.random() * 750;
				double ry3 = Math.random() * 700 +600;
				double rx4= Math.random() * 750;
				double ry4 = Math.random() * 700 +600;
				
				BBA = new BANANA((int)rx, height-(int)ry,baeed);
				Banana.add(BBA);
				BBA = new BANANA((int)rx1, height-(int)ry1,baeed);
				Banana.add(BBA);
				BBA = new BANANA((int)rx2, height-(int)ry2,baeed);
				Banana.add(BBA);
				BBA = new BANANA((int)rx3, height-(int)ry3,baeed);
				Banana.add(BBA);
				BBA = new BANANA((int)rx4, height-(int)ry4,baeed);
				Banana.add(BBA);	
			}
		}
	
	public void end() {

		dispose();
		
		UIManager.put("OptionPane.background", new Color(241, 196, 15));
		UIManager.put("Panel.background", new Color(241, 196, 15));
		UIManager.put("OptionPane.messageForeground", new Color(52, 152, 219));
		
		UIManager.put("Button.background", new Color(52, 152, 219));
		UIManager.put("Button.foreground", Color.white);
		
		JOptionPane.showMessageDialog(this, "점수 : "+totscore+"점");
		
		int Restart = JOptionPane.showConfirmDialog(this, "다시 시작 하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
		
		if(Restart == JOptionPane.YES_OPTION) {	
			new GameTool();
			th1.stop();
			th1 = new Thread(this);
			th1.start();
			}
		else {
			new MinionFrame();
			th1.stop();
		}
	}
			
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		buffImage = createImage(width, height); 
		buffg = buffImage.getGraphics();
		update(g);
		}
	
	public void update(Graphics g){
		Draw_Back();
		Draw_Char();
		DrawBomb();
		DrawBana();
		Draw_StatusText();
		g.drawImage(buffImage, 0, 0, this); 
		}

	public void Draw_Char(){ 
		buffg.drawImage(m, x, y, this);
	}
	
	public void DrawBomb() {

		for (int i = 0; i < Bomb.size(); ++i) {
			en = (Bomm) (Bomb.get(i));
			buffg.drawImage(imgbom, en.x, en.y, this);
		}
	}
	
	public void DrawBana() {
	
		for (int i = 0; i < Banana.size(); ++i) {
		
			BBA = (BANANA) (Banana.get(i));
			buffg.drawImage(imgba,BBA.x, BBA.y, this);
		}
	}
	
	public void Draw_Back() {
		buffg.drawImage(img_back, 0, 0, this);
		
	}
	
	public void Draw_StatusText() {

		buffg.setFont(new Font("Defualt", Font.BOLD, 20));
		buffg.setColor(new Color(241, 196, 15));
		buffg.drawString("점수 : " + totscore, 680, 65);
		}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			x += 10;
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			x -= 10;
			repaint();

			break;
		}
	
		if(x <= 0) {
			x = 0;
			repaint();
		}
		if(x >= 800) {
			x = 800;
			repaint();
		}

	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

class Bomm {
		int x;
		int y;
		int speed;
		Bomm(int x, int y, int speed) {
			this.x = x;
			this.y = y;
			this.speed = speed;
		}
		
		public void move() {
			y += speed;
		}
}

class BANANA {

		int x;
		int y;
		int speed;
		BANANA(int x, int y, int speed) {
			this.x = x;
			this.y = y;
			this.speed = speed;
		}

		public void move() {
			y += speed;
		}
}