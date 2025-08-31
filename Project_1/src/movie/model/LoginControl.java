package movie.model;

import java.sql.SQLException;

import movie.dto.UserDTO;
import movie.util.DBManager;

public class LoginControl {
	private static LoginControl instance = new LoginControl();

	private LoginControl() {
	}

	public static LoginControl getInstance() {
		return instance;
	}

	public static UserDTO LoginUser(String id, String pw) {
		String sql = "select * from user where u_id = ? and u_pw = ?";
		UserDTO user = null;
		try (var con = DBManager.getConnection(); var pre = con.prepareStatement(sql)) {
			DBManager.setPre(pre, id, pw);
			try (var rs = pre.executeQuery()) {
				if (rs.next()) {
					user = new UserDTO(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
