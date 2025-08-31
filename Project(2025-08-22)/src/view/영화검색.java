package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import control.BF;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class 영화검색 extends BF {
	private JLabel label;
	private JTextField textField;
	private JButton button;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JPanel panel;
	private TopPanel top;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					영화검색 frame = new 영화검색();
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
	public 영화검색() {

		initialize();
	}
	private void initialize() {
		setTitle("영화 검색");
		setBounds(100, 100, 992, 512);
		setDefaultCloseOperation(2);
		
		label = new JLabel("검색창");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(12, 96, 78, 27);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(90, 96, 241, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		button = new JButton("검색");
		button.setBounds(342, 96, 97, 27);
		getContentPane().add(button);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"전체", "예매순", "평점순"}));
		comboBox.setBounds(451, 96, 86, 27);
		getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(542, 96, 86, 27);
		var list = new ArrayList<ArrayList<String>>();
		Query("select * from genre", list, null);
		for (ArrayList<String> l : list) {
			comboBox_1.addItem(l.get(1));
		}
		getContentPane().add(comboBox_1);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 976, 87);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		top = new TopPanel(this);
		panel.add(top);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 133, 954, 330);
		getContentPane().add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(12, 10, 220, 243);
		panel_1.add(panel_2);
	}
	@Override
	public void update() {
		top.ChangeUI();
	}
}
