package movie.dto;

import java.sql.Date;

public class MovieDTO {
	public int m_no;
	public String m_name;
	public int l_no;
	public Date m_startdat;
	public String m_plot;
	public String m_dir;
	
	public UserDTO[] re_coms;
	public int[] chartData;
	public String g_name;
	
	public double star;
	
	public MovieDTO(int m_no, String m_name, double star) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
		this.star = star;
	}

	public MovieDTO(int m_no, String m_name, int l_no, Date m_startdat, String m_plot, UserDTO[] re_coms, int[] chartData,
		String g_name, String m_dir) {
	super();
	this.m_no = m_no;
	this.m_name = m_name;
	this.l_no = l_no;
	this.m_startdat = m_startdat;
	this.m_plot = m_plot;
	this.re_coms = re_coms;
	this.chartData = chartData;
	this.g_name = g_name;
	this.m_dir = m_dir;
}

	public MovieDTO(int m_no, String m_name) {
		super();
		this.m_no = m_no;
		this.m_name = m_name;
	}
}
