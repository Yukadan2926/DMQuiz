import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Quiz extends JFrame {
	Container container = this.getContentPane();
	TitlePanel titlePanel = new TitlePanel(this);
//	AnswerPanel[] answerPanels = new AnswerPanel[10];
	ScorePanel scorePanel = new ScorePanel();
	CardLayout layout = new CardLayout();

	public Quiz() {
		this.setTitle("DMQuiz");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("image/dm.png").getImage());

		container.setLayout(layout);
		container.add(titlePanel);
		int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int cnt = 0, r;
		while (cnt < 10) {
			r = (int) Math.floor(Math.random() * 10);
			if (nums[r] >= 0) {
				this.add(new AnswerPanel(cnt + 1, r, this));
				nums[r] = -1;
				cnt++;
			}
		}
	}

	public static void main(String[] args) {
		Quiz quiz = new Quiz();
		quiz.setVisible(true);
	}

	public void nextQuiz() {
		layout.next(container);
	}
}