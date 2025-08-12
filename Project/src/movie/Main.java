package movie;

import movie.util.UIUtil;
import movie.view.LoginForm;

public class Main {
	public static void main(String[] args) {
		UIUtil.initStyle();
		new LoginForm();
	}
}
