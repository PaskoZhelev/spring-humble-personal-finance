/**
 * 
 */
package com.pmz.humble.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.pmz.humble.model.User;
import com.pmz.humble.utils.QueryUtils;
import com.pmz.humble.utils.StringUtils;


/**
 * @author pasko
 *
 */
@Component
public class UserDAO extends AbstractDAO {

	private static final String USER_COLUMNS = "id, username, password, email, registration_date, balance, currency_id";
	private static final String USER_COLUMNS_NO_ID = "username, password, email, registration_date, balance, currency_id";
	
	private UserRowMapper userRowMapper = new UserRowMapper();
	
	private class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getInt(1),
            		rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDate(5),
                    rs.getDouble(6),
                    rs.getInt(7));
        }
    }
		
	
	/**
	 * @param username
	 * @return User based on username
	 */
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
	
	/**
	 * @param username
	 * @return User based on user id
	 */
	public User getUserById(int id) {
		
        String sql = QueryUtils.getSelectStatementWithArgsAndWhere("users", USER_COLUMNS) + "id=?";
        
        List<User> users = query(sql, userRowMapper, id);
        User user = null;
        if(users.size() == 1) {
            user = users.iterator().next();
        } else if (users.size() > 1) {
            throw new RuntimeException("Too many matching users");
        }

        return user;
    }
	
	/**
     *
     * @param email The email address.
     * @return The user, or <code>null</code> if not found.
     */
    public User getUserByEmail(String email) {
        String sql = QueryUtils.getSelectStatementWithArgsAndWhere("users", USER_COLUMNS) + "email=?";
        return queryOne(sql, userRowMapper, email);
    }
	
    /**
     * Returns all users.
     *
     * @return Possibly empty array of all users.
     */
    public List<User> getAllUsers() {
        String sql = QueryUtils.getSelectAllStatement("users");
        List<User> users = query(sql, userRowMapper);
        return users;
    }
    
    /**
     * Creates a new user.
     *
     * @param user The user to create.
     */
    public void createUser(User user) {
        String sql = QueryUtils.getInsertStatement("users", USER_COLUMNS_NO_ID);
        Date today = new Date();       
        update(sql, user.getUsername(), StringUtils.encrypt(user.getPassword()), user.getEmail(), new Timestamp(today.getTime()),
                user.getBalance(), user.getCurrency().getId());
    }
    
    /**
     * Updates the given user.
     *
     * @param user The user to update.
     */
    public void updateUser(User user) {
        String sql = QueryUtils.getUpdateUserStatement();
        getJdbcTemplate().update(sql, StringUtils.encrypt(user.getPassword()), user.getEmail(), user.getBalance(),
                user.getCurrency().getId(), user.getUsername());
    }
    
    /**
     * Deletes the user with the given username.
     *
     * @param username The username.
     */
    public void deleteUser(String username) {       
        update("delete from users where username=?", username);   
    }

}
