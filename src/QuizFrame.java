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
	Container container = this.getContentPane();
	TitlePanel titlePanel = new TitlePanel(this);
	ScorePanel scorePanel = new ScorePanel(this);
	CardLayout layout = new CardLayout();

	public QuizFrame() {
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
		container.add(scorePanel);
	}

	public static void main(String[] args) {
		QuizFrame quizFrame = new QuizFrame();
		quizFrame.setVisible(true);
	}

	public void nextQuiz() {
		layout.next(container);
	}

	public void correct() {
		scorePanel.increment();
	}

	public Font font(int size) {
		return new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.PLAIN, size);
	}

	public JLabel toLabel(String string, double size) {
		ImageIcon icon = new ImageIcon("image/" + string + ".png");
		Image image = icon.getImage();
		int width = (int) (icon.getIconWidth() * size);
		Image smallImage = image.getScaledInstance(width, -1, Image.SCALE_SMOOTH);
		ImageIcon smallIcon = new ImageIcon(smallImage);
		return new JLabel(smallIcon);
	}

	public String term(int num) {
		return terms[num];
	}
}