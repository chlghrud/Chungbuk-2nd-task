package movie.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import movie.dto.IntString;
import movie.util.AppContext;
import movie.util.DBManager;

public class MyInfoControl {
	public IntString[] getMovieData(){
		String sql = "select m_no, m_name from reservation join movie using(m_no) where u_no = ?;";
		List<IntString> mp = new ArrayList<IntString>();
		try (var con = DBManager.getConnection()) {
			var pre = con.prepareStatement(sql);
			DBManager.setPre(pre, AppContext.loginUser.u_no);
			var rs = pre.executeQuery();
			while (rs.next()) {
				mp.add(new IntString(rs.getInt("m_no"), rs.getString("m_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mp.toArray(new IntString[mp.size()]);
	}
	public IntString[] getFoodData(){
		String sql = "select * from fb join food using(f_no) where u_no = ?;";
		List<IntString> mp = new ArrayList<IntString>();
		try (var con = DBManager.getConnection()) {
			var pre = con.prepareStatement(sql);
			DBManager.setPre(pre, AppContext.loginUser.u_no);
			var rs = pre.executeQuery();
			while (rs.next()) {
				mp.add(new IntString(rs.getInt("f_no"), rs.getString("f_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mp.toArray(new IntString[mp.size()]);
	}
}
