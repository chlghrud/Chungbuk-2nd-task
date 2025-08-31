package exe;

import java.awt.Color;

import javax.swing.UIManager;

import view.메인;

public class Play {
	public static void main(String[] args) {
		UIManager.put("Panel.background", Color.white);
		UIManager.put("OptionPane.background", Color.white);
		UIManager.put("Button.background", new Color(0, 0, 128));
		UIManager.put("Button.foreground", Color.white);
		new 메인().setVisible(true);
	}
}
