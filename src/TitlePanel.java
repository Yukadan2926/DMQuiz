import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	JLabel titleLabel = new JLabel();
	JButton startButton = new JButton();
	JButton termButton = new JButton();
	JPanel btnPanel = new JPanel();

	public TitlePanel(QuizFrame qf) {
		TermFrame termFrame = new TermFrame(qf);

		titleLabel.setText("デュエマ用語クイズ");
		titleLabel.setFont(qf.font(60));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);

		startButton.setText("Start");
		startButton.setFont(qf.font(20));
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				termFrame.setVisible(false);
				qf.nextQuiz();
			}
		});

		termButton.setText("Term");
		termButton.setFont(qf.font(20));
		termButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				termFrame.setVisible(true);
			}
		});

		btnPanel.add(startButton);
		btnPanel.add(termButton);

		this.setLayout(new BorderLayout());
		this.add(titleLabel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}
}