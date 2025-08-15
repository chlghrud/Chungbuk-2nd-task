package movie.tools;

import javax.swing.JPanel;

import movie.util.AppContext;
import movie.util.BaseForm;
import movie.util.UIUtil;
import movie.view.LoginForm;
import movie.view.MyInfo;
import movie.view.SearchForm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class MovieTopPanel extends JPanel {
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JButton button;
	private JButton button_1;

	/**
	 * Create the panel.
	 */
	public MovieTopPanel(BaseForm form) {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		label = new JLabel("");
		label.setBounds(12, 10, 166, 54);
		label.setIcon(UIUtil.getImageIcon("/Project/datafiles/로고1.jpg", label.getWidth(), label.getHeight()));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UIUtil.mes("로그아웃 되었습니다.");
				AppContext.loginUser = null;
			}
		});
		panel.add(label);

		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(200, 10));
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);

		button = new JButton("\uB85C\uADF8\uC778");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(12, 10, 87, 54);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (AppContext.loginUser == null)
					form.openForm(new LoginForm());
				else
					form.openForm(new MyInfo());
			}
		});
		panel_1.add(button);

		button_1 = new JButton("\uC601\uD654\uAC80\uC0C9");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setBounds(111, 10, 87, 54);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				form.openForm(new SearchForm());
			}
		});
		panel_1.add(button_1);

	}

}
