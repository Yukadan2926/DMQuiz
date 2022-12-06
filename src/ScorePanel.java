import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	Integer score = 0;
	JLabel label = new JLabel();

	public ScorePanel(QuizFrame qf) {
		QuizFrame quizFrame = qf;
		JButton button = new JButton("Title");
		JPanel panel = new JPanel();

		label.setText("0問正解");
		label.setFont(quizFrame.font(40));
		label.setHorizontalAlignment(JLabel.CENTER);

		button.setFont(quizFrame.font(20));
		panel.add(button);

		this.setLayout(new BorderLayout());
		this.add(label, BorderLayout.NORTH);
		this.add(panel, BorderLayout.SOUTH);
	}

	public void increment() {
		score++;
		label.setText(score.toString() + "問正解");
	}
}