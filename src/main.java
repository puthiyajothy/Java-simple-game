import javax.swing.JFrame;

public class main {
	public static void main(String[] args) {
		JFrame frameObj = new JFrame();
		Gameplay gameplay =new Gameplay();
		frameObj.setBounds(10,10,700,600);
		frameObj.setTitle("Brick Breaker");
		frameObj.setResizable(false);
		frameObj.setVisible(true);
		frameObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameObj.add(gameplay);
		
	}

}
