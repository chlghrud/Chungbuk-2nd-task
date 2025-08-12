package movie.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDTO {
	public int u_no;
	public String u_name;
	public String u_id;
	public int u_pw;
	public Date u_birth;
	public int u_price;
	
	public UserDTO(ResultSet rs) throws SQLException {
		u_no = rs.getInt("u_no");
		u_name = rs.getString("u_name");
		u_id = rs.getString("u_id");
		u_pw = rs.getInt("u_pw");
		u_birth = rs.getDate("u_birth");
		u_price = rs.getInt("u_price");
	}
	
}
