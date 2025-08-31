package movie.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import movie.util.DBManager;

public class SearchControl {
	public String[] getComboBoxItem() {
		List<String> items = new  ArrayList<String>();
		String sql = "select * from genre;";
		try (var con = DBManager.getConnection();
				var pre = con.prepareStatement(sql);
				var rs = pre.executeQuery()) {
			items.add("ÀüÃ¼");
			while (rs.next()) {
				items.add(rs.getString("g_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return items.toArray(new String[items.size()]);
	}
}
