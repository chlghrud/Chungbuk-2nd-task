package movie.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class DBManager {
	private static final String URL = "jdbc:mysql://localhost:3306/moviedb?serverTimezone=UTC&allowLoadLocalInfil=true";
	private static final String USER = "user";
	private static final String PASSWORD = "1234";
	
	public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	public static void setPre(PreparedStatement pre, Object...objs) {
		try {
			int i = 1;
			for (Object obj : objs) {
				pre.setObject(i++, obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
