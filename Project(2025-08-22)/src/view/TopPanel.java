package view;

import javax.swing.JPanel;

import control.BF;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TopPanel extends JPanel {
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JButton button;
	private JButton button_1;
	private BF now;

	/**
	 * Create the panel.
	 */
	public TopPanel(BF now) {

		this.now = now;
		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		add(panel, BorderLayout.WEST);
		panel.setLayout(null);

		label = new JLabel("");
		label.addMouseListener(new LabelMouseListener());
		label.setBounds(12, 10, 176, 71);
		label.setIcon(BF.getImage("/Project(2025-08-22)/datafiles/로고1.jpg", label.getWidth(), label.getHeight()));
		panel.add(label);

		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(200, 10));
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(null);

		button = new JButton("로그인");
		button.addActionListener(new ButtonActionListener());
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(12, 10, 84, 45);
		panel_1.add(button);

		button_1 = new JButton("영화 검색");
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setBounds(97, 10, 91, 45);
		panel_1.add(button_1);
	}

	public void ChangeUI() {
		button.setText(BF.loginUser == null ? "로그인" : "내정보");
	}
	
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (BF.loginUser == null)
				now.go(new 로그인());
			else
				now.go(new 내정보());
		}
	}
	private class LabelMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(BF.mes(BF.loginUser != null, "로그아웃 되었습니다.")) {
				BF.loginUser = null;
				ChangeUI();
			}
		}
	}
	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			now.go(new 영화검색());
		}
	}
}
