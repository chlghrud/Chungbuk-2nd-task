package view;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import view.tools.TopPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

import model.BF;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 메인 extends BF {
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton button;
	private JButton button_1;
	private ArrayList<ArrayList<String>> list1 = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> list2 = new ArrayList<ArrayList<String>>();
	private JPanel panel_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					메인 frame = new 메인();
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
	public 메인() {
		initialize();
		ani();
	}
	private void ani() {
		int w = panel_1.getWidth(), h = panel_1.getHeight();
		JLabel images[] = new JLabel[5];
		Point points[] = new Point[5];
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		Query("select * from movie where m_no in (6, 2, 32, 9, 18) order by field(m_no, 6, 2, 32, 9, 18);", list, null);
		mes("test");
		for (int i = 0; i < 5; i++) {
			points[i] = new Point(w * i, 0);
			var jl = new JLabel();
			jl.setSize(w, h);
			jl.setLocation(points[i]);
			jl.setIcon(getImage("/Project(2025-08-21)/datafiles/advertising/"+(i + 1)+".jpg", w, h));
			int indx = i;
			jl.add(new JLabel() {{setBounds(0, h / 3 * 2 - 40, w, 80); String text = "<html><font size = 6>" + list.get(indx).get(1) +"<br><font size = 4>" + list.get(indx).get(3); setText(text);setForeground(Color.white);}});
			images[i] = jl;
			panel_1.add(images[i]);
		}
		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(2000);
					while (images[0].getX() >= -w) {
						for (JLabel jl : images) {
							jl.setLocation(jl.getX() - 8, 0);
						}
						
						Thread.sleep(5);
					}
					var temp = images[0];
					System.arraycopy(images, 1, images, 0, 4);
					images[4] = temp;
					for (int i = 0; i < points.length; i++) {
						images[i].setLocation(points[i]);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private void initialize() {
		setBounds(100, 100, 730, 577);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("메인");
		
		panel = new JPanel();
		panel.setBounds(0, 0, 717, 86);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(new TopPanel());
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 96, 692, 218);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(8, 321, 339, 207);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		button = new JButton("영화 전체보기");
		button.addActionListener(new ButtonActionListener());
		button.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		button.setBounds(12, 10, 119, 23);
		panel_2.add(button);
		
		button_1 = new JButton("먹거리 키오스크");
		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		button_1.setBounds(143, 10, 136, 23);
		panel_2.add(button_1);
		
		panel_4 = new JPanel();
		panel_4.setBounds(12, 43, 315, 136);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(363, 321, 339, 207);
		getContentPane().add(panel_3);
		A();
	}

	private void A() {
		Query("select m_no, m_name, count(*) as cnt, row_number() over (order by count(*) desc) as r from reservation join movie using(m_no) group by m_no order by cnt desc, m_no limit 10;", list1, null);
		int cnt = 0;
		for (ArrayList<String> i : list1) {
			int w = panel_2.getWidth() /2 - panel_2.getWidth() / 4, h = panel_4.getHeight();
			var jp = new JPanel(new BorderLayout(5, 5));
			jp.setSize(w, h);
			jp.setLocation(cnt++ * w, 20);
			jp.add(new JLabel(getImage("/Project(2025-08-21)/datafiles/movies/"+i.get(0)+".jpg", w - 10, h - 30)));
			jp.add(new JLabel() {{setText(i.get(1));}}, "South");
			panel_4.add(jp);
		}
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
}
