package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import control.BF;

public class 내정보 extends BF {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					내정보 frame = new 내정보();
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
	public 내정보() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(2);

	}

}
