import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TermFrame extends JFrame implements ActionListener {
	String[] colors = {
			"(水,闇,自然)",
			"(水,闇,火)",
			"(水,火,自然)",
			"(闇,火,自然)",
			"(光,闇,火)",
			"(光,水,自然)",
			"(光,水,闇)",
			"(光,闇,自然)",
			"(光,水,火)",
			"(光,火,自然)"
	};
	JPanel grid = new JPanel();
	JButton button = new JButton();
	Container container = this.getContentPane();

	public TermFrame(QuizFrame qf) {
		this.setTitle("Term");
		this.setSize(400, 800);
		this.setIconImage(new ImageIcon("image/dm.png").getImage());
		this.setLocationRelativeTo(null);

		grid.setLayout(new GridLayout(10, 1));
		for (int i = 0; i < 10; i++) {
			String s = qf.terms[i];

			JLabel l = new JLabel(s + " " + colors[i]);
			l.setFont(qf.font(25));

			JPanel p = new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.LEFT));
			p.add(qf.toLabel(s, 0.1));
			p.add(l);

			grid.add(p);
		}

		button.setText("Close");
		button.setFont(qf.font(20));
		button.addActionListener(this);

		container.add(grid, BorderLayout.CENTER);
		container.add(button, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}