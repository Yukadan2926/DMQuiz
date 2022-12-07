import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	int score = 0;
	JLabel label = new JLabel();
	JPanel centerPanel = new JPanel();
	JButton titleButton = new JButton();
	QuitButton quitButton = new QuitButton();
	JPanel btnPanel = new JPanel();

	public ScorePanel(QuizFrame qf) {
		for (int i: qf.score) {
			score += i;
		}
		label.setText(score + "問正解！");
		label.setFont(qf.font(50));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setOpaque(true);
		label.setBackground(Color.YELLOW);

		centerPanel.setLayout(new GridLayout(1, 2));
		for (int i = 0; i < 2; i++) {
			JPanel resultPanel = new JPanel();
			resultPanel.setLayout(new GridLayout(5, 1));
			for (int j = 0; j < 5; j++) {
				int num = i * 5 + j;
				StringBuilder sb = new StringBuilder((num + 1) + "問目");
				if (qf.score[num] == 1) {
					sb.append(" ○");
				} else {
					sb.append(" ×");
				}
				JLabel l = new JLabel(sb.toString());
				l.setHorizontalAlignment(JLabel.CENTER);
				l.setFont(qf.font(30));
				resultPanel.add(l);
			}
			centerPanel.add(resultPanel);
		}

		titleButton.setText("Title");
		titleButton.setFont(qf.font(20));
		titleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				System.out.println(1);
				qf.reset();
			}
		});

		btnPanel.add(titleButton);
		btnPanel.add(quitButton);

		this.setLayout(new BorderLayout());
		this.add(label, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}
}