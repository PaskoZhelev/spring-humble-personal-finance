/**
 * 
 */
package com.pmz.humble.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.pmz.humble.model.User;
import com.pmz.humble.utils.QueryUtils;
import com.pmz.humble.utils.StringUtils;


/**
 * @author pasko
 *
 */
public class UserDAO extends AbstractDAO {

	private static final String USER_COLUMNS = "username, password, email, registration_date, balance, currency_id";
	
	private UserRowMapper userRowMapper = new UserRowMapper();
	
	private class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getString(1),
                    decrypt(rs.getString(2)),
                    rs.getString(3),
                    rs.getDate(4),
                    rs.getDouble(5),
                    rs.getInt(6));
        }
    }
	
	private static String encrypt(String s) {
        if (s == null) {
            return null;
        }
        try {
            return "enc:" + StringUtils.utf8HexEncode(s);
        } catch (Exception e) {
            return s;
        }
    }

    private static String decrypt(String s) {
        if (s == null) {
            return null;
        }
        if (!s.startsWith("enc:")) {
            return s;
        }
        try {
            return StringUtils.utf8HexDecode(s.substring(4));
        } catch (Exception e) {
            return s;
        }
    }
	
	public User getUserByName(String username) {
		
        String sql = QueryUtils.getSelectStatementWithArgsAndWhere("users", USER_COLUMNS) + "username=?";

        List<User> users = query(sql, userRowMapper, username);
        User user = null;
        if(users.size() == 1) {
            user = users.iterator().next();
        } else if (users.size() > 1) {
            throw new RuntimeException("Too many matching users");
        }

        return user;
    }
	

	
	
}
