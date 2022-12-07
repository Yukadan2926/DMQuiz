import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class QuitButton extends JButton implements ActionListener {
	public QuitButton() {
		this.setText("Quit");
		this.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.PLAIN, 20));
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}