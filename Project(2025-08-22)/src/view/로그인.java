package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import control.BF;
import control.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class 로그인 extends BF {
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private ArrayList<ArrayList<String>> list = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					로그인 frame = new 로그인();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public 로그인() {

		initialize();
	}
	private void initialize() {
		setBounds(100, 100, 582, 300);
		setDefaultCloseOperation(2);
		
		label = new JLabel(" 로그인");
		label.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		label.setBounds(0, 0, 566, 67);
		getContentPane().add(label);
		
		label_1 = new JLabel("아이디");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label_1.setBounds(10, 77, 93, 34);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("비밀번호");
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label_2.setBounds(10, 133, 93, 34);
		getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(115, 77, 439, 34);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 133, 439, 34);
		getContentPane().add(textField_1);
		
		button = new JButton("로그인");
		button.addActionListener(new ButtonActionListener());
		button.setBounds(441, 204, 97, 23);
		getContentPane().add(button);
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = textField.getText(), pw = textField_1.getText();
			if(errmes(id.isBlank() || pw.isBlank(), "입력하지 않은 항목이있습니다."))
				return;
			if(mes(id.equals("admin") && pw.equals("1234"), "관리자님 환영합니다.")) {
				go(new 관리자검색());
				return;
			}
			Query("select * from user where u_id = ? and u_pw = ?", list, id, pw);
			if(errmes(list.size() == 0, "존재하는 회원이 없습니다.")) {
				textField.setText("");
				textField_1.setText("");
			}else if(mes(list.size() == 1, list.get(0).get(1) + "님 환영합니다.")) {
				var rs = list.get(0);
				loginUser = new User(intnum(rs.get(0)), intnum(rs.get(3)), intnum(rs.get(5)), rs.get(1), rs.get(2), LocalDate.parse(rs.get(4)));
				dispose();
			}
			
		}
	}
}
