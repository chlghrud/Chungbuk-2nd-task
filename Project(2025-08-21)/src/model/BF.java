package model;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class BF extends JFrame  {

	public static final String URL = "jdbc:mysql://localhost:3306/moviedb?serverTimezone=Asia/Seoul";
	public static final String ID = "root";
	public static final String PW = "1234";
	public BF before;

	public BF() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setIconImage(getImage("/Project(2025-08-21)/datafiles/로고1.jpg", 60, 30).getImage());

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				before.setVisible(true);
			}
		});

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				update();
			}

			@Override
			public void componentResized(ComponentEvent e) {
				setLocationRelativeTo(null);
			}
		});
	}

	public void go(BF next) {
		next.before = this;
		setVisible(false);
		next.setVisible(true);
	}

	public static void Update(String sql, Object... objects) {
		try (var con = DriverManager.getConnection(URL, ID, PW);
				var pre = con.prepareStatement(sql)) {
			for (int i = 0; i < objects.length; i++) {
				pre.setObject(i + 1, objects[i]);
			}
			pre.executeUpdate();
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
		}
	}

	public static void Query(String sql, ArrayList<ArrayList<String>> list, Object... objects) {
		try (var con = DriverManager.getConnection(URL, ID, PW); var pre = con.prepareStatement(sql);) {
			if(objects != null) {
				for (int i = 0; i < objects.length; i++) {
					pre.setObject(i + 1, objects[i]);
				}
			}

			list.clear();

			var rs = pre.executeQuery();
			var rsm = rs.getMetaData();

			while (rs.next()) {
				ArrayList row = new ArrayList<>();
				for (int i = 1; i < rsm.getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				list.add(row);
			}

		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
		}
	}

	public static Integer intnum(String txt) {
		return Integer.parseInt(txt);
	}

	public static ImageIcon getImage(String path, int w, int h) {
		return new ImageIcon(new ImageIcon(path.replace("/Project(2025-08-21)", ".")).getImage().getScaledInstance(w, h,
				Image.SCALE_SMOOTH));
	}

	public static void mes(String t) {
		 UIManager.put("Button.background", null);
         UIManager.put("Button.foreground", null);
		JOptionPane.showConfirmDialog(null, t, "?���?", 0);
		UIManager.put("Button.background", new Color(0, 0, 128));
		UIManager.put("Button.foreground", Color.white);
	}

	public static boolean mes(boolean b, String t) {
		if (b)
			JOptionPane.showConfirmDialog(null, t, "?���?", JOptionPane.INFORMATION_MESSAGE);
		return b;
	}

	public static void errmes(String t) {
		JOptionPane.showConfirmDialog(null, t, "경고", JOptionPane.ERROR_MESSAGE);
	}

	public static boolean errmes(boolean b, String t) {
		if (b)
			JOptionPane.showConfirmDialog(null, t, "경고", JOptionPane.ERROR_MESSAGE);
		return b;
	}

	public void action() {

	}

	public void update() {

	}
}
