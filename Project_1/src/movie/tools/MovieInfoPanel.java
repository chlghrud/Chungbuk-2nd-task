package movie.tools;

import java.awt.Dimension;

import javax.swing.JPanel;

import movie.dto.UserDTO;
import movie.util.UIUtil;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MovieInfoPanel extends JPanel {
	private JLabel label;
	private JLabel label_1;

	/**
	 * Create the panel.
	 */
	public MovieInfoPanel(int i, UserDTO u) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 73 * i, 365, 63);
		setLayout(new BorderLayout(0, 0));
		
		label = new JLabel("");
		add(label, BorderLayout.WEST);
		int w = getWidth(), h = getHeight();
		label.setPreferredSize(new Dimension(w/ 5, h));
		label.setIcon(UIUtil.getImageIcon("/Project/datafiles/user/"+u.u_no+".jpg", w/5, h));
		
		label_1 = new JLabel("<html><font size = 2>" + u.u_name + "</font><br><font size = 1>" + u.recom);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		add(label_1, BorderLayout.CENTER);
		
	}

}
