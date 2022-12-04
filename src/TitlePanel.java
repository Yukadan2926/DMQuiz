import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
	public TitlePanel(Quiz mf) {
		Quiz mainframe = mf;
		JLabel titleLabel = new JLabel("デュエマ用語クイズ");
		JButton startButton = new JButton("Start");
		JPanel btnPanel = new JPanel();

		titleLabel.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.PLAIN, 60));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);

		startButton.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.PLAIN, 20));
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainframe.nextQuiz();
			}
		});
		btnPanel.add(startButton);

		this.setLayout(new BorderLayout());
		this.add(titleLabel, BorderLayout.CENTER);
		this.add(btnPanel, BorderLayout.SOUTH);
	}
}