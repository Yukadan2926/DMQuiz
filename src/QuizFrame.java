import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QuizFrame extends JFrame {
	String[] terms = {
			"アナカラー",
			"クローシス",
			"シータ",
			"デアリ",
			"デイガ",
			"トリーヴァ",
			"ドロマー",
			"ネクラ",
			"ラッカ",
			"リース"
	};
	int[] score = new int[10];
	Container container = this.getContentPane();
	CardLayout layout = new CardLayout();

	public QuizFrame() {
		this.setTitle("DMQuiz");
		this.setSize(600, 400);
		this.setIconImage(new ImageIcon("image/dm.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container.setLayout(layout);
		this.reset();
	}

	public static void main(String[] args) {
		QuizFrame quizFrame = new QuizFrame();
		quizFrame.setVisible(true);
	}

	public void reset() {
		container.removeAll();
		TitlePanel titlePanel = new TitlePanel(this);
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

	public JLabel toLabel(String string, double size) {
		ImageIcon icon = new ImageIcon("image/" + string + ".png");
		Image image = icon.getImage();
		int width = (int) (icon.getIconWidth() * size);
		Image smallImage = image.getScaledInstance(width, -1, Image.SCALE_SMOOTH);
		ImageIcon smallIcon = new ImageIcon(smallImage);
		return new JLabel(smallIcon);
	}

	public void scoreDisplay() {
		ScorePanel scorePanel = new ScorePanel(this);
		container.add(scorePanel);
	}

	public void nextPage() {
		layout.next(container);
	}

	public Font font(int size) {
		return new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.PLAIN, size);
	}
}