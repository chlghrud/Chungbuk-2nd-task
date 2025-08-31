package movie.tools;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import movie.util.UIUtil;

import java.awt.Color;

public class MainPanel extends JPanel {
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Create the panel.
	 */
	public MainPanel(int rank, String path, String name) {
		setBounds(149 * (rank - 1), 5, 139, 180);
		setLayout(null);
		
		label_2 = new JLabel(rank + "");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 40));
		label_2.setBounds(0, 10, 57, 37);
		add(label_2);
		
		label = new JLabel(name);
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		label.setBounds(0, 165, 139, 15);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(0, 0, 139, 165);
		label_1.setIcon(UIUtil.getImageIcon(path, label_1.getWidth(), label_1.getHeight()));
		add(label_1);
	}

}
