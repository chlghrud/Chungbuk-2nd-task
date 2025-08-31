
package movie.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import movie.dto.IntString;
import movie.model.KioskControl;
import movie.util.BaseForm;
import movie.util.UIUtil;
import movie.view.MyInfo.infoP;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemEvent;

public class Kiosk extends BaseForm {
	private JLabel label;
	private JLabel label_1;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JComboBox comboBox;
	private KioskControl kc = new KioskControl();
	public Kiosk() {
		super("Å°¿À½ºÅ©");
		setBounds(100, 100, 450, 663);
		setDefaultCloseOperation(2);
		
		label_1 = new JLabel("\uD0A4\uC624\uC2A4\uD06C");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 48, 434, 24);
		getContentPane().add(label_1);
		
		label = new JLabel();
		label.setBounds(0, 0, 434, 129);
		label.setIcon(UIUtil.getImageIcon("/Project/datafiles/·Î°í2.jpg", label.getWidth(), label.getHeight()));
		getContentPane().add(label);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 139, 434, 453);
		getContentPane().add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 3, 10, 10));
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				loadData();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uC804\uCCB4", "\uC138\uD2B8O", "\uC138\uD2B8X"}));
		comboBox.setBounds(315, 596, 106, 23);
		getContentPane().add(comboBox);
		loadData();
	}
	private void loadData() {
		panel.removeAll();
		IntString[] ts = kc.getData(comboBox.getSelectedIndex());
		int m = 0;
		for (int i = 0; i < ts.length; i++) {
			infoP info = new infoP(UIUtil.getImageIcon("/Project/datafiles/foods/"+ts[i].no+".jpg", 112, 112), ts[i].t);
			int no = ts[i].no;
			info.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					openForm(new MenuInfo(no));
				}
			});
			panel.add(info);
			m = i;
		}
		for (int i = 0; i < 8 - m; i++) {
			panel.add(new JPanel());
		}
		panel.revalidate();
		panel.repaint();
	}
	class infoP extends JPanel{
		public infoP(ImageIcon img, String name) {
			setLayout(new BorderLayout());
			setPreferredSize(new Dimension(119, 140));
			add(new JLabel(img), "Center");
			add(new JLabel(name, SwingUtilities.CENTER), "South");
		}
	}
}
