package control;

import java.time.LocalDate;

public class User {
	public int uno, u_pw, u_price;
	public String uname, uid;
	public LocalDate ubirth;
	public User(int uno, int u_pw, int u_price, String uname, String uid, LocalDate ubirth) {
		super();
		this.uno = uno;
		this.u_pw = u_pw;
		this.u_price = u_price;
		this.uname = uname;
		this.uid = uid;
		this.ubirth = ubirth;
	}
}
