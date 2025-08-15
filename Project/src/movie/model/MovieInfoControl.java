package movie.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import movie.dto.MovieDTO;
import movie.dto.UserDTO;
import movie.util.DBManager;

public class MovieInfoControl {
		public MovieDTO getInfo(int m_no) {
			String sql = "select m_name, m_dir, l_no, m_startday, m_plot, g_name from movie join genre using(g_no) where m_no = ?;";
			String review = "select u_no ,u_name, re_com from review  join user using(u_no) where m_no = ?";
			String chart = "select \r\n"
					+ "	case\r\n"
					+ "		when timestampdiff(year, u_birth, curdate()) >= 19 then 4\r\n"
					+ "        when timestampdiff(year, u_birth, curdate()) >= 13 then 3\r\n"
					+ "        when timestampdiff(year, u_birth, curdate()) >= 5 then 2\r\n"
					+ "        else 1\r\n"
					+ "        end as age,\r\n"
					+ "        count(*) as cnt \r\n"
					+ "from reservation join user using(u_no) where m_no = ? group by age ;";
			
			List<UserDTO> users = new ArrayList<>();
			int[] chartdate = new int[] {0, 0, 0, 0};
			try (var con = DBManager.getConnection();) {

				try(var pre = con.prepareStatement(review);){
					DBManager.setPre(pre, m_no);var rs = pre.executeQuery();
					while (rs.next()) {
						users.add(new UserDTO(rs.getInt("u_no") ,rs.getString("u_name"), rs.getString("re_com")));
					}
				}
				try(var pre = con.prepareStatement(chart);){
					DBManager.setPre(pre, m_no);var rs = pre.executeQuery();
					while (rs.next()) {
						chartdate[rs.getInt("age") - 1] = rs.getInt("cnt");
					}
				}
				try(var pre = con.prepareStatement(sql);){
					DBManager.setPre(pre, m_no);var rs = pre.executeQuery();
					rs.next();
					return new MovieDTO(m_no, rs.getString("m_name"), rs.getInt("l_no"), rs.getDate("m_startday"), rs.getString("m_plot"), users.toArray(new UserDTO[users.size()]), chartdate, rs.getString("g_name"), rs.getString("m_dir"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
}
