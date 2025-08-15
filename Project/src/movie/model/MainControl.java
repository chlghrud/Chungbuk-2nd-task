package movie.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie.dto.MovieDTO;
import movie.util.DBManager;

public class MainControl {
	
	public String[] getAdImg() {
		java.util.List<String> results = new java.util.ArrayList<>();
		String sql = "SELECT * FROM movie WHERE m_no IN (?, ?, ?, ?, ?) ORDER BY FIELD(m_no, ?, ?, ?, ?, ?)";
	    try (var con = DBManager.getConnection();
	            var pre = con.prepareStatement(sql)) {
	        DBManager.setPre(pre, 6, 2, 32, 8, 18, 6, 2, 32, 8, 18);

	        try (var rs = pre.executeQuery()) {
	            while (rs.next()) {
	            	 results.add("<html><font size = 6>" + rs.getString("m_name") + "</font><br><font size = 5>" + rs.getString("m_dir"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return results.toArray(new String[5]);
	}
	
	public MovieDTO[] getTop10Image() {
		String sql = "select m_no, m_name, count(*) as cnt from reservation join movie using(m_no) group by m_no order by cnt desc, m_no limit 10;";
		List<MovieDTO> ml = new ArrayList<>();
		
		try (var con = DBManager.getConnection();var pre = con.prepareStatement(sql)) {
			var rs = pre.executeQuery();
			for (int i = 1; i <= 10; i++) {
				rs.next();
				ml.add(new MovieDTO(rs.getInt("m_no"), rs.getString("m_name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ml.toArray(new MovieDTO[10]);
	}
	
	public MovieDTO[] getTop10StarImage() {
		String sql = "select m_no, m_name, avg(re_star) as star from review join movie using(m_no) group by m_no order by star desc, m_no;";
		List<MovieDTO> ml = new ArrayList<>();
		
		try (var con = DBManager.getConnection();var pre = con.prepareStatement(sql)) {
			var rs = pre.executeQuery();
			for (int i = 1; i <= 10; i++) {
				rs.next();
				ml.add(new MovieDTO(rs.getInt("m_no"), rs.getString("m_name"), rs.getDouble("star")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ml.toArray(new MovieDTO[10]);
	}
	
}
