package movie.view;


import movie.dto.UserDTO;
import movie.model.LoginControl;
import movie.util.AppContext;
import movie.util.BaseForm;
import movie.util.UIUtil;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends BaseForm {
	private JPanel panel;
	private JLabel label;
	private JPanel panel_1;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;

	public LoginForm() {
		super("로그인");
		setBounds(100, 100, 468, 242);
		setDefaultCloseOperation(2);
		getContentPane().setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		getContentPane().add(this.panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		label = new JLabel("\uB85C\uADF8\uC778");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		panel.add(this.label, BorderLayout.CENTER);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(this.panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		label_1 = new JLabel("\uC544\uC774\uB514");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label_1.setBounds(7, 10, 93, 28);
		panel_1.add(this.label_1);

		label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label_2.setBounds(8, 59, 93, 28);
		panel_1.add(this.label_2);

		textField = new JTextField();
		textField.setBounds(104, 11, 339, 40);
		panel_1.add(this.textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(105, 56, 339, 40);
		panel_1.add(this.textField_1);

		button = new JButton("\uB85C\uADF8\uC778");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText(), pw = textField_1.getText();
				
				if(UIUtil.errMes(id.isEmpty() || pw.isEmpty(), "입력하지 않은 항목이 있습니다.")) {
					textField.setText("");
					textField_1.setText("-");
					return;
				}
				if(UIUtil.mes(id.equals("admin") && pw.equals("1234"), "관리자님 환영합니다.")) {
//					NavigationManager.open(); 관리자폼 열기
					return;
				}
				UserDTO user = LoginControl.LoginUser(id, pw);
				if(UIUtil.errMes(user == null, "존재하는 회원이 없습니다."))
					return;
				if(UIUtil.mes(user != null, user.u_name + "님 환영합니다.")) {
					AppContext.loginUser = user;
					dispose();
				}
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(364, 115, 76, 23);
		panel_1.add(this.button);
	}
}
