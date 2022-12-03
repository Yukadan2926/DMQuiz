import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Quiz extends JFrame {
	Container container = this.getContentPane();
	TitlePanel titlePanel = new TitlePanel();
	AnswerPanel[] answerPanels = new AnswerPanel[10];
	ScorePanel scorePanel = new ScorePanel();

	public Quiz() {
		setTitle("DMQuiz");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("image/dm.png").getImage());
	}

	public static void main(String[] args) {
		Quiz quiz = new Quiz();
		quiz.setVisible(true);
	}
}