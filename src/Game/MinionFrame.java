package Game; // 게임의 첫 화면

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MinionFrame extends JFrame implements ActionListener{
	JButton btnS = new JButton("Play");
	JButton btnI = new JButton("Item");
	JButton btnK = new JButton("Key");
	JButton btnE = new JButton("Exit");
	
	public MinionFrame() {
		setTitle("MinionsGame");
		JPanel pan1 = new JPanel();
		JPanel pan2 = new JPanel();
		JPanel pan3 = new JPanel();
		
		JLabel lbl = new JLabel("Minions Game~!", JLabel.CENTER);
		JLabel lbl2 =new JLabel(new ImageIcon("img/left.png"));
		JLabel lbl3 =new JLabel("");
		JLabel lbl4 =new JLabel("");
		
		pan1.setBackground(new Color(241, 196, 15));
		pan2.setBackground(new Color(241, 196, 15));
		pan3.setBackground(new Color(241, 196, 15));
		
		lbl.setFont(new Font("Arial", Font.BOLD, 90));
		lbl.setForeground(new Color(52, 152, 219));
		
		pan3.add(lbl);
		add(pan3,"North");
		add(pan1,"Center");
		
		pan1.setLayout(new GridLayout(1, 2)); 
		pan2.setLayout(new GridLayout(4, 2, 30, 20));
		pan1.add(lbl2);
		pan1.add(pan2);
		pan2.add(lbl3);
		pan2.add(lbl4);
		pan2.add(btnS);
		pan2.add(btnI);
		pan2.add(btnK);
		pan2.add(btnE);
		
		btnS.setBackground(new Color(52, 152, 219));
		btnS.setFont(new Font("Arial", Font.BOLD, 40));
		btnS.setForeground(new Color(255, 255, 255));
		btnS.addActionListener(this);
		
		btnI.setBackground(new Color(52, 152, 219));
		btnI.setFont(new Font("Arial", Font.BOLD, 40));
		btnI.setForeground(new Color(255, 255, 255));
		btnI.addActionListener(this);
		
		btnK.setBackground(new Color(52, 152, 219));
		btnK.setFont(new Font("Arial", Font.BOLD, 40));
		btnK.setForeground(new Color(255, 255, 255));
		btnK.addActionListener(this);
		
		btnE.setBackground(new Color(52, 152, 219));
		btnE.setFont(new Font("Arial", Font.BOLD, 40));
		btnE.setForeground(new Color(255, 255, 255));
		btnE.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(800, 200, 800, 700);
		setVisible(true);
		setResizable(false);
		
	}
	
	public static void main(String[] args) {
		new MinionFrame();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object eBtn=e.getSource();
		if(eBtn==btnS){
			setVisible(false);
			new RunGame(MinionFrame.this);
		}else if(eBtn==btnI) {
			new Item();
		}else if(eBtn==btnK){
			new Key();
		}else 
			System.exit(0);
		}
}