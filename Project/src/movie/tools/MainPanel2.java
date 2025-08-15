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

public class MainPanel2 extends JPanel {
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Create the panel.
	 */
	public MainPanel2(int i, String path, String name, double star) {
		setBounds(149 * i, 5, 120, 229);
		setLayout(null);
		
		label = new JLabel(name);
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 12));
		label.setBounds(0, 210, 115, 15);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(0, 50, 115, 150);
		label_1.setIcon(UIUtil.getImageIcon(path, label_1.getWidth(), label_1.getHeight()));
		add(label_1);
		
		label_2 = new JLabel("<html> <font color = 'orange'>¡Ú</font>" + String.format("%.1f", star));
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 30));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(0, 0, 115, 41);
		add(label_2);
		
		
	}

}
