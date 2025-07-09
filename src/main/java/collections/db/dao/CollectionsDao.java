package collections.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import collections.db.dbo.Collection;
import collections.db.dbo.Item;

public interface CollectionsDao {

	@Select("SELECT * FROM collection WHERE parent = 0 ORDER BY name")
	List<Collection> listAll();

	@Select("SELECT * FROM collection WHERE id = #{id}")
	@Results({ @Result(column = "id", property = "id"),
			@Result(column = "id", property = "items", many = @Many(select = "listItems")),
			@Result(column = "id", property = "groups", many = @Many(select = "listGroups")),
	})
	Collection list(int id);

	@Select("SELECT * FROM collection WHERE parent = #{parent} ORDER BY name")
	@Results({ @Result(column = "id", property = "id"),
			@Result(column = "id", property = "items", many = @Many(select = "listItems")),
			@Result(column = "id", property = "groups", many = @Many(select = "listGroups")), })
	List<Collection> listGroups(int parent);

	@Select("SELECT * FROM item WHERE collection = #{parent} ORDER BY name")
	List<Item> listItems(int parent);

	@Insert("INSERT INTO item (collection, updated, author, complete, edition, name, numbers) "
			+ "VALUES (#{collection}, NOW(), #{item.author}, #{item.complete}, #{item.edition}, #{item.name}, #{item.numbers})")
	@Options(useGeneratedKeys = true, keyProperty = "item.id")
	int createItem(@Param("collection") int collection, @Param("item") Item item);

	@Select("SELECT * FROM item WHERE id = #{itemId}")
	Item readItem(int itemId);

	@Update("UPDATE item SET updated = NOW(), author = #{author}, complete = #{complete}, edition = #{edition}, name = #{name}, numbers = #{numbers} WHERE id = #{id}")
	void updateItem(Item item);

}
