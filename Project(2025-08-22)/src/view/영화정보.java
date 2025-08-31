package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import control.BF;

public class 영화정보 extends BF {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					영화정보 frame = new 영화정보(1);
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
	public 영화정보(int m_no) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(2);

	}

}
