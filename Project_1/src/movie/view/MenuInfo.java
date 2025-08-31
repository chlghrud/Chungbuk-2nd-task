package movie.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import movie.dto.IntString;
import movie.model.MenuInfoControl;
import movie.util.AppContext;
import movie.util.BaseForm;
import movie.util.UIUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuInfo extends BaseForm {
	private JLabel label;
	private JLabel label_2;
	private JButton button;
	private JButton button_1;
	private JLabel label_3;
	private JButton button_2;
	private JButton button_3;
	private int count = 1;
	private MenuInfoControl mc = new MenuInfoControl();
	private int f_no;
	private int price;


	public MenuInfo(int f_no) {
		super("∏ﬁ¥∫¡§∫∏");
		this.f_no = f_no;
		setBounds(100, 100, 450, 584);
		setDefaultCloseOperation(2);
		
		label = new JLabel("New label");
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		label.setBounds(12, 10, 410, 65);
		getContentPane().add(label);
		
		label_2 = new JLabel("");
		label_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_2.setBounds(12, 85, 410, 307);
		label_2.setIcon(UIUtil.getImageIcon("/Project/datafiles/foods/"+f_no+".jpg", label_2.getWidth(), label_2.getHeight()));
		getContentPane().add(label_2);
		
		button = new JButton("-");
		button.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if(count == 1)
					return;
				count--;
				label_3.setText(count + "");
			}
		});
		button.setBackground(new Color(0, 0, 128));
		button.setForeground(new Color(255, 255, 255));
		button.setBounds(12, 402, 39, 57);
		getContentPane().add(button);
		
		button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count == 10)
					return;
				count++;
				label_3.setText(count + "");
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setBounds(375, 402, 47, 57);
		getContentPane().add(button_1);
		
		label_3 = new JLabel("1");
		label_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 16));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(63, 402, 309, 57);
		getContentPane().add(label_3);
		
		button_2 = new JButton("\uCDE8\uC18C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(255, 0, 0));
		button_2.setBounds(12, 469, 198, 64);
		getContentPane().add(button_2);
		
		button_3 = new JButton("\uAD6C\uB9E4");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				price = price * count;
				if(JOptionPane.showConfirmDialog(null, "∞·¡¶«œ±‚º√Ω¿¥œ±Ó?", "∞ø¡¶", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if(UIUtil.errMes(AppContext.loginUser.u_price < price, "¿‹æ◊¿Ã ∫Œ¡∑«’¥œ¥Ÿ."))
						return;
					mc.PayMent(f_no, price);
				}
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(0, 0, 128));
		button_3.setBounds(224, 469, 198, 64);
		getContentPane().add(button_3);
		
		loadData();
		
	}


	private void loadData() {
		IntString st =mc.getData(f_no);
		price = st.no;
		label.setText(st.t);
	}

}
