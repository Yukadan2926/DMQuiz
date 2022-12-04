import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AnswerPanel extends JPanel {
	String[] answers = {
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

	public AnswerPanel(int num, int color, Quiz mf) {
		Quiz mainframe = mf;
		JLabel textLabel = new JLabel("この色は何？");
		JLabel imageLabel;
		JTextField textField = new JTextField(10);
		JPanel tfPanel = new JPanel();

		textLabel.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.PLAIN, 40));
		textLabel.setHorizontalAlignment(JLabel.CENTER);

		imageLabel = toLabel("image/" + answers[color] + ".png", 0.4);

		textField.setFont(new Font("メイリオ", Font.PLAIN, 20));
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (katakana(textField.getText()).equals(answers[color])) {
					imageLabel.setText("正 解");
					textField.setEnabled(false);
					mainframe.nextQuiz();
				}
			}
		});
		tfPanel.add(textField);

		this.setLayout(new BorderLayout());
		this.add(textLabel, BorderLayout.NORTH);
		this.add(imageLabel, BorderLayout.CENTER);
		this.add(tfPanel, BorderLayout.SOUTH);
	}

	public JLabel toLabel(String string, double size) {
		ImageIcon icon = new ImageIcon(string);
		Image image = icon.getImage();
		int width = (int) (icon.getIconWidth() * size);
		Image smallImage = image.getScaledInstance(width, -1, Image.SCALE_SMOOTH);
		ImageIcon smallIcon = new ImageIcon(smallImage);
		return new JLabel(smallIcon);
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