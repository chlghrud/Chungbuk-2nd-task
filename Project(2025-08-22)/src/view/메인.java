package view;

import java.awt.EventQueue;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;

import control.BF;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class 메인 extends BF {
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JButton button;
	private JButton button_1;
	private ArrayList<ArrayList<String>> list1 = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> list2 = new ArrayList<ArrayList<String>>();
	private ArrayList<JPanel> aList = new ArrayList<JPanel>();
	private ArrayList<JPanel> bList = new ArrayList<JPanel>();
	private int cx;
	private TopPanel top;

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
		for (int i = 0; i < 5; i++) {
			points[i] = new Point(w * i, 0);
			var jl = new JLabel();
			jl.setSize(w, h);
			jl.setLocation(points[i]);
			jl.setLayout(new BorderLayout());
			jl.setIcon(getImage("/Project(2025-08-22)/datafiles/advertising/" + (i + 1) + ".jpg", w, h));
			int indx = i;
			jl.add(new JLabel() {
				{
					String text = "<html><font size = 6><br><br>" + list.get(indx).get(1) + "<br><font size = 4>"
							+ list.get(indx).get(3);
					setText(text);
					setForeground(Color.white);
				}
			}, "Center");
			jl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					go(new 영화정보(intnum(list.get(indx).get(0))));
				}
			});
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
		top = new TopPanel(this);
		panel.add(top);

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
		button.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		button.setBounds(12, 10, 119, 23);
		panel_2.add(button);

		button_1 = new JButton("먹거리 키오스크");
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		button_1.setBounds(143, 10, 136, 23);
		panel_2.add(button_1);

		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(363, 321, 339, 207);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		A();
		B();
	}
	
	@Override
	public void update() {
		top.ChangeUI();
	}
	private void ALisner(Component com) {
		com.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cx = e.getX();
			}
		});
		com.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int d = e.getX() - cx;
				var last = aList.get(aList.size() - 1);
				if(aList.get(0).getX() + d > 12 )
					return;
				if(last.getX() + last.getWidth() + d < panel_2.getWidth())
					return;
				for (var a : aList) {
					a.setLocation(a.getX() + d, a.getY());
				}
			}
		});
	}
	
	
	private void BLisner(Component com) {
		com.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cx = e.getX();
			}
		});
		com.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int d = e.getX() - cx;
				var last = bList.get(bList.size() - 1);
				if(bList.get(0).getX() + d > 12 )
					return;
				if(last.getX() + last.getWidth() + d < panel_3.getWidth())
					return;
				for (var a : bList) {
					a.setLocation(a.getX() + d, a.getY());
				}
			}
		});
	}
	private void B() {
		Query("select m_no, m_name,round(avg(re_star), 1) as star from review  join movie using(m_no) group by m_no order by star desc, m_no;", list2, null);
		for (ArrayList<String> i : list2) {
			var b = getStarInfoPanel(i.get(2), i.get(1), i.get(0), list2.indexOf(i));
			bList.add(b);
			BLisner(b);
			panel_3.add(b);
		}
	}

	private void A() {
		Query("select m_no, m_name, count(*) as cnt, row_number() over (order by count(*) desc) as r from reservation join movie using(m_no) group by m_no order by cnt desc, m_no limit 10;",
				list1, null);
		for (ArrayList<String> i : list1) {
			var a = getInfoPanel(i.get(1), intnum(i.get(3)), i.get(0));
			aList.add(a);
			ALisner(a);
			panel_2.add(a);
		}
	}
	
	private JPanel getStarInfoPanel(String star, String name, String m_no, int i) {
		var panel_5 = new JPanel();
		panel_5.setBounds(12 + (120 +12) * i, 10, 120, 187);
		panel_5.setLayout(null);

		var label_3 = new JLabel(name);
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_3.setBounds(0, 160, 120, 27);
		panel_5.add(label_3);

		var label_4 = new JLabel();
		label_4.setBounds(0, 0, 120, 27);
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label_4.setText("<html><font color = 'yellow' size = 6>★</font>" + star);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_5.add(label_4);

		var label_5 = new JLabel("");
		label_5.setBounds(0, 27, 120, 135);
		label_5.setIcon(getImage("/Project(2025-08-22)/datafiles/movies/"+m_no+".jpg", label_5.getWidth(), label_5.getHeight()));
		panel_5.add(label_5);
		
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				go(new 영화정보(intnum(m_no)));
			}
		});
		return panel_5;

	}

	private JPanel getInfoPanel(String name, int rank, String m_no) {
		var panel_4 = new JPanel();
		panel_4.setBounds(12 + (107 + 12) * (rank - 1), 43, 107, 154);
		panel_4.setLayout(null);

		var label = new JLabel(name);
		label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label.setBounds(0, 121, 107, 33);
		panel_4.add(label);

		var label_1 = new JLabel("");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(0, 0, 107, 121);
		label_1.setIcon(getImage("/Project(2025-08-22)/datafiles/movies/" + m_no + ".jpg", label_1.getWidth(),
				label_1.getHeight()));
		panel_4.add(label_1);

		var label_2 = new JLabel(rank + "");
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 35));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 0, 46, 39);
		panel_4.add(label_2);
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				go(new 영화정보(intnum(m_no)));
			}
		});
		return panel_4;
	}
	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(errmes(loginUser == null, "로그인을 해주세요"))
				go(new 로그인());
			else
				go(new 키오스크());
		}
	}
}
