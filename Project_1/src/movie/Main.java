package movie;

import movie.util.UIUtil;
import movie.view.LoginForm;
import movie.view.MainForm;

public class Main {
	public static void main(String[] args) {
		UIUtil.initStyle();
		new MainForm().setVisible(true);;
	}
}
