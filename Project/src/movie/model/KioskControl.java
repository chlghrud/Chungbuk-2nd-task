package movie.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie.dto.IntString;
import movie.util.AppContext;
import movie.util.DBManager;

public class KioskControl {
	public IntString[] getData(int idx) {
		String sql = "select * from food where true" + (idx == 0? "" : " and f_set = "+(idx == 1 ? 1 : 0)+";");
		List<IntString> mp = new ArrayList<IntString>();
		try (var con = DBManager.getConnection()) {
			var pre = con.prepareStatement(sql);
			var rs = pre.executeQuery();
			while (rs.next()) {
				mp.add(new IntString(rs.getInt("f_no"), "<html><div style='text-align: center;'>" + rs.getString("f_name") + "<br>" + rs.getString("f_cc") + "<br>" + String.format("%,d", rs.getInt("f_price"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mp.toArray(new IntString[mp.size()]);
	}
}
