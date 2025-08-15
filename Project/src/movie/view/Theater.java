package movie.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import movie.util.BaseForm;
import movie.util.DBManager;
import movie.util.UIUtil;

import java.awt.GridLayout;
import java.sql.SQLException;

public class Theater extends BaseForm {

	private JPanel[][] map = new JPanel[9][9];
	private int[][] des = new int[][] { { 2, 1, 1, 1, 1, 1 }, {2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 4, 1, 4, 4}, {2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 2,  1, 2, 2}, {2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 1, 2}, {2, 2, 1, 1, 1, 1, 2, 2, 2, 2, 3, 2, 3, 3}, {2, 2, 1, 1, 1, 1, 2, 2, 3, 3, 2, 3}};
	private int sno;

	public Theater(int sno) {
		super("상영관배치도");
		this.sno = sno;
		setBounds(100, 100, 638, 562);
		setDefaultCloseOperation(2);
		getContentPane().setLayout(new GridLayout(9, 9, 0, 0));
		setP();
	}

	private void setP() {
		try {
			var con = DBManager.getConnection();
			var pre = con.prepareStatement("select * from srm");
			var rs = pre.executeQuery();
			for (int i = 0; rs.next(); i++) {
				int p = rs.getInt("srm_type");
				JPanel jp = new JPanel();
				jp.setBackground(p == 0 ? Color.white : p == 1 ? Color.darkGray : Color.blue);
				jp.setBorder(new LineBorder(Color.black));
				map[i / 9][i % 9] = jp;
				getContentPane().add(jp);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		map[8][0].setBackground(Color.green);
		new Thread(() -> {
			for (int i = 0; i < 2; i++) {
				int idy = 8, idx = 0;
				for (int j = 0; j < des[sno].length; j++) {
					try {
						Thread.sleep(200);
						if (des[sno][j] == 1)
							idy--;
						if (des[sno][j] == 2)
							idx++;
						if (des[sno][j] == 3)
							idy++;
						if (des[sno][j] == 4)
							idx--;
						if(i == 1) {
							for (int k = 0; k < 5; k++) {
								Thread.sleep(50);
								if(k%2 == 0)
									map[idy][idx].setBackground(Color.red);
								else
									map[idy][idx].setBackground(Color.white);
							}
						}else {
							map[idy][idx].setBackground(Color.red);
						}
					} catch (InterruptedException e) {
					}
				}
				
			}
			UIUtil.mes(sno + 1 + "관에 도착했습니다.");
		}).start();
		
	}

}
