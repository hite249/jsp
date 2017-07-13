package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface UserService {
	public ArrayList<HashMap> selectUserInfo(User user) throws SQLException;
	public boolean deleteUserInfo(User user) throws SQLException;
	public boolean insertUserInfo(User user) throws SQLException;
	
	

}
