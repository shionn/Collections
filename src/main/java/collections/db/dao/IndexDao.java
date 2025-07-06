package collections.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import collections.db.dbo.Collection;
import collections.db.dbo.Item;

public interface IndexDao {

	@Select("SELECT * FROM item ORDER BY updated DESC LIMIT 10")
	@Results({ @Result(column = "collection", property = "collection", one = @One(select = "readCollection")) })
	List<Item> lastUpdate();

	@Select("SELECT * FROM collection WHERE id = #{id}")
	Collection readCollection(int id);
}
