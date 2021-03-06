package shionn.collections.db.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import shionn.collections.db.dbo.User;

public interface AuthenticationDao {

	@Select("SELECT  email, password " //
			+ "FROM user " //
			+ "WHERE email = #{email}")
	User readUser(@Param("email") String email);

}
