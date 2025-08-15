package movie.util;


import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class BaseForm extends JFrame {
	public BaseForm befForm;
	public BaseForm(String title) {
		setTitle(title);
		getContentPane().setLayout(null);
		setIconImage(UIUtil.getImageIcon("/Project/datafiles/·Î°í1.jpg", 60, 30).getImage());
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setLocationRelativeTo(null);
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				if(befForm != null)
					befForm.setVisible(true);
			}
		});
	}
	public void openForm(BaseForm now) {
		this.setVisible(false);
		now.befForm = this;
		now.setVisible(true);
	}
}
