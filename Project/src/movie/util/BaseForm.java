package movie.util;


import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

public class BaseForm extends JFrame {

	public BaseForm(String title) {
		setTitle(title);
		getContentPane().setLayout(null);
		setIconImage(UIUtil.getImageIcon("/Project/datafiles/·Î°í1.jpg", 60, 30).getImage());
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setLocationRelativeTo(null);
				setVisible(true);
			}
		});
	}

}
