package Game; // 키보드 조작 설명 화면

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Key extends JFrame implements ActionListener {
	JButton btnOk = new JButton("확인");
	JButton btnOk2 = new JButton("확인");
	MinionFrame minionframe;
	
	public Key() {
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JLabel l1 = new JLabel("키보드 조작방법", JLabel.CENTER);
		JLabel l3 = new JLabel(new ImageIcon("img/k1.png"));
		JLabel l4 = new JLabel("오른쪽과 왼쪽을 이용하여 움직인다.", JLabel.CENTER);
		
		setTitle("게임 방법!!");
		p1.setBackground(new Color(241, 196, 15));
		p2.setBackground(new Color(241, 196, 15));
		p3.setBackground(new Color(241, 196, 15));
		
		l1.setFont(new Font("굴림", Font.BOLD, 50));
		l1.setForeground(new Color(52, 152, 219));
		l4.setFont(new Font("굴림", Font.BOLD, 30));
		l4.setForeground(new Color(52, 152, 219));
		
		p1.setLayout(new GridLayout(2, 1));
		p1.add(l1);
		
		p2.setLayout(new GridLayout(2, 2));
		p2.add(l3);
		p2.add(l4);
		
		p3.add(btnOk2);
		add(p1, "North");
		add(p2);
		add(p3, "South");
		
		btnOk2.setBackground(new Color(52, 152, 219));
		btnOk2.setFont(new Font("굴림", Font.BOLD, 30));
		btnOk2.setForeground(new Color(255, 255, 255));
		btnOk2.addActionListener(this);
		setBounds(600, 100, 800, 700);
		setVisible(true);
	}
	
	public Key(String ti,String k,MinionFrame minionframe) {
		this.minionframe = minionframe;
		JPanel pan = new JPanel();
		JPanel pan2 = new JPanel();
		JLabel lbl = new JLabel(ti, JLabel.CENTER);
		JLabel lbl2 = new JLabel(k, JLabel.CENTER);
		JLabel lbl3 =new JLabel("");
		
		setTitle(ti);
		
		pan.setBackground(new Color(241, 196, 15));
		pan2.setBackground(new Color(241, 196, 15));
		lbl.setFont(new Font("고딕", Font.BOLD, 20));
		lbl.setForeground(new Color(52, 152, 219));
		lbl2.setFont(new Font("고딕", Font.BOLD, 20));
		lbl2.setForeground(new Color(255, 255, 255));
		pan.setLayout(new GridLayout(4, 1));
		pan.add(lbl3);
		pan.add(lbl3);
		pan.add(lbl);
		pan.add(lbl2);
		pan2.add(btnOk);
		add(pan);
		add(pan2,"South");
		btnOk.setBackground(new Color(52, 152, 219));
		btnOk.setFont(new Font("고딕", Font.BOLD, 18));
		btnOk.setForeground(new Color(241, 196, 15));
		btnOk.addActionListener(this);
		setBounds(800, 200, 800, 700);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object eB = e.getSource();
		if(eB == btnOk) {
			minionframe.setVisible(true);
			dispose();
		}else {
			dispose();
		}
	}

}
