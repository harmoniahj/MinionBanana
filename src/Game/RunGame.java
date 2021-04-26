package Game; // 게임 작동

import javax.swing.JFrame;

public class RunGame extends JFrame{
	MinionFrame minionFrame;
	
	public RunGame(MinionFrame minionFrame) {
		this.minionFrame = minionFrame;
		
		GameTool game = new GameTool();
		
		setTitle("Minions Game~!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(800, 200, 800, 650);
		game.setSize(800, 600);
		game.setVisible(true);
	}
}
