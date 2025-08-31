package movie.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import movie.dto.UserDTO;

public class AppContext {
	public static UserDTO loginUser;
	
	public static boolean isUnder19(Date birthDate) {
        LocalDate today = LocalDate.now();
        LocalDate birthLocalDate =  ((java.sql.Date) birthDate).toLocalDate();;
        LocalDate nineteenthBirthday = birthLocalDate.plusYears(19);
        return nineteenthBirthday.isAfter(today);
    }
}
