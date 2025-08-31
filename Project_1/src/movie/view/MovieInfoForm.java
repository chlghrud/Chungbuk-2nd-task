package movie.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import movie.dto.MovieDTO;
import movie.dto.UserDTO;
import movie.model.MovieInfoControl;
import movie.tools.MovieInfoPanel;
import movie.tools.MovieTopPanel;
import movie.util.AppContext;
import movie.util.BaseForm;
import movie.util.UIUtil;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class MovieInfoForm extends BaseForm {
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JButton button;
	private JScrollPane scrollPane_1;
	private JLabel label_6;
	private JPanel panel_2;
	private JScrollPane scrollPane_2;
	private JPanel panel_3;
	private MovieInfoControl mc = new MovieInfoControl();
	private int m_no;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private double[] chart;
	private int start = -90;
	private Color[] c = {Color.green, Color.yellow, Color.blue, Color.red};
	boolean is19 = false;
	private MovieTopPanel tp;

	//747 416
	public MovieInfoForm(int m_no) {
		super("øµ»≠ ¡§∫∏");
		this.m_no = m_no;
		setBounds(100, 100, 765, 518);
		setDefaultCloseOperation(2);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 749, 68);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		tp = new MovieTopPanel(this);
		panel.add(tp);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 66, 749, 407);
		getContentPane().add(scrollPane);
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(731, 400 * 2));
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);
		
		label_1 = new JLabel("");
		label_1.setBounds(12, 10, 43, 34);
		panel_1.add(label_1);
		
		label = new JLabel("");
		label.setBounds(12, 10, 177, 296);
		panel_1.add(label);
		
		label_2 = new JLabel("New label");
		label_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 23));
		label_2.setBounds(201, 10, 518, 44);
		panel_1.add(label_2);
		
		label_3 = new JLabel("New label");
		label_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		label_3.setBounds(201, 65, 518, 34);
		panel_1.add(label_3);
		
		label_4 = new JLabel("New label");
		label_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		label_4.setBounds(200, 118, 519, 34);
		panel_1.add(label_4);
		
		label_5 = new JLabel("New label");
		label_5.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 15));
		label_5.setBounds(201, 170, 518, 34);
		panel_1.add(label_5);
		
		button = new JButton("\uC608\uB9E4\uD558\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UIUtil.errMes(AppContext.loginUser == null, "∑Œ±◊¿Œ¿ª «ÿ¡÷ººø‰.")) {
					openForm(new LoginForm());
					return;
				}
				if(UIUtil.errMes(is19 && AppContext.isUnder19(AppContext.loginUser.u_birth), "πÃº∫≥‚¿⁄¥¬ Ω√√ª ±›¡ˆ¿‘¥œ¥Ÿ."))
					return;
			}
		});
		button.setBackground(new Color(0, 0, 128));
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		button.setBounds(202, 241, 97, 23);
		panel_1.add(button);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 326, 709, 204);
		panel_1.add(scrollPane_1);
		
		label_6 = new JLabel("");
		label_6.setBackground(new Color(255, 255, 255));
		label_6.setOpaque(true);
		label_6.setVerticalAlignment(SwingConstants.TOP);
		label_6.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		scrollPane_1.setViewportView(label_6);
		
		panel_2 = new JPanel() {

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (int i = 0; i < chart.length; i++) {
					g.setColor(c[i]);
					g.fillArc(10, 10, getWidth()/2, getHeight()/2, start, (int)chart[i] );
					start += chart[i];
				}
			}
		};
		panel_2.setBounds(26, 540, 306, 219);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		label_7 = new JLabel("New label");
		label_7.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_7.setBounds(174, 21, 120, 21);
		panel_2.add(label_7);
		
		label_8 = new JLabel("New label");
		label_8.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_8.setBounds(174, 52, 120, 21);
		panel_2.add(label_8);
		
		label_9 = new JLabel("New label");
		label_9.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_9.setBounds(174, 83, 120, 21);
		panel_2.add(label_9);
		
		label_10 = new JLabel("New label");
		label_10.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		label_10.setBounds(174, 114, 120, 21);
		panel_2.add(label_10);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(344, 540, 391, 219);
		panel_1.add(scrollPane_2);
		
		panel_3 = new JPanel();
		scrollPane_2.setViewportView(panel_3);
		panel_3.setLayout(null);
		loadData();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				tp.ChangeUI();
			}
		});
	}
	private void loadData() {
		MovieDTO movie = mc.getInfo(m_no);
		label.setIcon(UIUtil.getImageIcon("/Project/datafiles/movies/"+m_no+".jpg", label.getWidth(), label.getHeight()));
		label_1.setIcon(UIUtil.getImageIcon("/Project/datafiles/limits/"+movie.l_no+".png", label_1.getWidth(), label_1.getHeight()));
		label_2.setText("¡¶∏Ò: " + movie.m_name);
		label_3.setText("∞®µ∂: " + movie.m_dir);
		label_4.setText("¿Â∏£: " + movie.g_name);
		label_5.setText("∞≥∫¿¿œ: " + movie.m_startdat.toString());
		String htmlText = movie.m_plot.replace("\n", "<br>");
		label_6.setText("<html>" + htmlText + "</html>");
		is19 = movie.l_no == 4;
		
		int max = 0;
		for (int i = 0; i < movie.re_coms.length; i++) {
			panel_3.add(new MovieInfoPanel(i, movie.re_coms[i]));
			max = i;
		}
		panel_3.setPreferredSize(new Dimension(365, (max + 1) * 75));
		setchart(movie.chartData);
	}

	private void setchart(int[] chartData) {
		int total = Arrays.stream(chartData).sum();
 		if(total == 0)
			return;
		chart = Arrays.stream(chartData).mapToDouble(n -> ((double)n / total) * 360.0).toArray();
		
		JLabel[] ls = { label_10, label_9, label_8, label_7};
		String[] ca = "º∫¿Œ,√ªº“≥‚,æÓ∏∞¿Ã,¿Øæ∆".split(",");
		for (int i = 0; i < chart.length; i++) {
			int p = (int) Math.round((double)chartData[i] / total * 100);
			String t = String.format("<html>°·<font color = 'black'>%-7s %d%%", ca[i],p);
			ls[i].setForeground(c[i]);
			ls[i].setText(t);
		}
		panel_2.repaint();
	}
}
