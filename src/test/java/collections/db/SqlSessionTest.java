package collections.db;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SqlSessionTest {

	@Mock
	private org.apache.ibatis.session.SqlSession mockSession;

	private collections.db.SqlSession sqlSession;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		sqlSession = new collections.db.SqlSession(mockSession);

		// Default mock behaviors
		when(mockSession.getConfiguration()).thenReturn(new Configuration());
		when(mockSession.getConnection()).thenReturn(mock(Connection.class));
		when(mockSession.flushStatements()).thenReturn(new ArrayList<>());
		when(mockSession.getMapper(String.class)).thenReturn(mock(Object.class));
	}

	@Test
	public void testClearCache() {
		sqlSession.clearCache();
		verify(mockSession).clearCache();
	}

	@Test
	public void testClose() {
		sqlSession.close();
		verify(mockSession).close();
	}

	@Test
	public void testCommit() {
		sqlSession.commit();
		verify(mockSession).commit();
	}

	@Test
	public void testCommitWithForce() {
		sqlSession.commit(true);
		verify(mockSession).commit(true);
	}

	@Test
	public void testSelectOne() {
		String statement = "select * from table";
		Object expected = new Object();
		when(mockSession.selectOne(statement)).thenReturn(expected);

		Object result = sqlSession.selectOne(statement);

		assertThat(result).as("Should return the result from the session").isEqualTo(expected);
		verify(mockSession).selectOne(statement);
	}

	@Test
	public void testSelectOneWithParameter() {
		String statement = "select * from table";
		Object parameter = "param";
		Object expected = new Object();
		when(mockSession.selectOne(statement, parameter)).thenReturn(expected);

		Object result = sqlSession.selectOne(statement, parameter);

		assertThat(result).as("Should return the result from the session").isEqualTo(expected);
		verify(mockSession).selectOne(statement, parameter);
	}

	@Test
	public void testSelectList() {
		String statement = "select * from table";
		List<Object> expected = new ArrayList<>();
		when(mockSession.selectList(statement)).thenReturn(expected);

		List<Object> result = sqlSession.selectList(statement);

		assertThat(result).as("Should return the list from the session").isEqualTo(expected);
		verify(mockSession).selectList(statement);
	}

	@Test
	public void testSelectListWithParameter() {
		String statement = "select * from table";
		Object parameter = "param";
		List<Object> expected = new ArrayList<>();
		when(mockSession.selectList(statement, parameter)).thenReturn(expected);

		List<Object> result = sqlSession.selectList(statement, parameter);

		assertThat(result).as("Should return the list from the session").isEqualTo(expected);
		verify(mockSession).selectList(statement, parameter);
	}

	@Test
	public void testSelectListWithRowBounds() {
		String statement = "select * from table";
		Object parameter = "param";
		RowBounds rowBounds = new RowBounds();
		List<Object> expected = new ArrayList<>();
		when(mockSession.selectList(statement, parameter, rowBounds)).thenReturn(expected);

		List<Object> result = sqlSession.selectList(statement, parameter, rowBounds);

		assertThat(result).as("Should return the list from the session").isEqualTo(expected);
		verify(mockSession).selectList(statement, parameter, rowBounds);
	}

	@Test
	public void testSelectMapWithKey() {
		String statement = "select * from table";
		String mapKey = "key";
		Map<String, Object> expected = new HashMap<>();
		when(mockSession.selectMap(statement, mapKey)).thenReturn((Map) expected);

		Map<String, Object> result = sqlSession.selectMap(statement, mapKey);

		assertThat(result).as("Should return the map from the session").isEqualTo(expected);
		verify(mockSession).selectMap(statement, mapKey);
	}

	@Test
	public void testSelectMapWithParameterAndKey() {
		String statement = "select * from table";
		Object parameter = "param";
		String mapKey = "key";
		Map<String, Object> expected = new HashMap<>();
		when(mockSession.selectMap(statement, parameter, mapKey)).thenReturn((Map) expected);

		Map<String, Object> result = sqlSession.selectMap(statement, parameter, mapKey);

		assertThat(result).as("Should return the map from the session").isEqualTo(expected);
		verify(mockSession).selectMap(statement, parameter, mapKey);
	}

	@Test
	public void testSelectMapWithParameterKeyAndRowBounds() {
		String statement = "select * from table";
		Object parameter = "param";
		String mapKey = "key";
		RowBounds rowBounds = new RowBounds();
		Map<String, Object> expected = new HashMap<>();
		when(mockSession.selectMap(statement, parameter, mapKey, rowBounds)).thenReturn((Map) expected);

		Map<String, Object> result = sqlSession.selectMap(statement, parameter, mapKey, rowBounds);

		assertThat(result).as("Should return the map from the session").isEqualTo(expected);
		verify(mockSession).selectMap(statement, parameter, mapKey, rowBounds);
	}

	@Test
	public void testSelectCursor() {
		String statement = "select * from table";
		Cursor<Object> expected = mock(Cursor.class);
		when(mockSession.selectCursor(statement)).thenReturn(expected);

		Cursor<Object> result = sqlSession.selectCursor(statement);

		assertThat(result).as("Should return the cursor from the session").isEqualTo(expected);
		verify(mockSession).selectCursor(statement);
	}

	@Test
	public void testSelectCursorWithParameter() {
		String statement = "select * from table";
		Object parameter = "param";
		Cursor<Object> expected = mock(Cursor.class);
		when(mockSession.selectCursor(statement, parameter)).thenReturn(expected);

		Cursor<Object> result = sqlSession.selectCursor(statement, parameter);

		assertThat(result).as("Should return the cursor from the session").isEqualTo(expected);
		verify(mockSession).selectCursor(statement, parameter);
	}

	@Test
	public void testSelectCursorWithParameterAndRowBounds() {
		String statement = "select * from table";
		Object parameter = "param";
		RowBounds rowBounds = new RowBounds();
		Cursor<Object> expected = mock(Cursor.class);
		when(mockSession.selectCursor(statement, parameter, rowBounds)).thenReturn(expected);

		Cursor<Object> result = sqlSession.selectCursor(statement, parameter, rowBounds);

		assertThat(result).as("Should return the cursor from the session").isEqualTo(expected);
		verify(mockSession).selectCursor(statement, parameter, rowBounds);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSelectWithHandler() {
		String statement = "select * from table";
		Object parameter = "param";
		ResultHandler<Object> handler = mock(ResultHandler.class);
		sqlSession.select(statement, parameter, handler);
		verify(mockSession).select(statement, parameter, handler);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSelectWithHandlerOnly() {
		String statement = "select * from table";
		ResultHandler<Object> handler = mock(ResultHandler.class);
		sqlSession.select(statement, handler);
		verify(mockSession).select(statement, handler);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSelectWithParameterRowBoundsAndHandler() {
		String statement = "select * from table";
		Object parameter = "param";
		RowBounds rowBounds = new RowBounds();
		ResultHandler<Object> handler = mock(ResultHandler.class);
		sqlSession.select(statement, parameter, rowBounds, handler);
		verify(mockSession).select(statement, parameter, rowBounds, handler);
	}

	@Test
	public void testInsert() {
		String statement = "insert into table";
		int expected = 1;
		when(mockSession.insert(statement)).thenReturn(expected);

		int result = sqlSession.insert(statement);

		assertThat(result).as("Should return the insert count").isEqualTo(expected);
		verify(mockSession).insert(statement);
	}

	@Test
	public void testInsertWithParameter() {
		String statement = "insert into table";
		Object parameter = "param";
		int expected = 1;
		when(mockSession.insert(statement, parameter)).thenReturn(expected);

		int result = sqlSession.insert(statement, parameter);

		assertThat(result).as("Should return the insert count").isEqualTo(expected);
		verify(mockSession).insert(statement, parameter);
	}

	@Test
	public void testUpdate() {
		String statement = "update table";
		int expected = 1;
		when(mockSession.update(statement)).thenReturn(expected);

		int result = sqlSession.update(statement);

		assertThat(result).as("Should return the update count").isEqualTo(expected);
		verify(mockSession).update(statement);
	}

	@Test
	public void testUpdateWithParameter() {
		String statement = "update table";
		Object parameter = "param";
		int expected = 1;
		when(mockSession.update(statement, parameter)).thenReturn(expected);

		int result = sqlSession.update(statement, parameter);

		assertThat(result).as("Should return the update count").isEqualTo(expected);
		verify(mockSession).update(statement, parameter);
	}

	@Test
	public void testDelete() {
		String statement = "delete from table";
		int expected = 1;
		when(mockSession.delete(statement)).thenReturn(expected);

		int result = sqlSession.delete(statement);

		assertThat(result).as("Should return the delete count").isEqualTo(expected);
		verify(mockSession).delete(statement);
	}

	@Test
	public void testDeleteWithParameter() {
		String statement = "delete from table";
		Object parameter = "param";
		int expected = 1;
		when(mockSession.delete(statement, parameter)).thenReturn(expected);

		int result = sqlSession.delete(statement, parameter);

		assertThat(result).as("Should return the delete count").isEqualTo(expected);
		verify(mockSession).delete(statement, parameter);
	}

	@Test
	public void testRollback() {
		sqlSession.rollback();
		verify(mockSession).rollback();
	}

	@Test
	public void testRollbackWithForce() {
		sqlSession.rollback(true);
		verify(mockSession).rollback(true);
	}

	@Test
	public void testFlushStatements() {
		List<BatchResult> expected = new ArrayList<>();
		when(mockSession.flushStatements()).thenReturn(expected);

		List<BatchResult> result = sqlSession.flushStatements();

		assertThat(result).as("Should return the flush statements list").isEqualTo(expected);
		verify(mockSession).flushStatements();
	}

	@Test
	public void testGetConfiguration() {
		Configuration config = mock(Configuration.class);
		when(mockSession.getConfiguration()).thenReturn(config);

		Configuration result = sqlSession.getConfiguration();

		assertThat(result).as("Should return the configuration").isEqualTo(config);
		verify(mockSession).getConfiguration();
	}

	@Test
	public void testGetMapper() {
		Class<Object> type = Object.class;
		Object expected = mock(Object.class);
		when(mockSession.getMapper(type)).thenReturn(expected);

		Object result = sqlSession.getMapper(type);

		assertThat(result).as("Should return the mapper").isEqualTo(expected);
		verify(mockSession).getMapper(type);
	}

	@Test
	public void testGetConnection() {
		Connection conn = mock(Connection.class);
		when(mockSession.getConnection()).thenReturn(conn);

		Connection result = sqlSession.getConnection();

		assertThat(result).as("Should return the connection").isEqualTo(conn);
		verify(mockSession).getConnection();
	}

	@Test
	public void testDestroy() throws Exception {
		sqlSession.destroy();
		verify(mockSession).rollback();
		verify(mockSession).close();
	}
}
