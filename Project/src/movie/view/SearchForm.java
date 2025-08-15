package movie.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import movie.model.SearchControl;
import movie.tools.MovieTopPanel;
import movie.util.BaseForm;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;

public class SearchForm extends BaseForm {
	private final JPanel panel = new JPanel();
	private JLabel label;
	private JTextField textField;
	private JButton button;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private SearchControl sc = new SearchControl();
	private JScrollPane scrollPane;
	private JPanel panel_1;

	public SearchForm() {
		super("¿µÈ­ °Ë»ö");
		setBounds(100, 100, 892, 395);
		setDefaultCloseOperation(2);
		panel.setBounds(0, 0, 876, 68);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(new MovieTopPanel(this));
		
		label = new JLabel("\uAC80\uC0C9\uCC3D");
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label.setBounds(10, 78, 61, 25);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(72, 78, 254, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		button = new JButton("\uAC80\uC0C9");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(329, 78, 87, 21);
		getContentPane().add(button);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uCCB4", "\uC608\uB9E4\uC21C", "\uD3C9\uC810\uC21C"}));
		comboBox.setBounds(418, 77, 94, 23);
		getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox();
		
		comboBox_1.setBounds(514, 76, 94, 23);
		comboBox_1.setModel(new DefaultComboBoxModel(sc.getComboBoxItem()));
		getContentPane().add(comboBox_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 104, 852, 242);
		getContentPane().add(scrollPane);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

	}
}
