import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class AnswerPanel extends JPanel {
	JLabel textLabel = new JLabel();
	JLabel imageLabel;
	JTextField textField = new JTextField(10);
	JPanel tfPanel = new JPanel();
	JLabel numLabel = new JLabel();
	JPanel gridPanel = new JPanel();

	public AnswerPanel(int num, int color, QuizFrame qf) {
		Timer sec = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qf.nextQuiz();
			}
		});
		sec.setRepeats(false);

		textLabel.setText("この色は何？");
		textLabel.setFont(qf.font(40));
		textLabel.setHorizontalAlignment(JLabel.CENTER);

		imageLabel = qf.toLabel(qf.terms[color], 0.4);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
		imageLabel.setFont(qf.font(60));

		textField.setFont(new Font("メイリオ", Font.PLAIN, 20));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (katakana(textField.getText()).equals(qf.terms[color])) {
					imageLabel.setText("正 解");
					qf.correct();
				} else {
					imageLabel.setText("不正解");
				}
				textField.setEnabled(false);
				sec.start();
			}
		});

		tfPanel.add(textField);

		numLabel.setText(num + "/10");
		numLabel.setFont(qf.font(30));
		numLabel.setHorizontalAlignment(JLabel.RIGHT);

		gridPanel.setLayout(new GridLayout(1, 3));
		gridPanel.add(new JLabel());
		gridPanel.add(tfPanel);
		gridPanel.add(numLabel);

		this.setLayout(new BorderLayout());
		this.add(textLabel, BorderLayout.NORTH);
		this.add(imageLabel, BorderLayout.CENTER);
		this.add(gridPanel, BorderLayout.SOUTH);
	}

	public String katakana(String string) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c >= 0x3041 && c <= 0x3093) {
				c = (char) (c + 0x60);
			}
			sb.append(c);
		}
		return sb.toString();
	}
}