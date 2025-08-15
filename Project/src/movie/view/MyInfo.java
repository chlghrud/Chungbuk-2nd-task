package movie.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import movie.dto.IntString;
import movie.model.MyInfoControl;
import movie.util.AppContext;
import movie.util.BaseForm;
import movie.util.UIUtil;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyInfo extends BaseForm {
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private JPanel panel_2;
	private MyInfoControl mic = new MyInfoControl();
	public MyInfo() {
		super("³»Á¤º¸");
		setBounds(100, 100, 687, 436);
		setDefaultCloseOperation(2);
		
		label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setBounds(12, 10, 94, 90);
		label.setIcon(UIUtil.getImageIcon("/Project/datafiles/user/"+AppContext.loginUser.u_no+".jpg", label.getWidth(), label.getHeight()));
		getContentPane().add(label);
		
		label_1 = new JLabel(AppContext.loginUser.u_id);
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		label_1.setBounds(113, 10, 107, 27);
		getContentPane().add(label_1);
		
		label_2 = new JLabel(AppContext.loginUser.u_name);
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		label_2.setBounds(113, 47, 107, 27);
		getContentPane().add(label_2);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 110, 647, 277);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(1, 3, 318, 270);
		panel.add(scrollPane);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(322, 3, 322, 270);
		panel.add(scrollPane_1);
		
		panel_2 = new JPanel();
		scrollPane_1.setViewportView(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		loadData();
	}
	private void loadData() {
		IntString ts[] = mic.getMovieData();
		int m = 0;
		for (int i = 0; i < ts.length; i++) {
			infoP info = new infoP(UIUtil.getImageIcon("/Project/datafiles/movies/"+ts[i].no+".jpg", 112, 112), ts[i].t);
			panel_2.add(info);
			int mno = ts[i].no;
			info.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					openForm(new MovieInfoForm(mno));
				}
			});
			m = i;
		}
		for (int i = 0; i < 5 - m; i++) {
			panel_2.add(new JPanel());
		}
		IntString ts1[] = mic.getFoodData();
		for (int i = 0; i < ts1.length; i++) {
			infoP info = new infoP(UIUtil.getImageIcon("/Project/datafiles/foods/"+ts1[i].no+".jpg", 112, 112), ts1[i].t);
			panel_1.add(info);
			m = i;
		}
		for (int i = 0; i < 5 - m; i++) {
			panel_1.add(new JPanel());
		}
	}
	class infoP extends JPanel{
		public infoP(ImageIcon img, String name) {
			setLayout(new BorderLayout());
			setPreferredSize(new Dimension(112, 122));
			add(new JLabel(img), "Center");
			add(new JLabel(name, SwingUtilities.CENTER), "South");
		}
	}
}
