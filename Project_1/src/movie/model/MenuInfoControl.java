package movie.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie.dto.IntString;
import movie.util.DBManager;

public class MenuInfoControl {
	public IntString getData(int f_no) {
		String sql = "select * from food where f_no = ?;";
		try (var con = DBManager.getConnection()) {
			var pre = con.prepareStatement(sql);
			DBManager.setPre(pre, f_no);
			var rs = pre.executeQuery();
			rs.next();
			return new IntString(rs.getInt("f_price"), "<html>이름: " + rs.getString("f_name") + "<br>가격: " + String.format("%,d", rs.getInt("f_price")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void PayMent(int f_no, int price) {
		String sql = "update user set u_price = u_price - ?;";
		try (var con = DBManager.getConnection()) {
			var pre = con.prepareStatement(sql);
			DBManager.setPre(pre, price);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
