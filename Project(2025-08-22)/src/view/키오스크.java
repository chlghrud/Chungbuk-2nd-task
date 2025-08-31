package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import control.BF;

public class 키오스크 extends BF {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					키오스크 frame = new 키오스크();
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
	public 키오스크() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(2);

	}

}
