package shionn.collections.db.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import shionn.collections.db.dbo.Collection;
import shionn.collections.db.dbo.Item;

public interface CollectionDao {

	@Select("SELECT * FROM item WHERE collection = #{collection} ORDER BY category, name ")
	List<Item> list(@Param("collection") Collection collection);

	@Insert("INSERT INTO item (name, author, numbers, complete, collection, year, qty, "
			+ "plateform, region, category, editor) "
			+ "VALUES (#{item.name}, #{item.author}, #{item.numbers}, #{item.complete}, "
			+ "#{item.collection}, #{item.year}, #{item.qty}, #{item.plateform}, "
			+ "#{item.region}, #{item.category}, #{item.editor})")
	int insert(@Param("item") Item item);

	@Select("SELECT * FROM item WHERE id = #{id} ")
	Item read(int id);

	@Update("UPDATE item SET " //
			+ "name       = #{item.name},       " //
			+ "author     = #{item.author},     " //
			+ "numbers    = #{item.numbers},    " //
			+ "complete   = #{item.complete},   " //
			+ "collection = #{item.collection}, " //
			+ "plateform  = #{item.plateform},  " //
			+ "region     = #{item.region},     " //
			+ "year       = #{item.year},       " //
			+ "category   = #{item.category},   " //
			+ "editor     = #{item.editor},     " //
			+ "qty        = #{item.qty}         " //
			+ "WHERE id   = #{item.id}")
	int save(@Param("item") Item item);

}
