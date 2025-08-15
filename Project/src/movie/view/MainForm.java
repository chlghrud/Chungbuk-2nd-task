package movie.view;

import javax.swing.JFrame;

import movie.dto.MovieDTO;
import movie.model.MainControl;
import movie.tools.MainPanel;
import movie.tools.MainPanel2;
import movie.tools.MovieTopPanel;
import movie.util.AppContext;
import movie.util.BaseForm;
import movie.util.UIUtil;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class MainForm extends BaseForm {
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton button_2;
	private JButton button_3;
	private JPanel panel_3;
	private MainControl mc = new MainControl();
	private MainPanel[] topInfos = new MainPanel[10];
	private MainPanel2[] starInfos = new MainPanel2[10];
	private int cp, cp2;
	private JPanel panel_4;

	public MainForm() {
		super("메인");
		setBounds(100, 100, 796, 653);
		setDefaultCloseOperation(3);

		panel = new JPanel();
		panel.setBounds(12, 82, 756, 247);
		getContentPane().add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 339, 376, 253);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		button_2 = new JButton("\uC601\uD654 \uC804\uCCB4\uBCF4\uAE30");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(0, 0, 128));
		button_2.setBounds(12, 10, 122, 23);
		panel_1.add(button_2);

		button_3 = new JButton("\uBA39\uAC70\uB9AC \uD0A4\uC624\uC2A4\uD06C");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UIUtil.errMes(AppContext.loginUser == null, "로그인을 해주세요.")) {
					openForm(new LoginForm());
					return;
				}
				openForm(new Kiosk());
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(0, 0, 128));
		button_3.setBounds(146, 10, 122, 23);
		panel_1.add(button_3);

		panel_3 = new JPanel();
		panel_3.setBounds(12, 43, 352, 200);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(392, 339, 376, 253);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		loadData();
		ani();
		A(panel_3);
		B(panel_2);
		
		panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 780, 72);
		getContentPane().add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		MovieTopPanel mtop = new MovieTopPanel(this);
		panel_4.add(mtop);
	}

	private void B(Component com) {
		com.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cp2 = e.getX();
			}
		});
		com.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int d = e.getX() - cp2;
				if(starInfos[0].getX() + d > 0 )
					return;
				if(starInfos[9].getX() + starInfos[9].getWidth() + d < panel_2.getWidth())
					return;
				for (MainPanel2 mainInfo : starInfos) {
					mainInfo.setLocation(mainInfo.getX() + d, mainInfo.getY());
				}
			}
		});
	}

	private void A(Component com) {
		com.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cp = e.getX();
			}
		});
		com.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int d = e.getX() - cp;
				if(topInfos[0].getX() + d > 0 )
					return;
				if(topInfos[9].getX() + topInfos[9].getWidth() + d < panel_3.getWidth())
					return;
				for (MainPanel mainInfo : topInfos) {
					mainInfo.setLocation(mainInfo.getX() + d, mainInfo.getY());
				}
			}
		});
	}

	private void ani() {
		JLabel[] imgs = new JLabel[5];
		Point[] dps = new Point[5];
		String[] adText = mc.getAdImg();
		int[] mnos = new int[] {6, 2, 32, 8, 18};
		int w = panel.getWidth(), h = panel.getHeight();
		
		for (int i = 0; i < imgs.length; i++) {
			JLabel jl = new JLabel();
			dps[i] = new Point(panel.getWidth() * i, 0);
			imgs[i] = jl;
			
			jl.setLocation(dps[i]);
			jl.setSize(w, h);
			int idx = i;
			jl.add(new JLabel() {
				{
					setBounds(0, h / 3, w, h / 3 * 2);
					setForeground(Color.white);
					setText(adText[idx]);
				}
			});
			jl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					openForm(new MovieInfoForm(mnos[idx]));
				}
			});
			jl.setIcon(UIUtil.getImageIcon("/Project/datafiles/advertising/" + (i + 1) + ".jpg", w, h));
			panel.add(jl);
		}

		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(2000);
					do {
						for (int i = 0; i < imgs.length; i++) {
							imgs[i].setLocation(imgs[i].getX() - 20, 0);
						}
						Thread.sleep(10);
					} while (imgs[0].getX() > -w);
					JLabel tump = imgs[0];
					System.arraycopy(imgs, 1, imgs, 0, imgs.length - 1);
					imgs[imgs.length - 1] = tump;
					for (int i = 0; i < imgs.length; i++) {
		                imgs[i].setLocation(dps[i]);
		            }
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private void loadData() {
		MovieDTO[] top = mc.getTop10Image();
		for (int i = 0; i < top.length; i++) {
			topInfos[i] = new MainPanel(i + 1, "/Project/datafiles/movies/"+top[i].m_no+".jpg", top[i].m_name);
			A(topInfos[i]);
			int idx = i;
			topInfos[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					openForm(new MovieInfoForm(top[idx].m_no));
				}
			});
			panel_3.add(topInfos[i]);
		}
		
		MovieDTO[] star = mc.getTop10StarImage();
		for (int i = 0; i < top.length; i++) {
			starInfos[i] = new MainPanel2(i, "/Project/datafiles/movies/"+star[i].m_no+".jpg", star[i].m_name, star[i].star);
			B(starInfos[i]);
			int idx = i;
			starInfos[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					openForm(new MovieInfoForm(star[idx].m_no));
				}
			});
			panel_2.add(starInfos[i]);
		}
	}
}
